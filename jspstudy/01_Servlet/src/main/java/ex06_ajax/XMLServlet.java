package ex06_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

@WebServlet("/XMLServlet")

public class XMLServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	public XMLServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		//* 예외처리는 생략...
		
		// 응답할 JSON 객체 만들기
		JSONObject obj = new JSONObject();
		//* 내용 입력/저장 : put() 사용!
		//* put(불러올 값, 저장할 값);
		obj.put("name", name);
		obj.put("age", age);
		
		JSONObject person = new JSONObject();
		person.put("person", obj);
		
		// ★★★ 응답할 JSON 객체를 XML로 변환하기
		String responseXML = XML.toString(person);
		
		/*
		 	<person>
		 		<name>민경태</name>
		 		<age>45</age>
		 	</person>
		 */
		// 응답
		response.setContentType("application/xml; charset=UTF-8");
		// JSON 데이터의 MIME-TYPE
		//* client.html 에 입력한 "dataType: json" 에 맞춰서 작성한다.
		
		PrintWriter out = response.getWriter();
		out.println(responseXML); // 응답 데이터는 XML
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
