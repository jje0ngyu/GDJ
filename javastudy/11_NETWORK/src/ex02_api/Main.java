package ex02_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Main {

	
	// 요청 (★)
	// 1. Request
	// 2. 클라이언트 → 서버
	
	// 파라미터 (★)
	// 1. Parameter
	// 2. 보내는 데이터 (변수 개념)
	
	// 응답
	// 1. Response
	// 2. 서버 → 클라이언트
	
	
	public static void m1() {
		System.out.println("=== (접속) DATA.GO.KR 종량제봉투 데이터 사용 ===");
		System.out.println("=== 새로운 예외 : UnsupportedEncodingException ===");
		// 전국종량제봉투가격표준데이터
		// DATA.GO.KR > 활용신청 > 발급받은 서비스 키
		
		// API 주소 (주소 + 요청 파라미터)
		String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
		
		try {
		
			String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg=="; //* 디코딩값 (* 인코딩키값X)
			apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("100" ,"UTF-8");
			apiURL += "&type=" + URLEncoder.encode("xml", "UTF-8");
			//apiURL += "&CTPRVN_NM=인천광역시";  *이렇게 코드를 짜면 안 됩니다. 반드시 아래처럼 encode 하세요.
			apiURL += "&CTPRVN_NM=" + URLEncoder.encode("인천광역시", "UTF-8");
			apiURL += "&SIGNGU_NM=" + URLEncoder.encode("계양구", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TYPE=" + URLEncoder.encode("규격봉투", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_MTHD=" + URLEncoder.encode("소각용", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_PRPOS=" + URLEncoder.encode("생활쓰레기", "UTF-8");
			apiURL += "&WEIGHTED_ENVLP_TRGET=" + URLEncoder.encode("기타", "UTF-8");
			apiURL += "&serviceKey=" + URLEncoder.encode(serviceKey, "UTf-8");
		
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		// API 주소 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); //(★) 자원의 종류를 나타내는 표기법.   application/xml  \\  application/json  \\  text/html  (데이터의 타입)
			
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 주소 접속 실패");
		}
		
		// 입력 스트림 (응답) 생성
		// 1. 응답 성공 시 정상 스트림, 실패 시 에러 스트림
		// 2. 응답 데이터는 StringBuilder에 저장
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null; 
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			// 스트림, 접속 종료
			reader.close();
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String response = sb.toString();
		System.out.println(response);
		
		// 접속 종료
		con.disconnect();
		
	}
	
	public static void main(String[] args) {
		m1();

	}

}
