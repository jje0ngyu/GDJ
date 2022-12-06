package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

		public static void main(String[] args) {
			
			String clientId = "mtNSZZEJIiSUesKY51WB";
			String clientSecret = "sCWaP84Z8a";
			
			try {
				
				System.out.println("검색어 입력 >>> ");
				Scanner sc = new Scanner(System.in);
				String result = sc.next(); 
				String search = URLEncoder.encode(result, "UTF-8");
				
				String apiURL = "https://openapi.naver.com/v1/search/book?query=" + search;
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", clientId);
				con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				BufferedReader br = null;
				if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				
				StringBuilder sb = new StringBuilder();
				String line;
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				con.disconnect();
				
				JSONObject obj = new JSONObject(sb.toString());
				JSONArray items = obj.getJSONArray("items");
				File dir = new File("C:/download");
				if (dir.exists() == false) {
					dir.mkdirs();
				}
				
				// title, link, image HTML 파일 저장
				// 파일 이름은 검색어 그대로 사용
				File file = new File(dir, result + ".html");
				PrintWriter out = new PrintWriter(file);
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"?UTF-8\">");
				out.println("<title>기억이 안나...</title>");
				out.println("</head>");
				out.println("<body>");
				// 결과 파일에서 검색어는 진하게 표시
				out.println("<p style='font-w:bolder'>검색결과 : " + result + "</p>");
				for (int i = 0; i < items.length(); i++) {
					String title = items.getJSONObject(i).getString("title");
					title = title.replaceAll(result, "<b>" + result + "</b>");
					out.println("<a href=\"" + items.getJSONObject(i).getString("link") + "\">" + title + "</a>");
					out.println("<br/>");
					out.println("<img src=\"" + items.getJSONObject(i).getString("image")+"\"height=\"130\" width=\"90\">");
					out.println("<br/>");
				}
				out.println("</body>");
				out.println("</html>");
				out.close();
				
				
			} catch(Exception e) {
				try {
					
					File dir = new File("C:/download/log");
					if(dir.exists() == false) {
						dir.mkdirs();
						
					}
					File file = new File(dir, "error_log.txt");
					PrintWriter out = new PrintWriter(file);
					out.println("예외메시지    " + e.getMessage());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
					Date date = new Date(System.currentTimeMillis());
					out.println("예외발생시간  " + formatter.format(date));
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
}
