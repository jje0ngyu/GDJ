package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("board") 		// URL Mapping이 board로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController2 {
	
	/*	---	※ 까먹으면 죽음뿐이다. --------------------------------------------------------
		
		1. forward
		return "baord/detail";
		
		해석 : board 폴더 아래에 detail.jsp로 forward 하시오.
		
	 
	 	2. redirect
	 	return "redirect:/board/detail";
	 	
	 	해석 : URL Mapping값이 /board/detail인 새로운 요청으로 redirect 하시오.
	 
	 
	 	▷ 요약 : redirect    없으면 .jsp 	  있으면 Mapping
	------------------------------------------------------------------------------------ */
	

	// <a href="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	@GetMapping("detail1")
	public String detail1(HttpServletRequest request) {
	
		// ▷ 한 번 받은 요청을 redirect 하기 위해선
		//	  다시 요청값을 저장 후, 요청하면 된다!
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		request.setAttribute("title", title);
		request.setAttribute("hit", hit);
		
		return "redirect:/board/detail2?title=" + title + "&hit=" + hit;
		// 새로운 요청 /board/detail2?title=공지사항&hit=10 처리하시오.
		//* redirect: 뒤에 오는 것(/board/detail2)은 URL Mapping 값이다.
		//* detail2 는 아래 작성된 @GetMapping("detail2")을 의미한다.
	}

	@GetMapping("detail2")
	public String detail2(String title, int hit, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		return "board/detail";
	}
	
}
