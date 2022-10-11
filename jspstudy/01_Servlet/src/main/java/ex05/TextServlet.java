package ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//응답	// * html에서 응답 dataType을 'text'로 지정하였으므로, 여기에 맞게 MIME-TYPE으로 지정한다.
		response.setContentType("text/plain;charset=UTF-8");	// * text/plain (단순 텍스트의 MIME-TYPE)을 하였으므로, xml이 아니라 단순 텍스트로 만들어진다.
	
		PrintWriter out = response.getWriter();
		out.println("이름은 " + name + "이고, 나이는 " + age + "살입니다."); // 이 데이터는 .html 파일의 success: function(resData)의 resData로 들어간다.
		out.close();
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
