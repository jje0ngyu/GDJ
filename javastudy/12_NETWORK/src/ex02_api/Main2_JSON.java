package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class Main2_JSON {

	public static void m1() {
		
		// API 주소 (주소 + 요청 파라미터)
				String apiURL = "http://api.data.go.kr/openapi/tn_pubr_public_weighted_envlp_api";
				
				try {
				
					String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg=="; //* 디코딩값 (* 인코딩키값X)
					apiURL += "?pageNo=" + URLEncoder.encode("0", "UTF-8");
					apiURL += "&numOfRows=" + URLEncoder.encode("100" ,"UTF-8");
					apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
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
					con.setRequestMethod("GET");  //* 생략 가능. (default : "GET" 방식)
					con.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); //(★) 자원의 종류를 나타내는 표기법.   application/xml  \\  application/json  \\  text/html  (데이터의 타입)
					
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
						sb.append(line);
					}
					// 스트림, 접속 종료
					reader.close();
				} catch (IOException e) {
					System.out.println("API 응답 실패");
				}
				
				// API로부터 전달받은 json 데이터
				String response = sb.toString();
				
				// JSON File 생성
				File file = new File ("C:\\storage", "api1.json");
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write(response);
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 접속 종료
				con.disconnect();
	}
	
	public static void m2() {
		
		// JSONObject 클래스 : { }, 객체를 의미
		// JSONArray 클래스  : [ ], 배열을 의미
		
		File file = new File ("C:\\storage", "api1.json");
		
		//* File → String 변환 작업
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			while((line= br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//* JSONObject() 메소드에 File을 직접적으로 불러올 수 없다. String으로 전환 작업 필요. (상위 코드 참조)
		JSONObject obj = new JSONObject(sb.toString()); 
		JSONObject obj2 = obj.getJSONObject("response");
		JSONObject obj3 = obj2.getJSONObject("header");
		String resultCode = obj3.getString("resultCode");
		String resultMsg = obj3.getString("resultMsg");
		
		System.out.println(resultCode + "," + resultMsg);
	}
	
	public static String m3() {
		
		// 기상청41_단기예보 조회서비스
		//* 초단기이기 때문에, 24시간이내의 데이터만 출력됨
		
		// 인증키(Decoding)
		String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg==";
		
		StringBuilder urBuilder = new StringBuilder();
		
		try {
			urBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); //* 서비스URL, 요청주소URL 확인
			urBuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			urBuilder.append("&numOfRows=10");
			urBuilder.append("&pageNO=1");
			urBuilder.append("&dataType=json");
			urBuilder.append("&base_date=20220819");
			urBuilder.append("&base_time=0600");
			urBuilder.append("&nx=55");
			urBuilder.append("&ny=127");
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		String apiURL = urBuilder.toString();
		
		// API 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("Content_Type", "application/json; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 오류");
		}
		
		// 입력스트림
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 JSON 데이터로
		String response = sb.toString();
		
		// JSON File 생성
		File file = new File ("C:\\storage", "api2.json");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static void m4() {
		
		JSONObject obj = new JSONObject(m3());
		JSONObject response = obj.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		// Array item 프로퍼티 가져오기
		for (int i = 0; i < item.length(); i++) {
			JSONObject element = item.getJSONObject(i);
			System.out.println(element.getString("category") + " : " + element.getString("obsrValue"));
		}
	}
	
	public static String m5() {
		// 소상공인시장진흥공단_상가(상권)정보
		//* 초단기이기 때문에, 24시간이내의 데이터만 출력됨
		
		// 인증키(Decoding)
		String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg==";
		
		// 주소 (주소 + 요청 파라미터)
		StringBuilder urBuilder = new StringBuilder();
		
		try {
			urBuilder.append("http://apis.data.go.kr/B553077/api/open/sdsc2/storeZoneOne"); //* 서비스URL, 요청주소URL 확인
			urBuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			urBuilder.append("&key=9940"); 			//* 철산역
			urBuilder.append("&type=json"); 		//* json 타입
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		String apiURL = urBuilder.toString();
		
		// API 접속
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("Content_Type", "application/json; charset=UTF-8");
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 오류");
		}
		
		// 입력스트림
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 JSON 데이터로
		String response = sb.toString();
		
		// JSON File 생성
		File file = new File ("C:\\storage", "api3.json");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	public static void m6() {
		
		JSONObject obj = new JSONObject(m5());
		JSONObject header = obj.getJSONObject("header");
		JSONArray columns = header.getJSONArray("columns");  //* 대괄호는 어레이
	
		JSONObject body = obj.getJSONObject("body");
		JSONArray items = body.getJSONArray("items");
		JSONObject item = items.getJSONObject(0);
		
		//* 배열을 사용하지 않으면 items 값의 순서가 랜덤으로 출력된다.
		String[] p = {"trarNo", "mainTrarNm", "ctprvnCd", "ctprvnNm", "signguCd","signguNm", "trarArea", "coordNum", "coords", "stdrDt"};
		
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < columns.length(); i++) {
			map.put(columns.getString(i), item.get(p[i]));
		}
		System.out.println(map);
	}

	public static String m7() {
		
		String apiURL = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
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
		StringBuilder sb = new StringBuilder();
		
		try {
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// XML File 생성 (api4.xml)
		File file = new File("C:\\storage", "api4.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("파일 생성 실패");
		}
		
		return sb.toString();
		
	}
	
	public static void m8() {
		JSONObject obj = XML.toJSONObject(m7());
		System.out.println(obj.toString());
		
		JSONArray dataList = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getJSONObject("description")
								.getJSONObject("body")
								.getJSONArray("data");
		
		for (int i = 0; i < dataList.length(); i++) {
			JSONObject weather = dataList.getJSONObject(i);
			System.out.println(weather.getInt("hour") + "시 : " + weather.getInt("temp") + "도, " + weather.getString("wfKor"));
			
		}
		
	}
	
	public static void main(String[] args) {
		m8();
	}

}
