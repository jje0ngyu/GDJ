package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		// 요청 파라미터
		String title = request.getParameter("title");
		String conctent = request.getParameter("content");
		
		// DB로 보낼  Board 생성
		Board board = new Board();
		board.setTitle(title);
		board.setContent(conctent);
		
		// DB로 Board 보냄 (삽입)
		int result = BoardDao.getInstance().insertBoard(board);
		
		// 이번엔 삽입 성공/실패 처리는 하지 않음
		System.out.println("삽입 결과 : " + result);
		
		// 어디로, 어떻게 (INSERT, UPDATE, DELETE 이후에는 Redirect)
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do"); // Redirect할 때는 대부분 매핑으로 요청
		af.setRedirect(true);		  // INSERT, UPDATE, DELETE 이후에는 Redirect
		
		return af;
	}

}
