package com.gdu.app06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app06.service.BoardService;

@Controller
public class BoardController {

	/* --------------------------------------------------------------------------
	  ■ Controller 작성을 위한 기초 작업 ■
	
		1. 시작 페이지를 작성한다.
		
		2. BoardService를 작업한다. ▷ Controller는 Service를 활용하기 때문이다.
	----------------------------------------------------------------------------- */
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/* --------------------------------------------------------------------------
	  ■ Controller 작업 순서 ■
	
		1. 필드(field)로 BoardService를 선언한다.
	----------------------------------------------------------------------------- */
	@Autowired
	private BoardService boardService;
	
	
	
	@GetMapping("brd/list")
	public String list(Model model) {
		//* jsp 에서는 forward를 위해 request를 사용한다.
		// spring 에서는 보안을 위해 Model을 사용한다.
		// Model에 forward할 속성(Attribute)를 저장한다.
		
		model.addAttribute("boards", boardService.findAllBoards());
		// addAttribute("부여할속성이름", 실제로가져올데이터)
		
		return "board/list";
				//board 폴더의 list.jsp로 forward
	}
	
	
	
	@GetMapping("board/detail")
	public String detail() {
		return "board/detail";
	}
}
