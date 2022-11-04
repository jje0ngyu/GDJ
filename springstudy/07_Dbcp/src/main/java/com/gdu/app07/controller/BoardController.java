package com.gdu.app07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.service.BoardService;

@Controller
public class BoardController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/*********************************************************************************/
	
	private BoardService boardService;
	
	
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	/* -------------------------------------------------------------------------------
	 Q. @Autowired가 없는데 왜 작동하나요?
	 
	 A. 필드를 이용한 생성자의 경우 자동으로 @Autowired가 생성됩니다. (생략되어 있지만 애너테이션이 작동한다.)
		즉, 이 코드에는 현재 @Autowired가 동작하고 있습니다.
				▷ 이 생성자의 경우, @Allargsconstructor 로 대체할 수 있다.
	 **********************************************************************************/
	

	// 목록보기
	@GetMapping("brd/list")
	public String list(Model model) {
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";
	}
	
	
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

	
	@PostMapping("brd/remove")
	public String remove(int board_no) {
		boardService.removeBoard(board_no);		// removeBoard() 로부터 0/1 이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
	
}
