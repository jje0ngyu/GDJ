package ex04_throw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// throw
		// 1. 예외 객체를 만들어서 직접 throw할 수 있다.
		// 2. 자바는 예외로 인식하지 않지만 실제는 예외인 경우에 주로 사용된다.
		
		Scanner sc = new Scanner(System.in);
		
		try {
//			Scanner sc = new Scanner(System.in); // 여기에 있을 경우, finally블록이 인식할 수 없으므로, 메인블록으로 이동 ( scope 조정 )
			System.out.print("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			if(age < 0 || age > 100) {
				throw new RuntimeException("나이는 0 이상 100 이하만 가능합니다."); // String message;
			}
			System.out.println(age >= 20 ? "성인" : "미성년자");
//			sc.close();  // 여기에 있을 경우, 예외가 발생시 16,17번 줄은 실행하지 않기 때문에 여기까지 오지 않음. 떄문에 finally 사용
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {	// 실제로 finally는 자원을 반납할 때 주로 사용됨.
			sc.close(); //* finally에는 주로 close();가 들어감
			System.out.println("finally 블록 실행");
		}
	}

}
