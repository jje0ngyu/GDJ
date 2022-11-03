package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.repository.BoardDAO;

/*----------------------------------
 ■ 작업 순서 ■
 
 BoardDAO 의 기초 작업 후, 생성
 → BoardDAO 메소드 작업 후, 작성
------------------------------------ */


/*----------------------------------
 @Service : Service 전용 @Component
------------------------------------ */
@Service
public class BoardSeriveImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
		/*
			■ 설명 ■
		
			Service(패키지)는 언제나 DAO를 사용한다!! 
					▷ field로 DAO를 선언
					
			@Autowired를 이용해 Container에 생성된 boardDAO타입 Bean을 가져온다.
			
			-------------------------------------------------------------------------------------------------------------------
		
			■ 추가 설명 ■
			
			스프링에서는 singleton패턴을 작성하지 않는다.
			스프링에서 알아서 singleton으로 작동하기 때문이다.
			
		 */
	
	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		return dao.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}

}
