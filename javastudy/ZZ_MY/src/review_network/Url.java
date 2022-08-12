package review_network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Url {

	public static void m1() {

		try {
			String apiURL = "https://search.naver.com/searcn.naver? query=날씨";
			URL url = null;
			url = new URL(apiURL);
			
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void m2() {
		try {
			String apiURL = "https://www.naver.com";
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			System.out.println("응답코드 : " + con.getResponseCode());
			System.out.println("정상 : " + HttpURLConnection.HTTP_OK);
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			System.out.println("컨텐트 타입 : " + con.getContentType());
			System.out.println("요청 방식 : " + con.getRequestMethod());
			
			con.disconnect();
			
		} catch (MalformedURLException e) {
			 System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 오류");
		}
	
	}
	
	public static void m3() {
		try {
			String apiURL = "https://www.naver.com";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			InputStream in = con.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[100];
			int readCnt = 0;
			
			while ((readCnt = reader.read(cbuf)) != -1 ) {
				sb.append(cbuf, 0, readCnt);
			}
			
			File file = new File ("C:\\storage", "naver.html");
			FileWriter fw = new FileWriter(file);
			
			fw.write(sb.toString());
			
			fw.close();
			reader.close();
			con.disconnect();
			
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 및 연결 오류");
		}
	}
	
	public static void m4() {
		
		File src = new File ("C:\\GDJ\\installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File cpy = new File ("C:\\GDJ\\installer", "eclipse.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			byte[] b = new byte[1024];
			int readByte = 0;
			
			while ((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) bos.close();
				if (bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void m5() {
		File src = new File ("C:\\GDJ\\installer", "eclipse.zip");
		
		File dir = new File ("C:\\storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
	}
	public static void main(String[] args) {
		// m1(); // String 타입의 URL 메소드
		// m2(); // HttpURLConnection 으로 다운캐스팅
		// m3();
		// m4(); // 다른 이름으로 파일 복사하기
		// m5(); // 다른 위치로 파일 이동하기 (복사 & 삭제)

	}

}
