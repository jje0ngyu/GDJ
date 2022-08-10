package ex04_input;

import java.util.Scanner;

public class Ex02_Scanner {

	public static void main(String[] args) {
		
		// java.util.Scanner 클래스
		// 데이터타입별로 입력 받을 수 있는 메소드를 제공
		// int    : nextInt()
		// long   : nextLong()
		// double : nextDouble()
		// String : nextLine() - 공백 포함 입력, next() - 공백 포함 불가능
		
		Scanner sc = new Scanner(System.in);  // 객체 sc는 System.in(키보드)으로부터 입력을 받는다.
		
		System.out.print("이름을 입력하세요 >>> ");
		String name = sc.next();    //* 없으면 키보드 입력이 안 된다.
		
		System.out.print("나이를 입력하세요 >>> ");
		int age = sc.nextInt();     //* nextInt()는 next()와 달리 숫자만 입력할 수 있다.
		
		System.out.println(name);
		System.out.println(age);
		
				
		// 연습. char 타입의 성별을 입력 받기
		System.out.print("성별(남/여)을 입력하세요 >>> ");
		char gender = sc.next().charAt(0);    //* charAt() : 입력된 글자의 첫 글자만 출력
		System.out.println(gender);
				
		sc.close();  // 생략이 가능하다.
		
		
	}

}
