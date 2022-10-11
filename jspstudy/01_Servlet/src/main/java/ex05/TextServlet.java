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
		try {
		// 요청
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			// (age =! null 또는 int) 일 경우 예외발생 
			//* 이 경우, client.html에서 age값이 전달되지 않아 'null'이 되거나 '소숫점'이 있다면 error가 발생한다. (NumberFormatException)
			//* 때문에 예외처리를 한다! (try블록)
			
			
			if (age <= 0 || age > 100 ) {
				throw new RuntimeException(age + "살은 불가능한 나이입니다.");
					
			}
			
			//응답	// * html에서 응답 dataType을 'text'로 지정하였으므로, 여기에 맞게 MIME-TYPE으로 지정한다.
			response.setContentType("text/plain;charset=UTF-8");	// * text/plain (단순 텍스트의 MIME-TYPE)을 하였으므로, xml이 아니라 단순 텍스트로 만들어진다.
			
			PrintWriter out = response.getWriter();
			out.println("이름은 " + name + "이고, 나이는 " + age + "살입니다."); // 이 데이터는 .html 파일의 success: function(resData)의 resData로 들어간다.
			out.close();
			
		} catch (NumberFormatException e) {
			// 예외 처리 응답
			response.setContentType("text/plain;charset=UTF-8");
			
			response.setStatus(1000);
			// 개발자가 임의로 작성한 status(응답코드). * 원래 응답코드 : 500
			
			//* PrintWriter도 다시 만들어줘야 한다!
			PrintWriter out = response.getWriter();
			out.println("예외 발생! 파라미터 age는 정수입니다.");	// 개발자가 임의로 작성한 responseText
			out.close();
		} catch (RuntimeException e) {
			response.setContentType("text/plain;charset=UTF-8");
			response.setStatus(2000);
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());	// RuntimeException 예외 객체에 저장된 예외 메시지를 responseText로 처리
			out.close();
		}
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
