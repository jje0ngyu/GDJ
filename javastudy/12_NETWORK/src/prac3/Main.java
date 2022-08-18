package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {
//* Divide and Conquer : 메소드 1개당 1개의 기능만 하도록 분리 (기능별 분리)
	public static void main(String[] args) throws RuntimeException { //* unchecked exception은 생략 가능
		//* 영화 API
		String key = "cee618722ff3cb0afb0da3cc05e7a144";
		
		//* 조회할 날짜
		Scanner sc = new Scanner (System.in);
		System.out.println("날짜(yyyymmdd) >>> ");
		String targetDt = sc.next();

		try {
			key = URLEncoder.encode(key, "UTF-8");
			targetDt = URLEncoder.encode(targetDt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e); //* ("출력될 메시지", 예외 사유는 e에 들어가 있음)
		}
		//* 파라미터 수가 적은 경우, 한번에 다 적어 넣어도 된다.
		//* 주의할 점 : 주소 안에 공백( )은 허용하지 않는다.
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=" + key + "&targetDt=" + targetDt;
	
		//* 메소드화
		String response = getResponse(apiURL); //* 응답하는 메소드
		createFile(response);
		
	}
	
	
	
	//* 스테틱 메소드에서 호출하는 것은 스테틱 메소드여야 한다.
	public static String getResponse(String apiURL) {
		HttpURLConnection con = getConnection(apiURL); //* 대답하는 메소드
		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream()); 	//* getResponse 가 String타입이므로, readBody 메소드도 String타입
			} else {
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청 오류", e);
		}
	}
	
	public static HttpURLConnection getConnection(String apiURL) {
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection)url.openConnection();  //* 상위 메소드의 getConnection(apiURL)로 반환된다.
		} catch (MalformedURLException e) {
			throw new RuntimeException("API 주소 오류", e);
		} catch (IOException e) {
			throw new RuntimeException("API 연결 오류", e);
		}
	}
	
	public static String readBody(InputStream in) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답 오류", e);
		}
	}
	
	public static void createFile (String response) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\storage\\boxoffice.xml"))) {
			bw.write(response);
			bw.flush(); //* 남은(잔류) 데이터 전달
			
		} catch (IOException e) {
			throw new RuntimeException("파일 생성 오류", e);
		}
	}

}
