package prac1;

import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		System.out.println("===문제1===");
		q1();
		System.out.println("===문제2===");
		//q2();
		System.out.println("===문제3===");
		//q3();
		System.out.println("===문제4===");
		//q4();
		System.out.println("===문제5===");
		//q5();
		System.out.println("===문제6===");
		//q6();
		System.out.println("===문제7===");
		q7();
		System.out.println("===문제8===");
		q8();
		System.out.println("===문제9===");
		//q9();
		System.out.println("===문제10===");
		//q10();
	}
	
	public static void q1() {
		// 1. 점수와 학년을 입력받아 60점 이상이면 합격, 60점 미만이면 불합격을 출력하시오.
		//4학년인 경우 70점 이상이어야 합격이다.

		//점수를 입력하세요(0~100) >>> 65
		//학년을 입력하세요(1~4) >>> 1
		//합격!

		//점수를 입력하세요(0~100) >>> 65
		//학년을 입력하세요(1~4) >>> 4
		//불합격!
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요 >>> ");
		int score = sc.nextInt();
		System.out.println("학년을 입력하세요 >>> ");
		int grade = sc.nextInt();
		
		if (grade == 4) {
			System.out.println(score >= 70 ? "합격" : "불합격");
		} else {
			System.out.println(score >= 60 ? "합격" : "불합격");
		}
		
		
	}
	
	
	
	public static void q2() {
		// 2. 커피 메뉴를 입력받아 가격을 알려주는 프로그램을 구현하시오. switch 문을 이용하여 구현하시오.

		// (에스프레소, 카푸치노, 카페라떼는 3500원, 아메리카노는 2000원이다.)

		// 무슨 커피 드릴까요? >>> 에스프레소
		// 에스프레소는 3500원입니다.

		// 무슨 커피 드릴까요? >>> 아메리카노
		// 아메리카노는 2000원입니다.

		// 무슨 커피 드릴까요? >>> 밀크커피
		// 밀크커피는 메뉴에 없습니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("무슨 커피 드릴까요?");
		String coffee = sc.nextLine();
		
		switch (coffee) {
			case "에스프레소" :
			case "카푸치노" :
			case "카페라떼" : System.out.println(coffee + "는 3500원입니다."); break;
			case "아메리카노" : System.out.println(coffee + "는 2000원입니다."); break;
			default : System.out.println(coffee + "는 메뉴에 없습니다.");
		}
		
	}
	
	
	
	public static void q3() { 
		// 3. 돈을 입력받아 오만원권, 만원권, 오천원권, 천원권, 오백원 동전, 백원 동전,
		// 오십원 동전, 십원 동전, 오원 동전, 일원 동전이 각각 몇 개로 변환되는지 출력하시오.
		// 이 때 반드시 다음과 같은 배열을 사용하여 반복문으로 처리하시오.

		// int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		// 금액을 입력하시오 >> 75832
		// 50000원 짜리 : 1개
		// 10000원 짜리 : 2개
		// 5000원 짜리 : 1개
		// 500원 짜리 : 1개
		// 100원 짜리 : 3개
		// 10원 짜리 : 3개
		// 1원 짜리 : 2개
		
		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력하시오 >> ");
		int money = sc.nextInt();
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		
		for(int i = 0; i<unit.length; i++) {
            System.out.println(unit[i] + "원 : " + (money/unit[i]) + "개");
            money %= unit[i]; // money를 unit[i]로 나누고 그 나머지를 money에 대입한다. 
		}

	}
	
	
	
	public static void q4() {
		// 4. 정수를 몇 개 저장할지(최대 100개) 입력받아서 해당 길이를 가진 배열을 생성하고,
		// 이곳에 1에서 100사이 범위의 정수를 랜덤하게 삽입하시오. 같은 값은 생성하지 못하도록 설정하고
		// 생성된 배열을 출력하시오.

		// 몇 개의 랜덤을 생성할까요? >>> 150
		// 다음에는 1~100사이로 입력하세요!

		// 몇 개의 랜덤을 생성할까요? >>> 25

		// 29     64     47     14     37     61     83     33     65     96

		// 48     44     92     77     70     34     23     35     13     68

		// 74     15     67     42     38
		
		
		int n = 0;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("몇 개의 랜덤을 생성할까요? >>> ");
			n = sc.nextInt();
				if (n >100) {
					System.out.println("다음에는 1~100사이로 입력하세요!");
				} else {
					break;
				}
		}
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int)((Math.random()* 100) + 1);
			
			// 줄 나누기
			if ((i % 11) > 0) {
			System.out.print(arr[i] + " ");
			} else {
				System.out.println();
			}
		}
	}
	
	
	
	public static void q5() {  
		// 5. 3명의 학생의 점수를 입력 받아서 평균 점수와 1등의 이름과 꼴등의 이름을 출력하시오.

		// 피카츄의 점수 입력 >>> 75
		// 뽀로로의 점수 입력 >>> 95
		// 브레드의 점수 입력 >>> 85
		// 평균: 85.0점

		// 1등: 뽀로로
		// 3등: 피카츄
		
		

		
		String[] std = {"피카츄", "뽀로로", "브레드"};
		int total = 0; 
		
		int[] score = new int[std.length];
	
		
		String top = "";
		String bottom = "";
		
		// 점수 입력하기
		for (int i = 0; i < std.length; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println(std[i] + "의 점수 입력 >>> ");
			score[i] = sc.nextInt();
		}
		
		int max = score[0];
		int min = score[0];
		
		// 평균 점수 구하기
		for (int i = 0; i < score.length; i++) {
			total += score[i] ;
			System.out.println(score[i]);
		}
		System.out.println("평균: " + (double) total / std.length + "점");

		
		// 최고점, 최저점 구하기
		for (int i = 0; i < std.length; i++) {
			if (max < score[i]) {
				max = score[i];
				top = std[i];

			}
			if (min >= score[i]) {
				min = score[i];
				bottom = std[i];
			}
		}

		// 이름 출력	
		System.out.println("1등: " + top);
		System.out.println("3등: " + bottom);
		
		
	}
	
	
	public static void q6() {  
		// 6. 랜덤으로 윷놀이를 구현하시오. 도개걸윷모 중 랜덤 생성하여 이동 횟수와 함께 화면에 출력하시오.
		// 윷이나 모가 나오면 계속 랜덤 생성하여 총 이동 횟수를	계산하여 출력하시오.

		// 도 : 1칸 이동
		// 개 : 2칸 이동
		// 걸 : 3칸 이동
		// 윷 : 4칸 이동
		// 모 : 5칸 이동

		// 예시1) 개, 2칸 이동한다.
		// 예시2) 윷, 걸, 7칸 이동한다.
	
	
		String[] yut = {"도", "개", "걸", "윷", "모"};
		int result = 0;
		
		while (true) {
			// 도
			int move = ((int)(Math.random() * 5)); // 0~4
			
			// 이동 칸 수 표기
			result += move + 1;  //* 복합 연산자가 있을 경우, 문법 밖에서 변수 선언할 것!
			
			if (move < 3) {
				
				System.out.println(yut[move] + ", " + result + "칸 이동");
				break;
			} else {
				System.out.print(yut[move] + ", ");
			}
			
			
		}
		
	}	
	
	
	
	public static void q7() {
			// 경과시간을 맞추는 게임을 작성하시오. 
			// 첫 번째 <Enter>를 누르면 해당 시점의 초 시간을 보여주고
			// 두 번째 <Enter>를 누르면 해당 시점의 초 시간을 다시 보여준다.
			// 여기서 10초에 근접하도록 <Enter>를 누른 사람이 이기는 게임이다.

			// <hint>
			// 1. <Enter>를 누른다. : Scanner 클래스의 nextLine() 메소드는 <Enter>를 인식함
			// 예) <Enter>를 누르면 1000이 출력되는 코드

			// Scanner sc = new Scanner(System.in);
			// sc.nextLine();
			// System.out.println(1000);

			// 2. 경과 시간 : System.currentTimeMillis()를 이용해 <Enter>를 누른 시간을 2개 구하고,
			// 그 차이를 구한 뒤 0.001을 곱하면 초 단위로 결과를 확인할 수 있다.

			// 강아지님 시작하려면 <Enter>를 누르세요.
			//=== 시작 시간(초): 10
			// 10초가 된 것 같으면 <Enter>를 누르세요.
			// === 종료 시간(초): 17
			// 고양이님 시작하려면 <Enter>를 누르세요.
			// === 시작 시간(초): 21
			// 10초가 된 것 같으면 <Enter>를 누르세요.
			// === 종료 시간(초): 29
			// 강아지님 결과 7초, 고양이님 결과 8초, 승자는 고양이님입니다.
			
		
			Player p1 = new Player("강아지");
			Player p2 = new Player("고양이");
			
			double res1 = p1.turn();
			double res2 = p2.turn();
			
			if (Math.abs(res1 - 10) < Math.abs(res2 - 10)) {
				System.out.println(p1.getName() + "님 승리." + res1 + "초 소요.");
			} else {
				System.out.println(p2.getName() + "님 승리." + res2 + "초 소요.");
			}
			
				
			
			

			
			
	}
	
	
	
	public static void q8() {
		// 8. 다음 main 메소드를 참고하여 Watch 클래스를 구현하시오.
		// public static void main(String[] args) {

		Watch watch = new Watch(16, 15, 30);
		watch.addHour(25);         // 25시간 후(1시간)
		watch.addMinute(61);       // 61분 후  (1시간 1분)
		watch.addSecond(3661);     // 3661초 후(1시간 1분 1초)

		watch.see();  // 19시 17분 31초

		// }

		// 19시 17분 31초
		
	}
	

	
	public static void q9() {
		// 9. 다음 main 메소드를 참고하여 BankAccount 클래스를 구현하시오.
		// public static void main(String[] args) {

		BankAccount me  = new BankAccount("1234", 10000);
		BankAccount mom = new BankAccount("4321", 100000);

		//me.deposit(10000);  // 내 계좌에 10000원 입금
		//me.deposit(-100);   // 내 계좌에 마이너스 입금 (불가)

		//me.withdraw(5000);  // 내 계좌에서 5000원 출금
		//me.withdraw(100);   // 내 계좌에서 잔액보다 큰 금액 출금 (불가)

		//me.inquiry();  // 계좌번호: 1234, 잔액: 15000원
		mom.deposit(50000);
		mom.transfer(me, 50000);  // 엄마가 나에게 50000원 이체
		// mom.transfer(me, -100);  // 실패

		// mom.transfer(me, 100000000);  // 실패

		mom.inquiry();  // 계좌번호: 4321, 잔액: 50000원
		me.inquiry();  // 계좌번호: 1234, 잔액: 64900원

		// }

		// 계좌번호: 1234, 잔액: 14900원
		// 계좌번호: 4321, 잔액: 50000원
		// 계좌번호: 1234, 잔액: 64900원
		
		

	}
	
	public static void q10() {
		// 10. 다음 main 메소드를 참고하여 Gun 클래스와 Soldier 클래스를 구현하시오.
		// public static void main(String[] args) {

		Gun gun = new Gun("K2", 2);  // 모델명, 총알수
		
		// Soldier soldier = new Soldier("람보", gun);  // 군인명, 총
		
		Soldier soldier = new Soldier("람보", gun);
		
		
		soldier.shoot();  // 빵야! 1발 남았다.
		soldier.shoot();  // 빵야! 0발 남았다.
		soldier.shoot();  // 헛빵!

		soldier.reload(3);  // 3발이 장전되었다. 현재 3발.
		soldier.reload(3);  // 3발이 장전되었다. 현재 6발.
		soldier.reload(0);  // 0발이 장전되었다. 현재 6발.

		soldier.info();

		// }

		// 빵야! 1발 남았다.
		// 빵야! 0발 남았다.
		// 헛빵!

		// 3발 장전되었다. 현재 3발

		// 3발 장전되었다. 현재 6발

		// 0발 장전되었다. 현재 6발
		// 람보 : K2(6)
	}
}
