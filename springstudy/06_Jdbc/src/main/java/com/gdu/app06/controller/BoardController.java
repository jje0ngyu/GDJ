package com.gdu.app06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app06.domain.BoardDTO;
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
	
	
	// 목록보기
	@GetMapping("brd/list")
	public String list(Model model) {
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";
	}
		/*
			■ 설명 ■
		
			1. Model 을 사용하는 이유!!
					▷ JSP에서는 forward를 위해 request를 사용하지만,
					   Spring에서는 보안을 위해 Model을 사용한다.
					   
			2. Model 에 forward할 속성(Attribute)을 저장한다.
					▷ model.addAttribute("생성할이름", 실제가져올데이터());
					
			3. return "board/list";
					▷ board 폴더의 list.jsp로 forward
		 */
	
	
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write"; //board 폴더의 write.jsp로 forward
	}
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board);	// saveBoard() 로부터 0/1 이 반환되지만 처리하지 않았다.
		// insert update delete는 insert후 redirect한다.
		return "redirect:/brd/list";
	}
	
	
	
	
	
	@GetMapping("brd/detail")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no
						, Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/detail";
	}
	/* ------------------------------------------------------------------------------------------
		왜 findBoardByNo 할 때 @RequestParam 을 사용할까?
				▷ board_no 가 전달되지 않았을 때를 대비하기 위해서 꼭 사용한다.
				
		상세보기의 경우 forward 하였으므로, Model을 사용하여 파라미터값을 저장하도록 한다.
	--------------------------------------------------------------------------------------------- */
	
	
	/* ------------------------------------------------------------------------------------------
		수정하는 과정 (2가지 메소드 사용)
		
		1. 수정할 페이지로 이동한다. (edit.jsp)   ▷ 기존에 있던 데이터를 불러온다. (Model 사용)
		2. 수정한 것을 이동시킨다.   (detail.jsp) ▷ 새로 입력받은 데이터를 전달한다.
	--------------------------------------------------------------------------------------------- */
	@PostMapping("brd/edit")
	public String edit(int board_no
					 , Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/edit";
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);	// modifyBoard() 로부터 0/1 이 반환되지만 처리하지 않았다.
		return "redirect:/brd/detail?board_no=" + board.getBoard_no();
		
	}
		/*
			■ 설명 ■
		
			1. edit() 에서 boardService.findBoardByNo(board_no)를 사용하는 이유
					▷ edit는 특정 게시물을 불러와 수정하는 작업이므로
					   게시글번호(board_no)로 데이터를 불러오도록 했다.
					   
			2. modify() 에서 <form>으로 전달받은 데이터가 없으므로 Model을 사용하지 않았다.
						return 할 때, redirect로 이동하므로 주소창에 이동할 게시글번호(board_no)를 꼭 전달해야 한다.
		*/


	
	@PostMapping("brd/remove")
	public String remove(int board_no) {
		boardService.removeBoard(board_no);		// removeBoard() 로부터 0/1 이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
	
}
