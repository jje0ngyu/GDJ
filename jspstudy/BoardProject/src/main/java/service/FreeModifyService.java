package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeModifyService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 요청 파라미터
		long freeNo = Long.parseLong(request.getParameter("freeNo"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getParameter("ip");
		long hit = Long.parseLong(request.getParameter("hit"));
		
		Free free = new Free();
		free.setFreeNo(freeNo);
		free.setWriter(writer);
		free.setTitle(title);
		free.setContent(content);
		free.setIp(ip);
		free.setHit(hit);
		
		int result = FreeDAO.getInstance().updateFree(free);
		
		// 수정 성공/실패
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 수정되었습니다.')");
			out.println("location.href='"+ request.getContextPath()+"/free/detail.do?freeNo="+ freeNo +"'");
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
