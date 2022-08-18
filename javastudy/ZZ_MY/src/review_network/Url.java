package review_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Url {

	public static void m1() {

		// API 생성
		String apiURL = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
		// API 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("Content_Type", "application/xml; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 오류");
		}
		
		// 입력스트림
		BufferedReader br = null;
		StringBuilder sb = null;
		
		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader (new InputStreamReader (con.getInputStream()));
			} else {
				br = new BufferedReader (new InputStreamReader (con.getErrorStream()));
			}
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		
		// API로부터 전달받은 XML 데이터
		
		// XML File 생성
		
		
	}

	public static void main(String[] args) {
		m1();
	}
}
