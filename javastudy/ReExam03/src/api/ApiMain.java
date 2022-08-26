package api;

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

public class ApiMain {

	public static void main(String[] args) {
		String apiURL = ("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000");
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader (new InputStreamReader (con.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line); // 불러들인 XML파일
			}
			
			// XML → JSON 변환
			File file = new File ("weather.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			JSONObject obj = XML.toJSONObject(sb.toString());
			JSONObject rss = obj.getJSONObject("rss");
			JSONObject channel = rss.getJSONObject("channel");
			bw.write(channel.getString("pubDate") + "\n");
			
			JSONObject item = channel.getJSONObject("item");
			String category = item.getString("category");
			bw.write(category + "\n");
			
			JSONArray dataList = item.getJSONObject("description").getJSONObject("body").getJSONArray("data");
			
			for (int i = 0; i < dataList.length(); i++) {
				JSONObject weather = dataList.getJSONObject(i);
				bw.write(weather.getInt("hour") + "시, " + weather.getInt("temp") + "도, " + weather.getString("wfKor") + "\n");
			}
			
			bw.close();
			br.close();
			con.disconnect();
			
		} catch (Exception e) { e.printStackTrace(); }		
	}

}
