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

@WebServlet("/BindingServlet1")

public class BindingServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
			stateless
			1. 상태 없음
			2. 웹 페이지 간 이동은 stateless
			3. 현재 페이지는 이전 페이지의 정보가 전혀 없다.
		
		*/
		/*
			Binding
		  
			1. 속성 (Attribute)에 정보를 저장하고 사용하는 것 	(* 일반 자바 변수를 의미하는 것이 아니다!)
			
		 	2. 3개 영역을 사용	(위치: 어디서든!!)
		 		1) ServletContext     : 애플리케이션(프로젝트) 종료 전까지 접근해서 사용가능
		 		2) HttpSession        : 브라우저 종료 전까지 접근해서 사용가능		                * 예제 : 로그인 (브라우저를 종료하기 전까지 계속 로그인 되어 있다.)
		 		3) HttpServletRequest : Request는 하나의 요청/응답 사이클 내에서 접근해서 사용가능	* 가장 많이 사용되는 영역
		 		
		 	3. 사용 메소드
		 		1) getAttribute('속성')     : 해당 속성 값 가져오기 (캐스팅이 필요할 수 있다.) 
		 		2) setAttribute('속성', 값) : 속성에 값 저장하기    (Object 타입으로 저장)
		 		 						* 값에는 'byte, char, int, double, String.. 등 다양한 값을 저장할 수 있다. 즉, Object클래스이므로 캐스팅이 필요하다. 
		 		3) removeAttribute('속성')  : 해당 속성 삭제하기
		 */
		// HttpServlet : 모든 Servlet의 부모	    //* 부모의 부모 : GenericServlet
		// ServletContext
		ServletContext ctx =  getServletContext();  // 또는 request.getServletContext();
		ctx.setAttribute("a", 1);
		
		// HttpSession ★★★
		HttpSession session = request.getSession(); //* ★★ 로그인 구현 시 사용. 변수명 'session'으로 사용.
		session.setAttribute("b", 2);		        //* session에도 변수 저장 가능
		
		// HttpServletRequest
		//* doGet에 HttpServletRequest request가 선언되어 있으므로, 바로 사용가능
		//* 단, Request의 경우 BindingServlet1 안에서 요청과 응답이 1사이클 순회하였으므로 데이터가 사라져, BindingServlet2 페이지로 이동 시 "c" 값은 없게 된다.
		request.setAttribute("c", 3);
	
		// 응답
		/*
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<a href=\"/01_Servlet/BindingServlet2\">이동</a>");
		out.close();
		*/
		
		/*  ★★★
			포워드
			1. request를 전달한다.
			2. 컨텍스트 내부 이동이므로 경로 작성 시 컨텍스트 패스(/01_Servlet)는 작성하지 않는다.
		*/
		//request.getRequestDispatcher("/BindingServlet2").forward(request, response);
		//* ★★ request는 요청/응답 1사이클 1회용이지만, forward의 특성(request를 살려서 보낸다) 덕분에 request의 값을 전달할 수 있다.
		
		/*
		 	리다이렉트
		 	1. request를 전달하지 않는다.
		 	2. 클라이언트 → 서버로 이동하므로 컨텍스트 패스를 작성해야 한다.
		*/
		response.sendRedirect("/01_Servlet/BindingServlet2");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
