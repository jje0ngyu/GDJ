package quiz01_updown;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {

	// 필드
	private int rand; 	// 1 ~ 100 사이 난수
	private int count;	// 시도 횟수
	private Scanner sc;	// 입력될 난수
	
	int num; 
	// 생성자
	public UpDownGame() {
		
		// rand, sc 만들기
		rand = (int)(Math.random() * 100) + 1;
		sc = new Scanner(System.in);
		
	}
	
	// 입력
	public int input() {
		try { 
			count ++;		
		
			System.out.print(" 숫자를 입력하세요. (1~100)");
			int n = sc.nextInt();
			if ( n < 1 || n > 100) {
				throw new RuntimeException("1 ~ 100 사이 정수만 입력할 수 있습니다.");
			}
			return n;
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.next(); 	 	// 잘못 입력된 문자열 먹어 치우기
			input();		// 다시 실행 (재귀호출)
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0;	// 이클립스가 인식하길 try일 경우에만 반환이 있고, 예외의 경우 return이 없기 때문에 구조상 넣어줌.
	}
	
	// 실행
	public void play() {
		
		// 맞힐 때까지 무한 루프
		
		while (true) {
			
			int n = input();
			
			if (n < rand) {
				System.out.println("Up!");
			} else if (n > rand) {
				System.out.println("Down!");
			} else {
				System.out.println(rand + " 정답입니다." + count + "번만에 정답!");
				break;
			}
		}
		
		
	}
	
}
