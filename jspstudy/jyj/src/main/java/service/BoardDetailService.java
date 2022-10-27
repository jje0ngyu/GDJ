package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardDetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo =  Integer.parseInt(opt.orElse("0"));
		
		request.setAttribute("board", BoardDao.getInstance().selectBoardByNo(boardNo));
		
		// detail.jsp로 포워딩
		return new ActionForward("/board/detail.jsp", false);
	}

}
