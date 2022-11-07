package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDAO;

public class FreeHitCountService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		// 요청 파라미터
		long freeNo = Long.parseLong(opt.orElse("0"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getParameter("ip");
		long hit = Long.parseLong(request.getParameter("hit")) + 1;
		
		Free free = new Free();
		free.setFreeNo(freeNo);
		free.setWriter(writer);
		free.setTitle(title);
		free.setContent(content);
		free.setIp(ip);
		free.setHit(hit);
		
		int result = FreeDAO.getInstance().updateFree(free);
		return null;
	}

}
