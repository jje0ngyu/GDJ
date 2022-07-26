package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		long freeNo = Long.parseLong(opt.orElse("0"));
	
		long hit = 0;
		FreeService serviece = new FreeHitCountService();
		
		request.setAttribute("free", FreeDAO.getInstance().selectFreeByNo(freeNo));
		
		
		return new ActionForward("/free/detail.jsp", false);
	}

}
