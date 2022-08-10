package quiz08_schedule;

import java.util.Scanner;

public class WeekScheduler {

	private int nthWeek; 	// 1 ~ n주차
	private Day[] week;		//* 선언만 한 상태. 생성해야함
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"}; 	//* 등록할 때, 요일 등록
	private Scanner sc;
	
	
	
	//* manage 만 호출할 수 있도록 private 로 변경
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];
		sc = new Scanner(System.in);
	}
	
	private void makeSchedule() {
		System.out.println("***** 등록 *****");
		System.out.println("요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);	//* substring 을 통해 사용자가 "월요일"을 입력하더라도 "월" 이라고 인식할 수 있도록 지원 
		sc.nextLine();	//* 요일 입력 후 Enter
		for (int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) { //* 요일을 찾아서
				if(week[i] == null) { 	// 등록된 스케줄이 없으면
					System.out.print("스케줄 입력 >>> ");	//* 내용 입력
					String schedule = sc.nextLine();	// 스케줄에 공백 입력이 가능함
					Day day = new Day();
					day.setSchedule(schedule); //* 만들어진 하루
					week[i] = day;				//* 만들어진 하루를 배열에 넣는다.
					System.out.println(dayName + "요일에 새 스케줄이 등록되었습니다.");
				} else {
					System.out.println(dayName + "요일은 이미 스케줄이 있습니다.");
				}
				return;
			} 
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");  //* for문 안에 넣으면, week[i]별로 문구 출력됨
	}
	
	private void changeSchedule( ) {
		System.out.println("***** 수정 *****");
		
		// 변경할 요일 입력 >>> 수
		
		// 수요일의 스케줄은 야자입니다.
		// 변경할까요?(y/n) >>> y
		// 변경할 스케줄 입력 >>> 헬스
		// 수요일의 스케줄이 변경되었습니다.
				
		// 변경햘 요일 입력 >>> 목
		// 목요일은 스케줄이 없습니다.
		// 새 스케줄을 등록할까요?(y/n)
		// 새 스케줄 입력 >>> 야자
		// 목요일에 새 스케줄이 등록되었습니다.
		
		System.out.println("변경할 요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		
		for (int i = 0; i < week.length; i++) {
			if (dayName.equals(dayNames[i])) {	//* 입력된 요일 찾기
				if (week[i] == null) {			//* 등록된 스케줄이 있는지 확인
					System.out.println(dayName + "요일은 스케줄이 없습니다.");
					System.out.println("새 스케줄을 등록할까요?(y/n)");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if (yesNo.equalsIgnoreCase("y")) {
						System.out.println("새 스케줄 입력 >>> ");
						String schedule = sc.nextLine();
						Day day = new Day();
						day.setSchedule(schedule); //* 새로 만들 스케줄
						week[i] = day;
						System.out.println(dayName + "요일에 새 스케줄이 등록되었습니다.");
					}
					
				} else {
					System.out.println(dayName + "요일의 스케줄은 " + week[i].getSchedule() + "입니다.");
					System.out.println("변경할까요?(y/n) >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if (yesNo.equalsIgnoreCase("y")) {
						System.out.println("변경할 스케줄 입력 >>> ");
						String newSchedule = sc.nextLine(); //* 공백 입력 허용
						
						week[i].setSchedule(newSchedule);  //* 기존에 등록된 곳에 옮겨 적으면 되기 때문에 new 클래스 필요없음.
						
						System.out.println(dayName + "요일의 스케줄이 " + week[i].getSchedule() + "(으)로 변경되었습니다.");
					}
				} return;
			} 
		} 
		System.out.println(dayName + "요일은 없는 요일입니다.");
		
	}
	
	private void deleteSchedule() {
		System.out.println("***** 삭제 *****");
		
		// 삭제할 요일 입력 >>> 수
		// 수요일의 스케줄은 야자입니다.
		// 삭제할까요? (Y/N) >>> Y
		// 수요일의 스케줄이 취소되었습니다.
		
		System.out.println("삭제할 요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for (int i = 0; i < week.length; i++) {
			if (dayName.equals(dayNames[i])) {
				
				// 삭제할 요일 입력 >>> 목
				// 목요일은 스케줄이 없습니다.
				if (week[i] == null) {
					System.out.println(dayName + "요일은 스케줄이 없습니다.");
				} else {
					System.out.println(dayName + "요일의 스케줄은 " + week[i].getSchedule() + "입니다");
					System.out.println("삭제할까요(Y / N)? >>> ");
					String yesNo = sc.next().substring(0, 1);
					sc.nextLine();
					if (yesNo.equalsIgnoreCase("y")) {  //* 대소문자 구분X
						week[i] = null;
						System.out.println(dayName + "요일의 스케줄이 취소되었습니다.");
					} else {
						System.out.println("스케줄 삭제가 취소되었습니다.");
					}
				}
				return;
			}
		}
		
		// 삭제할 요일 입력 >>> 하
		// 하요일은 없습니다.
		System.out.println(dayName + "요일은 없는 요일입니다.");
		
		

		
		
	}
	
	private void printWeekSchedule() {
		System.out.println("***** 전체조회 *****");
		System.out.println(nthWeek + "주차 스케줄 안내");
		for (int i = 0; i < week.length; i++) {
			System.out.print(dayNames[i] + "요일 - ");
			System.out.println(week[i] == null ? "X" : week[i].getSchedule());
		}
	}
	
	public void manage() {
		
		while(true) {
			
			System.out.print("1.등록 2.수정 3.삭제 4. 전체목록 0.프로그램종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine(); //* 번호 입력 후 Enter
			
			switch(choice) {
			case 1 : makeSchedule(); break;
			case 2 : changeSchedule(); break;
			case 3 : deleteSchedule(); break;
			case 4 : printWeekSchedule(); break;
			case 0 : System.out.println("스케줄러를 종료합니다."); return;
			default : System.out.println("인식할 수 없는 명령입니다.");
			}
		}
		
	}
	
}
