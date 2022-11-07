package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeAddService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		long hit = 0;
		
		// IP
		String ip = request.getRemoteAddr();

		Free free = new Free();
		free.setWriter(writer);
		free.setTitle(title);
		free.setContent(content);
		free.setIp(ip);
		free.setHit(hit);
		
		// DB에 Student student 삽입
		int result = FreeDAO.getInstance().insertFree(free);
		
		// 삽입 성공/실패
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='"+ request.getContextPath()+"/free/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글 등록이 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		out.close();
		
		return null;	// Service를 통해서 직접 응답했기 때문에 컨트롤러로 null을 반환
						// 컨트롤러가 null을 반환받으면 Redirect/Forward 모두 수행하지 않는다.
	
	}

}
