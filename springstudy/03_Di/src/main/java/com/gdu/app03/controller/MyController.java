package com.gdu.app03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app03.domain.Board;
import com.gdu.app03.domain.Notice;

@Controller
public class MyController {
	
	/*
		@@RequestMapping(value="/", method=RequestMethod.GET)
		@@RequestMapping(value="/", method=RequestMethod.POST)
		
		Spring4 부터 새로운 애너테이션으로 바꿀 수 있다.
			@GetMapping("/")
			@PostMapping("/")
		
	*/
	
	@GetMapping("/") // http://localhost:9090/app03 으로 접속하면 처리되는 메소드
	public String welcome() {
		return "default";
		// ViewResolver에 의해서
		// return "/WEB-INF/views/default.jsp"로 해석된다.
	}
	
	
	
	/**********************************************************************************/
	
	
	/*
	 	Container에 등록된 Bean을 가져오는 방법		(* 애너테이션 사용)
	 	
	 	 -- 요약 설명 -------------------------------------------------------------------------------
	 		1) @Inject    : 타입(class)이 일치하는 Bean을 가져오는 애너테이션 (* 옛날...)
	 		2) @Resource  : 이름(id)이    일치하는 Bean을 가져오는 애너테이션
	 	 ★ 3) @Autowired : 타입(class)이 일치하는 Bean을 가져오는 애너테이션 (*실무에서 주로 사용*)
	 	    			  : 일단 타입(class)확인 → 동일 타입이 다수 발견되면 이름(id)으로 확인
	 	 --------------------------------------------------------------------------------------------
 	    // 상세 설명
 	    	1. @Inject
 	    		1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
 	    		2) 동일 타입이 여러 개 있는 경우 @Qualifier를 이용해서 Bean을 생성
 	    	
 	    	2. @Resource
 	    	 	1) 이름(id)이 일치하는 Bean을 가져오는 애너테이션
 	    	3. @Autowired 
 	    		1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
 	    		2) 동일 타입이 여러 개 있는 경우 자동으로 @Qualifier를  등록해서 Bean을 생성
 	    		3) 실무에서 주로 사용
	 	    	
	*/
	
	/*
		@Autowired 사용 방법
		
		1. 필드로 생성된 Bean 가져오기
			1) 필드마다 @Autowired를 추가한다.	(ex.필드가 10개이면 @Autowired도 10번 작성)
			2) 필드가 많으면 사용하지 않는다.
		
		2. 생성자를 이용해 Bean을 가져오기
			1) 생성자의 매개변수로 Bean을 가져온다.
			2) @Autowired를 작성할 필요가 없다.
			
		3. 메소드를 이용해 Bean을 가져오기
			1) 메소드의 매개변수로 Bean을 가져온다.
			2) @Autowired를 작성해야 한다.
			3) 일반적으로 setter를 사용하지만 setter가 아니어도 상관없다.
	*/
	
	
	
	// 1. 필드로 생성된 Bean 가져오기
	/*
	@Autowired
	private Board board;
	*/
	
	/*
		@Autowired는 타입(class)이 일치하는 Bean을 Container에서 가져온다.
		
		@Autowired
		 private Board board; // 타입이 Board인 Bean을 Container에서 가져온다.
		 
		----- Container -----------------
		<bean id="board1" class="Board">
		<!-- <bean id="board2" class="Board"> -->
		---------------------------------
	*/
	

	
	
	// 2. 생성자를 이용해 Bean 가져오기
	// 생성자에는 @Autowired를 생략할 수 있다.
	
	/*
		private Board board;
		public MyController(Board board) {
			// 매개변수 Board board로 타입이 Board인 Bean을 Container에서 가져온다.
			super();
			this.board = board;
		}
	*/
	
	
	
	
	
	// 3. 메소드를 이용해 Bean 가져오기
	/*
	private Board board;
	
	@Autowired	// 일반 메소드는 반드시 @Autowired를 작성해야 한다 !! ★
	public void setBoard(Board board) {
		// 매개변수 Board board로 타입의 Bean이 Container에서 가져온다.
		this.board = board;
	}
	*/

	
	

	
	// 4. 동일한 타입의 Bean이 여러 개 등록된 경우
	//	1) 변수명을 자동으로 식별자(Qualifier)로 인식한다.
	//	2) 식별자(@Qulifier)는 Bean의 이름(id)이 일치하는 Bean을 가져온다.
	
	
	// 4-1. 필드로 생성된 Bean 가져오기
	/*
	@Autowired
	private Board board1;
	
	@Autowired
	private Board board2;
	*/
	
	// 4-2. 생성자를 이용해 Bean 가져오기
	/*
	private Board b1;
	private Board b2;
	public MyController(Board board1, Board board2) {
		// 매개변수명이 Bean의 이름(id)과 일치하므로 자동으로 주입된다.
		b1 = board1;
		b2 = board2;
	}
	*/
	
	// 4-3. 메소드를 이용해 Bean 가져오기
	private Board b1;
	private Board b2;
	
	@Autowired
	public void setBoard(Board board1, Board board2) {
		this.b1 = board1;
		this.b2 = board2;
	}



	@GetMapping("board/detail") 	// @GetMapping("/board/detail")	(* → '/'로 시작하든 안 하든 상관없다!)
	public void boardDetail() {
		System.out.println(b1.getBoardNo());
		System.out.println(b1.getTitle());
		System.out.println(b1.getCreateDate());
		System.out.println(b2.getBoardNo());
		System.out.println(b2.getTitle());
		System.out.println(b2.getCreateDate());
	}
	
	
	// @Autowired를 사용하는 이유
	//	: @Inject + @Qualifier
	//  두 개를 합쳐, 작업을 따로하지 않아도 되기 때문에 @Autowired를 사용한다.
	// * TIP. @Autowired를 사용하지 않는다면, 옛날 코드일 가능성이 높으므로 활용하지 않도록 한다.
	/*
	@Inject
	@Qualifier(value="board1")
	private Board b1;
	
	@Inject
	@Qualifier(value="board2")
	private Board b2;
	*/
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//* 1. 필드로 만드는 방법	
	/*
	@Autowired
	private Notice notice1;
	@Autowired
	private Notice notice2;
	*/
	
	//* 2. 생성자, 메소드로 만드는 방법
	private Notice n1;
	private Notice n2;
	public MyController(Notice notice1, Notice notice2) {
		n1 = notice1;
		n2 = notice2;
	}
	
	@GetMapping("notice/detail")
	public void noticeDetail() {
	System.out.println(n1.getNoticeNo());
	System.out.println(n1.getTitle());
	System.out.println(n2.getNoticeNo());
	System.out.println(n2.getTitle());
	}
}
