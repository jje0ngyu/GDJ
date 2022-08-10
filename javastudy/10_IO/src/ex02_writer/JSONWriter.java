package ex02_writer;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {

	public static void m1() {
		
		// JSON
		// 1. JavaScript Object Notation
		// 2. 자바스크립트 객체 표기법
		// 3. 객체 : { }
		// 4. 배열 : [ ]
		
		// JSON-Java (JSON in Java) 라이브러리
		// 1. 객체 : JSONObject 클래스 사용 (Map 기반 * 맵과 사용법 유사)
		// 2. 배열 : JSONArray 클래스 (List 기반 * ArrayList와 사용법 유사)
		
		JSONObject obj = new JSONObject(); 
		// 입력
		obj.put("name", "인절미");
		obj.put("age", 9);
		obj.put("man", true);
		obj.put("height", 2.3);
		System.out.println(obj.toString());
	}
	
	public static void m2() {
		
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "제임스");
		obj1.put("age", 30);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "에밀리");
		obj2.put("age", 40);
		
		JSONArray arr = new JSONArray();
		arr.put(obj1);
		arr.put(obj2);
		System.out.println(arr.toString());
		
	}
	
	public static void m3() {
		System.out.println("=== JSON 데이터 읽어들이기 연습 === "); //* 공공API에게 받아온 데이터
		
		String str = "{\"name\":\"인절미\",\"man\":true,\"age\":9,\"height\":2.3}";
		
		JSONObject obj = new JSONObject(str);
		
		String name = obj.getString("name"); //* 오브젝트에 있는 것을 사용하기 위해선 캐스팅 해야한다.
		boolean man = obj.getBoolean("man");
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		
		System.out.println(name);
		System.out.println(man);
		System.out.println(age);
		System.out.println(height);
		
	}
	
	public static void main(String[] args) {
		m3();
	}
}
