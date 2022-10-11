package ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MovieXMLServlet")
// Mapping값을 바꿔주면 반드시 여기도 수정해줘야 한다!!
// * 같은 Mapping값이 2개 이상 존재하면 Tomcat이 작동하지 않는다.

public class MovieXMLServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 클라이언트 아이디, 시크릿
		String clientId = "mtNSZZEJIiSUesKY51WB";
		String clientSecret = "sCWaP84Z8a";
		
		
		// 요청 파라미터 (검색어, 검색결과수)
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		//* 요청 data: 'query'의 데이터
		String display = request.getParameter("display");
		//* ㄴㄴ : int display = Integer.parseInt(request.getParameter("display"));
		
		try {
			// 검색어 UTF-8 인코딩
			query = URLEncoder.encode(query, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("검색어 인코딩 실패");
			// * catch 부분은 client.html의 [error]와 관련 있다.
			// * 상위 문자 메시지는 [error]의 responseText 메시지로 출력된다.
			out.close();
		}
		
		// API 접속
		String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query=" + query
					  + "&display=" + display;
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API URL이 잘못되었습니다.");
			out.close();
		} catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 연결이 실패했습니다.");
			out.close();
		}
		
		// API 요청
		try {
			// 요청 메소드
			con.setRequestMethod("GET"); //* 대/소문자 구분할 것!!
			// 요청 헤더
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		}  catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 요청이 실패했습니다.");
			out.close();
		}
		
		
		// API 응답 스트림 생성(정상 스트림, 에러 스트림)
		
		// * 네이버로부터 XML을 읽어들일 '입력스트림' 작성
		// * .getInputStream()을 사용하여야 하나 단독으로 사용할 경우 byte 기반이라 한글이 깨진다.
		// * 때문에 Reader를 사용하여, char 기반으로 변경하여 사용한다. (BufferedReader를 사용하여 속도까지 증가!)
		BufferedReader reader = null;
		try {
			int responseCode = con.getResponseCode(); // 응답코드(status)
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
		} catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답 스트림 생성이 실패했습니다.");
			out.close();
		}
		
		// API 응답 데이터 저장하기
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("API 응답이 실패했습니다.");
			out.close();
		}
		
		
		// client.html로 API 응답 결과 보내기
		response.setContentType("application/xml; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
