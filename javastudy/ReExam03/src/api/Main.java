package api;

import java.awt.JobAttributes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;



public class Main {

	public static void main(String[] args) {
		// 기상청RSS : 서울특별시 금천구 가산동
		
		// XML 파싱
		// API응답 (XML) → XML파일 → Document
		
		// JSON 파싱
		// API응답 (JSON) → JSONObject   (* 중간에 파일 생성 과정이 필요하지 않다)
		
		
		try {
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			//* 인코딩할 필요가 없다.
			//* 서비스키도 필요 없다.
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			//con.setRequestMethod("GET"); //* 주소창에 파라미터를 붙여 불러오는 것이 get 방식
			//con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line); //* xml의 전체 내용 저장됨
			}
			
			// 파싱 결과를 저장할 파일
			File file = new File("test.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter (file));
			
			// StringBuilder에 저장된 응답(XML) 데이터를 JSON으로 변경하기
			JSONObject obj = XML.toJSONObject(sb.toString());
			System.out.println(obj);
			
			JSONObject rss = obj.getJSONObject("rss");
			
			//* channel의 자식 태그 소환하기
			JSONObject channel = rss.getJSONObject("channel");
			String link = channel.getString("link");
			String generator = channel.getString("generator");
			String language = channel.getString("language");
			String title = channel.getString("title");
			String pubDate = channel.getString("pubDate");
			
			bw.write(pubDate + "\n");
			System.out.println(pubDate);
			
			//* item의 자식 태그 소환하기
			JSONObject item = channel.getJSONObject("item");
			String author = item.getString("author");
			String link2 = item.getString("link");
			String catagory = item.getString("category");
			String title2 = item.getString("title");
			JSONObject description = item.getJSONObject("description");
			
			bw.write(catagory + "\n");
			System.out.println(catagory);
			
			//* description의 자식 태그 소환
			JSONObject body = description.getJSONObject("body");
			JSONArray dataList = body.getJSONArray("data");
			
			//* JSONArray 데이터 요소 1가지만 뽑아오기
			JSONObject data = dataList.getJSONObject(0);
			String wfKor = data.getString("wfKor");
			System.out.println(wfKor);
			
			//* JSON 체이닝
//			JSONArray dataList = obj.getJSONObject("rss")
//									.getJSONObject("channel")
//									.getJSONObject("item")
//									.getJSONObject("description")
//									.getJSONObject("body")
//									.getJSONArray("data");
//			
//			
			for (int i = 0; i < dataList.length(); i++) {
//				JSONObject weather = dataList.getJSONObject(i);
//				System.out.println("날씨 : " + weather.getString("wfKor") + weather.getInt("temp") + "도");
				
				JSONObject data2 = dataList.getJSONObject(i);
				int hour = data2.getInt("hour");
				int sky = data2.getInt("sky");
				int temp = data2.getInt("temp");
				String wfKor2 = data2.getString("wfKor");
				
				bw.write(hour + "시, " +  temp + "도, " + wfKor2 + "\n");
			}
			
			bw.close();
			br.close();
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
