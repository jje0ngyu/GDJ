package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.Member;




@RequestMapping("member") 		// URL Mapping이 member로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController1 {

	/* 	--- ■ detail1 : <a> 태그 방식 요약 ----------------------------------------------------------------------
	 			1. @GetMapping 호출
	 			2. HttpServletRequest 호출
	 			3. request.getParameter("String");
	 			4. request.setAttribute 에 forward할 데이터 request 담기
		----------------------------------------------------------------------------------------------------------  */
	
	
	// <a href="${contextPath}/member/detail1">
	@GetMapping("detail1")		// member/detail1 요청을 처리
	public String detail1(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 request에 담아 두는 방법
		request.setAttribute("member", member);
		
		
		return "member/detail";  //member폴더의 detail.jsp로 페이지 이동(forward)
	}
	
	
	
	/* 	--- ■ detail2 : location 방식1 요약 ---------------------------------------------------------------------
	 			1. @GetMapping 호출
	 			2. @RequestParam 호출
	 					2-1. 파라미터 값이 반드시 전달될 필요없을 경우 : required=false 메소드 추가
	 					2-2. 파라미터 값이 전달되지 않을 경우 default값 설정 : defaultValue = ""
	 					2-3. forward할 데이터를 저장할 Model moder 추가
	 			3. model.addAttribute 에 forward할 데이터 request 담기
	 	----------------------------------------------------------------------------------------------------------  */
	
	// location.href='${contextPath}/member/detail2?id=admin&pw=1234';
	@GetMapping("detail2")
	public String detail2 (@RequestParam(value="id", required=false, defaultValue="master") String id	// 파라미터 id를 String id에 저장하시오.
						 , @RequestParam(value="pw", required=false, defaultValue="1111") String pw	// 파라미터 pw를 String pw에 저장하시오.
						 , Model model) {
		/*
			@RequestParam
				1. value        : 파라미터 이름
				2. required     : 파라미터의 필수 여부(디폴트는 true)
				3. defaultValue : 파라미터가 없을 때 사용할 값
		*/
		
		Member member = new Member(id, pw);
		// forward할 데이터를 model에 담아 두는 방법 (this's 스프링 style~♬)
		// request를 이용하는 방식에 비해 보안이 향상되었다.
		model.addAttribute("member", member);	// model은 request를 저장소로 사용한다.
		
		return "member/detail";  //member폴더의 detail.jsp로 페이지 이동(forward)
		
	}
	
	
	/* 	--- ■ detail3 : location 방식2 요약 ---------------------------------------------------------------------
	 			1. @RequestParam 호출을 하지 않아도 된다. ★
	 			2. 파라미터 값이 없을 경우 'null'을 받는다.
	 	----------------------------------------------------------------------------------------------------------  */	
	//location.href='${contextPath}/member/detail2?id=admin&pw=1234';
	@GetMapping("detail3")
	public String detail3(String id		// @RequestParam은 생략할 수 있다. 파라미터 id가 없는 경우 null이 저장된다.
						, String pw		// @RequestParam은 생략할 수 있다. 파라미터 pw가 없는 경우 null이 저장된다.
						, Model model) {
		
		Member member = new Member(id, pw);
		
		model.addAttribute("member", member);
		
		return "member/detail";
	}
	
	
	
	/*	--- ■ detail4 : form 방식 요약 --------------------------------------------------------------------------
	 			1. 요청메소드 (get,post) 상관없다
	 			2. model.addAttribute 에 전달할 값을 입력한다.
	 	----------------------------------------------------------------------------------------------------------  */	
	// <form action="${contextPath}/member/detail4" method="get"> ■ 요청 메소드가 "get"일 경우!
	@GetMapping("detail4")
	public String getDetail4(Member member	// 파라미터 id, pw를 setId(), setPw() 메소드를 이용하여 member 객체에 저장해 준다.
						   , Model model) {
		model.addAttribute("member", member);
		
		return "member/detail";
	}
	
	// <form action="${contextPath}/member/detail4" method="post"> ■ 요청 메소드가 "post"일 경우!
	@PostMapping("detail4")	// 요청 : URLMapping + 요청메소드
	/*
	public String postDetail4(Member member) {
		return "member/detail";
	}
	*/
	public String postDetail4(@ModelAttribute(value="member") Member member) {
		// 파라미터 id,pw를 이용해 Member meber를 만들고,
		// Model에 member라는 이름의 속성으로 저장한다.
		
		return "member/detail";
	}
	
}
