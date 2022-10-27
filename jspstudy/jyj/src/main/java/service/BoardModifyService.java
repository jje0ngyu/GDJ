package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardModifyService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// DB로 보낼 Board board 생성
		Board board = Board.builder()
				.boardNo(boardNo)
				.name(name)
				.title(title)
				.content(content)
				.build();
		
		// DB로 Board board 보내기(수정)
		int result = BoardDao.getInstance().updateBoard(board);
		
		// 수정 성공 / 실패
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 수정되었습니다.')");
			out.println("location.href='"+ request.getContextPath()+"/board/detail.do?boardNo="+ boardNo +"'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글 수정이 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");			
		}
		out.close();
		
		return null;

	}

}