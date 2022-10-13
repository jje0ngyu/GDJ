package ex10_up_down;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//* COS 라이브러리는 Upload 과정에서만 도움을 받았고,
		//* Download 과정은 COS 라이브러리의 도움 없이 자바로만 구현되었다.
		
		// 요청 파라미터
		request.setCharacterEncoding("UTF-8");
		String filename = request.getParameter("filename");
		
		// 다운로드할 파일 경로
		String realPath = getServletContext().getRealPath("upload");
		
		// 다운로드할 파일 객체
		File file = new File(realPath, filename);
		
		// 다운로드할 파일을 읽어 들일 바이트 기반 입력 스트림
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		
		// 다운로드 응답 헤더
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
					//* URL인코더를 이용하여 '한글이름.jpg'도 다운로드 가능하다.
					//* 가장 BEST는 업로드를 한글이름이 아닌, 영문+숫자 이름으로 전환하여 업로드시켜주는 것이 가장 좋다.
		response.setHeader("content-Length", file.length() + "");
		//* setHeader는 String타입이므로, file.length()도 String타입으로 변환한다.
		//* file.length() : 파일크기
		
		// 응답으로 내보낼 바이트 기반 출력 스트림
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());	
		
		// 파일 복사
		byte[] b = new byte[1024];
		int readByte = 0;
		while((readByte = in.read(b)) != -1) {
			out.write(b, 0, readByte);
		}
		out.close();
		in.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
