package api;

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
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ApiMain {

	// 조회된 결과를 이용하여 accident.txt 파일 생성
	// 조회된 사고 1건의 정보는 Accident 객체에 저장
	// 생성된 모든 Accident 객체를 컬렉션 ArrayList에 저장
	public static void main(String[] args) {
		
		// API
		String serviceKey = "kE0KCt7fSanlZOfnF4SeIg1dbNdyAVvniyU3iBdfQpCE6f0ppNTb55CZ8XjCpU2hsdsDqDAkJZQHVAXxCNb2Vg==";
		StringBuilder urBuilder = new StringBuilder();
		try {
			urBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urBuilder.append("?ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			urBuilder.append("&searchYear=2021");
			urBuilder.append("&siDo=1100");  //* 서울특별시 : 1100
			urBuilder.append("&guGun=1125"); //* 금천구 : 1125
			urBuilder.append("&type=json");
			urBuilder.append("&numOfRows=10");
			urBuilder.append("&pageNo=1");
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		String apiURL = urBuilder.toString();
		HttpURLConnection con = null;
		
		try {
			URL url = new URL(apiURL);
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
		
//		// xml 파일 생성
//		File file = new File("accident.txt");
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//			bw.write(sb.toString());
//			bw.close();
//		} catch (IOException e) {
//			System.out.println("파일 생성 실패");
//		}
	
		

		List<Accident> accidents = new ArrayList<>();
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(sb.toString());
			
			Element root = doc.getDocumentElement();
			NodeList items = root.getElementsByTagName("items");
			for (int i = 0; i < items.getLength(); i++) {
				Element item = (Element) items.item(i);
							
					String occrrnc_dt = item.getElementsByTagName("occrrnc_dt").item(0).getTextContent();
					String occrrnc_day_cd = item.getElementsByTagName("occrrnc_day_cd").item(0).getTextContent();
					String dth_dnv_cnt = item.getElementsByTagName("dth_dnv_cnt").item(0).getTextContent();
					String injpsn_cnt = item.getElementsByTagName("injpsn_cnt").item(0).getTextContent();
	
				Accident accident = Accident.builder()
						.occrrncDt(occrrnc_dt)
						.occrrncDayCd(occrrnc_day_cd)
						.dthDnvCnt(dth_dnv_cnt)
						.injpsnCnt(injpsn_cnt)
						.build();
				
				accidents.add(accident);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 출력된 정보 txt 파일에 입력하기
		StringBuilder accBuilder = new StringBuilder();
		File accInfo = new File ("accident.txt");
		for (Accident accident : accidents ) {
			accBuilder.append(accident);
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(accInfo));
			bw.write(sb.toString());
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
