package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		request.setCharacterEncoding("UTF-8");
		
		// 변수(파라미터)
		String id = request.getParameter("id");
		// if(id == "")       // * 자바스크립트에서 허용 (cf. 자바에서 사용 금지!★)
		// if(id.equals("")); // * 빈 문자열 검사는 equals 보다 isEmpty 선호!
		if(id.isEmpty()) {	  // * empty != null
		// * 만약, null 과 empty 구분이 안 될 경우 아래와 같이 코드를 작성한다.
		// *     if(id == null || id.isEmpty()){}
		// * id가 null 이더라도, 숏타임써큘레이션에 의해 id == null 가 true 이므로, null.isEmpty()는 처리되지 않는다. 
			
		// * 단! if(id.isEmpty() || id == null){} 은 잘못된 코드이다!
		// * id가 null일 경우, null.isEmpty() 는 NullPointException이 된다.
			id="빈 아이디";
		}
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		if(gender == null) {
			gender = "빈 성별";
		}
		String city = request.getParameter("city");
		if(city.isEmpty()) {
			city = "빈 도시";
		}
		
		// 배열(파라미터)
		String[] phone = request.getParameterValues("phone");
		if(phone[0].isEmpty()) {
			phone[0] = "빈 전화1";
		}
		if(phone[1].isEmpty()) {
			phone[1] = "빈 전화2";
		}
		if(phone[2].isEmpty()) {
			phone[2] = "빈 전화3";
		}
		String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2];
		
		
		String[] agree = request.getParameterValues("agree");
		if(agree == null) {
			agree = new String[1];
			agree[0] = "빈 동의";
		}
		// 연습. 이메일
		String emailId = request.getParameter("email_id");
		String domain = request.getParameter("domain");
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		// * 인코딩은 반드시 가장 먼저 해줘야한다. (★)
		
		PrintWriter out = response.getWriter();
		// * PrintWriter 사용목적 : .println() 메소드를 사용하기 위해..!
		out.println("<h3>아이디 : " + id  + "</h3>");
		out.println("<h3>비밀번호 : " + pwd  + "</h3>");
		out.println("<h3>성별 : " + gender + "</h3>");
		out.println("<h3>도시 : " + city + "</h3>");
		out.println("<h3>연락처 : " + strPhone + "</h3>");
		out.println("<h3>동의여부 : " + Arrays.toString(agree) + "</h3>");
		out.println("<h3>이메일 : " + emailId +"@" + domain + "</h3>");
		List<String> list = Arrays.asList(agree);	// * 배열이 리스트로 변환. (for문을 사용할 필요가 없이 사용한다.)
		if (list.contains("marketing")) { // 마케팅을 체크하였는지 확인
			out.println("<h3>마케팅 동의한 회원</h3>");
		}
		out.close();
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
