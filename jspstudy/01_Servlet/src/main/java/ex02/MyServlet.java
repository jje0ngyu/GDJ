package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/my")	// @WebServlet({"/my", "/me"})	처럼 2개 이상의 URL Mapping을 지정할 수 있다. 
                    // * 즉, 2가지 주소를 가지게 된다. 둘 중 어느 것을 입력하더라도 해당 서블릿 주소로 이동한다.
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		// 		1) 클라이언트 → 서버로 보내는 요청 또는 데이터
		//	    2) HttpServletRequest request 객체가 처리 (Tomcat이 있어야 사용가능)
		
		// 1) 요청에 포함된 한글 처리(문자셋 : UTF-8)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 파라미터(Parameter) 확인
		//		(1) URL?파라미터=값&파라미터=값
		// 		(2) 모든 파라미터는 String 타입!!
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		
		// null처리
		int age = 0;
		if (strAge != null) {
			age = Integer.parseInt(strAge);			
		}
		
		// 2. 응답
		// 		1) 서버 → 클라이언트로 보내는 응답
		//		2) HttpServletResponse response 객체가 처리 (Tomcat이 있어야 사용가능)
		
		// 1) 사용자(클라이언트)에게 전달할 데이터의 형식을 HTML 문서로 결정한다.	(*mime-type)
		//		MIME-TYPE을 활용	(*setContentType에 작성한다.)
		//			(1) HTML : text/html
		//			(2) CSS  : text/css
		//			(3) JS   : text/javascript
		//			(4) XML  : application/xml
		//			(5) JSON : application/json
		response.setContentType("text/html");
		
		// 2) 응답에 포함되는 한글 처리
		response.setCharacterEncoding("UTF-8");
		
		// ★ 1) MIME-TYPE + 2) 문자셋  (*동시처리)
		response.setContentType("text/html; charset=UTF-8");
		
		// 3) 응답 스트림 생성
		//		(1) 문자 출력 스트림(* Writer)을 생성
		//		(2) response 객체로부터 PrintWriter 객체를 얻을 수 있다.
		//			-IOException 예외 처리가 필요하지만 이미 처리되어 있다.
		//			-write() 메소드보다는 print()/println() 메소드를 사용하는 것을 권장
		PrintWriter out = response.getWriter();
		
		// 4) 응답 만들기 (HTML 문서 만들기)
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>");
		out.println("나의 첫 번째 응답");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. " + name + "님 반갑습니다 ♥</h1>");
		if(age >= 20) {
			out.println("<h1>귀하는 " + age + "살이므로 입장이 가능합니다.</h1>");
		} else {
			out.println("<h1>" + age + "살? 애들은 다음에</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		
		out.flush(); 	// 출력 스트림에 남아 있는 모든 데이터 내보내기
		out.close();	// * 스트림 작업 시 반드시 필요!!
	}

	/*
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
