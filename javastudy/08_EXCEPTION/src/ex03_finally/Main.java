package ex03_finally;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// finally 블록
		// 1. try-catch문 마지막에 추가하는 블록
		// 2. 언제나 마지막에 실행되는 블록
		Scanner sc = new Scanner(System.in);
		
		try {
//			Scanner sc = new Scanner(System.in); // 여기에 있을 경우, finally블록이 인식할 수 없으므로, 메인블록으로 이동 ( scope 조정 )
			System.out.print("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			System.out.println(age >= 20 ? "성인" : "미성년자");
//			sc.close();  // 여기에 있을 경우, 예외가 발생시 16,17번 줄은 실행하지 않기 떄문에 여기까지 오지 않음. 떄문에 finally 사용
			
		} catch (Exception e) {
			System.out.println("예외 발생");
			
		} finally {	// 실제로 finally는 자원을 반납할 때 주로 사용됨.
			sc.close(); //* finally에는 주로 close();가 들어감
			System.out.println("fanally 블록 실행");
		}
	}

}
