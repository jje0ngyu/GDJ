package prac2;
//* 수정 필요 : 선생님 깃허브 참고할 것.
import java.util.Scanner;

public class SeatGroup {
	
	private String seatType; 	// "S", "R", "A"
	private Seat[] seats;		//* 좌석 순서는 사용자가 임의로 선택하기 때문에, 인덱스는 필요없다. (순차적으로 관리할 필요없음)
	private Scanner sc;
	
	public SeatGroup(String seatType, int cnt) {	//* new SeatGroup("S", 10);
		this.seatType = seatType;
		seats = new Seat[cnt];	//* 아직 생성되지 않음
		for (int i = 0; i < cnt; i++) {
			seats[i] = new Seat();	//* 빈 좌석 가져다두기.	이 작업을 하지 않으면 seats 값은 null이됨.
		}
		sc = new Scanner(System.in);
	}
	
	// 예약
	public boolean reserve() {
		reserveInfo();	//* 예약 현황 보여주기
		// 시트번호는 1번부터 시작
		System.out.println("예약할 시트번호 >>> ");
		int seatNo = sc.nextInt();
		if (seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false;
		}
		// 예약된 시트인지 확인
		if (seats[seatNo-1].isOccupied()) {	// true : 예약되었다면~
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;
		}
		// 예약 진행
		System.out.println("예약자 이름 >>> ");
		String name = sc.next();
		seats[seatNo-1].reserve(name);
		System.out.println(seatNo + "번 좌석 예약이 완료되었습니다.");
		return true;
	}
	
	// 예약 취소
	public boolean cancel() {
		reserveInfo();	//* 예약 현황 보여주기
		System.out.println("취소자 이름 >>> ");
		String name = sc.next();
		for (int i = 0; i <seats.length; i++) {
			if(seats[i].isOccupied()) {			// 예약된 좌석만 비교  seats[i] != null  로 하면 안됨. 모든 시트는 != null
				if(seats[i].isMatched(name)) {	// 예약자 이름과 취소자 이름이 같으면 true 반환
					seats[i].cancel();
					System.out.println("예약자 " + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		} // for
		System.out.println(name + "으로 예약된 좌석이 없습니다.");
		return false;
	}
	
	// 예약 상황 출력
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].isOccupied()) {
				System.out.print(seats[i].getName().substring(0, 1) + "* ");
			} else {
				System.out.print((i + 1) + (i < 9 ? "   " : "  "));
			}
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}

}
