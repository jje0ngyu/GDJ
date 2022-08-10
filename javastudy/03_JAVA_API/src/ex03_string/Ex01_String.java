package ex03_string;

public class Ex01_String {

	public static void main(String[] args) {
		
		
		String str1 = "hello";
		String str2 = "hello";
		/*
		     |-------|
		str1 | 0x123 |
		     |-------|
		str2 | 0x123 |
		     |-------|
		     | hello | 0x123   (* str1 과 str2 의 주소값이 같기 때문에 서로 같은 값이다.) 
		     |-------|		
		 */
		
		System.out.println(str1 == str2); // * 자바에서, 문자열의 동등비교는 '=='을 사용하지 않는다! 지금은 예시를 위해 사용.
				
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		/*
		     |-------|
		str3 | 0x123 |
		     |-------|
		str4 | 0x456 |
		     |-------|
		     | hi    | 0x123
		     |-------|
		     | hi    | 0x456   (* str3 와 tsr4 의 주소값이 다르기 때문에 서로 다른 값이다.)
		     |-------| 	
		 */
		System.out.println(str3 == str4);
		
		
		// 1. 문자열 동등 비교
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		System.out.println(result1);
		System.out.println(result2);
		
		if (str1.equals(str2)) {
			System.out.println("같아요");
		} else {
			System.out.println("달라요");
		}
		
		// '!' 연산자는 가급적 사용하지 않는다.
		// (1) 잘 보이지 않기 때문
		// (2) 흐름이 어색하기 때문
		if (!str3.equals(str4)) {
			System.out.println("str3, str4는 달라요");
		} else {
			System.out.println("str3, str4는 같아요");
		}
		
		
		// 2. 대소문자를 무시한 문자열 동등 비교
		String str5 = "Hello Wolrd";
		String str6 = "hELLO wOLRD";
		
		System.out.println(str5.equals(str6)); // * 대소문자는 1글자라도 다르면, 다른 문자이다.
		
		boolean result3 = str5.equalsIgnoreCase(str6);  // * Ignore Case : Upper Case 와 Lower Case 를 구분하지 말라.
		System.out.println(result3);
		
		
		// 3. 문자열 길이 반환
		String name = "정유정";
		int length = name.length();
		System.out.println("글자수 : " + length);  // * 공백(띄어쓰기)도 글자수 1로 포함된다.
		
		
		// 4. 특정 위치의 문자(char)만 반환
		// 특정 위치 = 인덱스(Index, 색인) 라고 함
		// 글자마다 부여된 정수값
		// 0으로 시작
		
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
		
		// (★★) 5. 문자열의 일부 문자열(String)을 반환
		// 		    1) substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		// 		    2) substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end(불포함)까지 반환
		System.out.println(name.substring(0, 1));
		System.out.println(name.substring(1));
		
		
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환
		// * 인덱스 변수 : idx, i
		// 	1) indexOF
		//	    (1) 발견된 첫 번째 문자열의 인덱스를 반환
		//		(2) 발견된 문자열이 없는 경우 -1을 반환
		//	2) lastIndexOF
		//		(1) 발견된 마지막 문자열의 인덱스를 반환
		//		(2) 발견된 문자열이 없는 경우 -1을 반환
		int idx1 = name.indexOf("정");
		int idx2 = name.indexOf("유정");
		int idx3 = name.lastIndexOf("정");
		int idx4 = name.lastIndexOf("유정");
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		System.out.println(idx4);
		
		
		// 7. 문자열이 특정 패턴으로 시작하는지 여부를 boolean(true, false) 반환
		//	  startWith(문자열)
		if(name.startsWith("정")) {
			System.out.println("정씨입니다.");
		} else {
			System.out.println("정씨가 아닙니다.");
		}
		
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		//	  endWith(문자열)
		String filename = "image.jpg";  // jpg,png로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
		
		// 9. 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		String email = "gt_min@naver.com";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		}
		
		
		// 10. 불필요한 공백 제거 (좌우 공백)  * 중간 공백 제거X
		String message = "  안녕  하세요  ";
		System.out.println(message.trim());  // "안녕  하세요"
		System.out.println(message.trim().length());
		
		
		// 11. 대소문자 변환하기
		// toUpperCase() : 대문자로 변환하기
		// toLowerCase() : 소문자로 변환하기
		String source = "best of best";
		System.out.println(source.toUpperCase());
		System.out.println(source.toLowerCase());
		
		
		// 12. 찾아 바꾸기
		// replace(old, new) : old를 new로 변환하기
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		// 주의, replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_");  // 192_168_101_91를 기대   * replaceAll(".", "_")은 모든 문자를 '_'로 변환 (!= replace)
		System.out.println(replacedIp);											// . 이 모든 문자를 의미하기 때문
		
		
		// 13. 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		String id =" ";
		if(id.isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}

		if(id.trim().isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		// isBlank는 @since 11
		if(id.isBlank() ) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		
		// (♣) 연습. 파일이름을 파일명과 확장자로 분리
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		String fullName = "apple.jpg";
		String fileName = "";  // apple
		String extName = "";   // jpg
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		
		System.out.println(fileName);
		System.out.println(extName);
		
		
		
		// (♣) 연습2. 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 1234567890을 제외하고 한 글자씩 화면에 출력하시오.
		String str = "abc12345def67890ghijk";
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9') {
				continue;
			}
			System.out.println(ch);
		}
		
		
		
	}

}
