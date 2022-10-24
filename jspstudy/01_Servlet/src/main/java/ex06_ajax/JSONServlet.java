package ex06_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/JSONServlet")

public class JSONServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		//* 예외처리는 생략...
		
		
		
		// 2. 응답할 JSON 객체 만들기
		JSONObject obj = new JSONObject();
		//* 내용 입력/저장 : put() 사용!
		//* put(불러올 값, 저장할 값);
		obj.put("name", name);
		obj.put("age", age);
		
		
		
		// 3. 응답
		response.setContentType("application/json; charset=UTF-8");
		// JSON 데이터의 MIME-TYPE
		//* client.html 에 입력한 "dataType: json" 에 맞춰서 작성한다.
		
		PrintWriter out = response.getWriter();
		out.println(obj.toString()); // 응답 데이터는 텍스트 처리된 JSON 객체
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
