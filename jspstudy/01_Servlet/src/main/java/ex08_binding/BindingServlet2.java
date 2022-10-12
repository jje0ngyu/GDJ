package ex08_binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BindingServlet2")

public class BindingServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ServletContext 
		ServletContext ctx = getServletContext();
		int a = (int)ctx.getAttribute("a");	// 캐스팅이 필요하다.
		
		
		// HttpSession
		HttpSession session = request.getSession();
		int b = (int)session.getAttribute("b");
		
		// HttpServletRequest
		//int c = (int)request.getAttribute("c");   //* null 값이 올 경우, 에러 500이 발생
		Object c = request.getAttribute("c");		//* null 값이 오면 null값 출력
	
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>a=" + a + ", b=" + b + ", c=" + c + "</h1>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
