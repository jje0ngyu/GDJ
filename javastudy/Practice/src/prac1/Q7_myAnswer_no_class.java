package prac1;

import java.util.Scanner;

public class Q7_myAnswer_no_class {
	public static void main(String[] args) {
	
		double time = System.currentTimeMillis();
		
		// 참여자 이름 배열 변수 선언
		String[] str = {"강아지", "고양이"};
		String vic = str[0];
		int[] record = new int[str.length];
		
		int i = 0;
		
		
		// 참여자별 시작/종료 <Enter>
		for (i = 0; i < str.length; i++ ) {
			Scanner sc = new Scanner(System.in);
			System.out.print( str[i] +"님 시작하려면 <Enter>를 누르세요.");
			sc.nextLine();
		
			double startTime = System.currentTimeMillis(); 
			int result1 = (int)((startTime - time) * 0.001);
			System.out.println("=== 시작 시간 (초): " + result1 );
			
			System.out.print("10초가 된 것 같으면 <Enter>를 누르세요.");
			sc.nextLine();
		
			double endTime = System.currentTimeMillis();
			int result2 =(int)((endTime - time) * 0.001);
			System.out.println("=== 종료 시간 (초): " + result2);
			

			record[i] = result2 - result1; // 참여자별 '종료시간 - 시간시간' 출력
			int min = record[i];
			if (min <= 10) {
				min = record[i];
				System.out.println("최소 비교값 : " + min);
				vic = str[i];
			}
			
		}

		
		for (i = 0; i < str.length; i++) {
		System.out.print(str[i] + "님 결과 " + record[i] + "초, ");
		}
		System.out.print("승자는 " + vic + "님 입니다.");	
		
	}	

}
