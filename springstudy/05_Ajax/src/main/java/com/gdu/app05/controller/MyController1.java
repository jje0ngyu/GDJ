package com.gdu.app05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Member;
import com.gdu.app05.service.MemberService;

@Controller
public class MyController1 {

	@GetMapping("/")
	public String index() {
		return "index";		// index.jsp로 forward
	}
	
	@GetMapping("member")
	public String member() {
		return "member";	// member.jsp로 forward
	}
	
	
	
	// field
	@Autowired	// Container(root-context.xml)에서 타입(class)이 일치하는 bean을 가져오세요.
	private MemberService memberService;
	
	/*
	 	@ResponseBody
	 	" 안녕!!!!!!!! 난 ajax 처리하는 메소드야 !
	 	  내가 반환하는 값은 뷰(JSP) 이름이 아니고,
	 	  					 어떤 데이터(text, json, xml 등)야 !! "
	
	*/
	@ResponseBody
	@GetMapping(value="member/detail1"
			  , produces="text/plain; charset=UTF-8")	// produces : 응답 데이터 타입(MIME-TYPE)
	public String detail1(HttpServletRequest request, HttpServletResponse response) {
		String str = memberService.execute1(request, response);
		return str;
	/* --------------------------------------------
	 @ResponseBody 가 있으므로,
	 	return str은 str.jsp를 의미하는 것이 아니라,
	 	str에 값을 반환하라는 의미가 된다.
	------------------------------------------------
	*/
	}
	
	@ResponseBody
	@GetMapping(value="member/detail2"
			  , produces="application/json; charset=UTF-8")
	public Member detail2(@RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		Member member = memberService.execute2(id, pw);
		return member; // member 객체를 {"id":아이디, "pw":패스워드} 형식의 JSON으로 바꿔서 전달합니다. (* 누가? Jackson 이!)
		/*
			잭슨을 사용하므로써 사라진 추억의 코드 
			JSONObject obj = new JSONObject(member);
			return obj.toString();
		*/
	}
	
	@ResponseBody
	@GetMapping(value="member/detail3"
			  , produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> detail3(Member member){
		Map<String, Object> map = memberService.execute3(member);
		return map;
		// return memberService.execute3(member);
	}
	
}
