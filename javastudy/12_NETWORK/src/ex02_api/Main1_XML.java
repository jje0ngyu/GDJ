package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main1_XML {

	
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
			con.setRequestMethod("GET");  //* 생략 가능. (default : "GET" 방식)
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
		
		// API로부터 전달받은 xml 데이터
		String response = sb.toString();
		
		// File 생성
		File file = new File ("C:\\storage", "api1.xml");
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
		// xml 분석
		
		File file = new File ("C:\\storage", "api1.xml");
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(file);
				
				Element root = doc.getDocumentElement(); // <response> (최상위 태그)
				System.out.println(root.getNodeName());
				
				NodeList nodeList = root.getChildNodes(); // <
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i); // <header> 와 <body>
					System.out.println("   " + node.getNodeName());
					
					NodeList nodeList2 = node.getChildNodes();  // <header>의 자식 태그(), <body>의 자식 태그 <items>,<numOfRows>,<pageNo>,<totalCount>
					for (int j = 0; j < nodeList2.getLength(); j++) {
						Node node2 = nodeList2.item(j); 
						System.out.println("      " + node2.getNodeName());
						
						if(node2.getNodeName().equals("items")) {  // <items> 태그 대상
							NodeList items = node2.getChildNodes();
							for (int k = 0; k < items.getLength(); k++) {
								Node item = items.item(k);
								System.out.println("      " + item.getNodeName());
								
								NodeList itemChildren = item.getChildNodes();  // <item>의 자식 태그
								for (int l = 0; l < itemChildren.getLength(); l++) {
									Node itemChild = itemChildren.item(l);
									System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
								}
								
							}
						}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
	}
	public static void m3() {
		// 코로나 19 감염현황 조회 서비스
		// 날짜 : 20220808 ~ 20220812
		
		// API 주소  (StringBuilder)
		String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg==";
		
		StringBuilder urBuilder = new StringBuilder();
		
		try {
			urBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
			urBuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			urBuilder.append("&startCreateDt=20220808");  //* 숫자, 알파벳은 인코딩하지 않아도 된다.
			urBuilder.append("&endCreateDt=20220812");
			
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
			con.setRequestProperty("Content_Type", "application/xml; charset=UTF-8");
			
		} catch (MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch (IOException e) {
			System.out.println("API 접속 오류");
		}
		
		// 입력스트림
		BufferedReader br = null;
		StringBuilder str = new StringBuilder();
		
		try { 
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			while ((line = br.readLine()) != null) {
				str.append(line + "\n");
			}
			br.close(); //* ♣ while문 밖에서 스트림 종료하기 !
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// API로부터 전달받은 xml 데이터
		String response = str.toString();
		
		// XML File 생성 (api2.xml)
		File file = new File("C:\\storage", "api2.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void m4() {
		// m2() xml 파싱 (★★★)
		File file = new File("C:\\storage", "api2.xml");
		StringBuilder sb = new StringBuilder();
		
		try {
			// api2.xml 문서 → doc 객체 (변환)
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			// api2.xml 문서의 최상위 태그 : root
			Element root = doc.getDocumentElement();
			
			// <item> ... </item> 태그 하나 == 특정 날짜(a day)의 데이터
			NodeList items = root.getElementsByTagName("item"); // 태그 이름으로 찾기
			//* Elements (복수형)은 여러 개가 나오기 때문에 List 타입에서 다룬다.
			for (int i = 0; i < items.getLength(); i++) {
				Node item = items.item(i);
				
				//* <item> 의 자식 태그 중 <stateDt> 호출하기
				NodeList itemChildren = item.getChildNodes(); //* 자식 태그<> 전부 호출 후
				for (int j = 0; j< itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
					//* 출력되는 태그의 순서는 코드작성 순서X, 작성된 태그의 순서.
					if (itemChild.getNodeName().equals("stateDt")) {
						sb.append(" 날짜 : ").append(itemChild.getTextContent());
					}
					else if (itemChild.getNodeName().equals("decideCnt")) {
						sb.append(" 확진자수 : ").append(itemChild.getTextContent());
					}
					else if (itemChild.getNodeName().equals("deathCnt")) {
						sb.append(" 사망자수 : ").append(itemChild.getTextContent());
					}					
				}
				sb.append("\n");
//				Node stateDt = itemChildren.item(4); //* stateDt는 5번째 노드이므로, 인덱스 4 호출 (* 줄 바꿈도 자식 요소로 인식하므로, 줄 바꿈에 주의)
//				System.out.println(stateDt.getTextContent());
				// Node stateDt == <stateDt>20220812</stateDt>
				// stateDt.getNodeName()     == stateDt  (태그 이름)
				// stateDt.getTextContent() == 20220812 (태그 내부 텍스트)
			}
			System.out.println(sb.toString());
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void m5() {
		
		//
		String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg==";
		StringBuilder urBuilder = new StringBuilder();
		
		try {
			urBuilder.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); //* 서비스URL, 요청주소URL 확인
			urBuilder.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			urBuilder.append("&numOfRows=10");
			urBuilder.append("&pageNO=1");
			urBuilder.append("&base_date=20220818");
			urBuilder.append("&base_time=1100");
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
				sb.append(line + "\n");
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("API 응답 실패");
		}
		
		// xml 데이터로
		String response = sb.toString();
		
		// xml File 생성
		File file = new File ("C:\\storage", "api3.xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(response);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void m6() {
		File file = new File ("C:\\storage", "api3.xml");
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			for (int i = 0; i < items.getLength(); i++) {
				Element item = (Element)items.item(i);  // Node > Element 타입으로 다운 캐스팅
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue = item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch(category.getTextContent()) {
				case "PTY" : strCategory = "강수형태"; break;
				case "REH" : strCategory = "습도"; break;
				case "RN1" : strCategory = "강수량(1시간)"; break;
				case "T1H" : strCategory = "기온"; break;
				case "UUU" : strCategory = "동서바람성분"; break;
				case "VEC" : strCategory = "풍향"; break;
				case "VVV" : strCategory = "남북바람성분"; break;
				case "WSD" : strCategory = "풍속"; break;
				}
				System.out.println(strCategory + " : " + obsrValue.getTextContent());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void m7() {
		
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
				sb.append(line + "\n");
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
	}
	
	public static void m8() {
		
		File file = new File("C:\\storage", "api4.xml");
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();

			StringBuilder sb = new StringBuilder();
			
			Node title = root.getElementsByTagName("title").item(0);
			sb.append(title.getTextContent()).append("\n");
			
			Node pubDate = root.getElementsByTagName("pubDate").item(0);
			sb.append(pubDate.getTextContent()).append("\n");
			
			NodeList dataList = root.getElementsByTagName("data");
			for (int i = 0; i < dataList.getLength(); i++) {
				Element data = (Element)dataList.item(i);
				Node hour = data.getElementsByTagName("hour").item(0);
				Node temp = data.getElementsByTagName("temp").item(0);
				Node wfKor = data.getElementsByTagName("wfKor").item(0);
				sb.append(hour.getTextContent()).append("시 ");
				sb.append(temp.getTextContent()).append("도 ");
				sb.append(wfKor.getTextContent()).append("\n");
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void m9() {
	
		// 기상청 XML

		try {
			
			// 접속
			String apiURL = "https://www.kma.go.kr/XML/weather/sfc_web_map.xml";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 접속 확인
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println("API 접속 실패");
				return;
			}
			
			// 바이트 입력 스트림 -> 문자 입력 스트림 -> 버퍼 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			File file = new File("C:\\storage", "sfc_web_map.xml");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			// readLine() 메소드를 이용한 복사
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line + "\n");
			}
			
			// 닫기
			bw.close();
			br.close();
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("API 서버 오류");
		}
	}
	
	public static void m10() {
		
		File file = new File ("C:\\storage", "sfc_web_map.xml");
		
		try {
			
			StringBuilder sb = new StringBuilder();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); // <current xmlns="current"> 태그
//			System.out.println(root.getNodeName()); // 태그이름 : <current>
//			System.out.println(root.getAttribute("xmlns")); // 속성값 : "current"
			
			Element weather = (Element)root.getElementsByTagName("weather").item(0);
			sb.append(weather.getAttribute("year") + "년 ");
			sb.append(weather.getAttribute("month") + "월 ");
			sb.append(weather.getAttribute("day") + "일 ");
			sb.append(weather.getAttribute("hour") + "시\n");
			
			NodeList locals = root.getElementsByTagName("local");
			for (int i = 0; i < locals.getLength(); i++) {
				Element local = (Element)locals.item(i);
				sb.append(local.getTextContent() + ":");
				sb.append(local.getAttribute("ta") + "℃ ");
				sb.append(local.getAttribute("desc") + "\n");
				
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
	}
	public static void main(String[] args) {
		m8();

	}

}
