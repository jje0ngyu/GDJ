package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//* ajax 통신은 페이지가 바뀌지 않기 때문에, Redirect / Forward가 필요없다.
	//* ★ ajax 통신은 페이지 이동이 없고, mvc는 페이지 이동이 있다.
	
}
