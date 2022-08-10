package parking;

import java.util.Scanner;

public class ParkingLot {
	
	// 필드
	private String name; 	// 주차장 이름
	private Car[] cars;		// Car 인스턴스를 저장할 수 있는 배열
	private int idx;		// 배열 인덱스
	private Scanner sc;		// 키보드 입력을 처리하는 인스턴스
	
	
	// 생성자
	public ParkingLot (String name) {
		// 매개변수로 주차장 이름을 전달 받아서 필드를 초기화하고
		// 길이가 10인 cars 배열을 생성하고
		// 키보드로부터 정보를 입력 받을 수 있는 sc인스턴스를 생성한다.
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}	
	
	
	private void addCar() throws RuntimeException {
//		(1) 가장 먼저 "현재 등록된 차량 0대"와 같은 메시지를 출력한다.
//      (2) 주차장이 가득찬 경우 "더 이상 차량 등록이 불가능합니다." 메시지를 출력하고 addCar() 메소드를 종료한다.
//      (3) sc 인스턴스를 이용해서 차량번호와 모델명을 입력 받은 뒤 cars 배열에 순차적으로 저장한다.
//      (4) 차량번호와 모델명은 공백 없는 문자열로 처리한다.
//      (5) 차량번호가 "288러1111"과 같은 차량의 등록이 성공하면 "차량번호 288러1111 차량이 등록되었습니다." 메시지를 출력한다.
//      (6) 기타 명시되지 않은 예외는 발생하지 않는 것으로 가정한다.
		
		System.out.println("현재 등록된 차량 " + idx + "대");
		
		if ( idx == cars.length)  {
			throw new RuntimeException("더 이상 차량 등록이 불가능합니다.");
		}
		
		System.out.print("차량번호 >>> ");
		String carNo = sc.next().replace(" ", "");
		System.out.print("모델 >>> ");
		String model = sc.next().replace(" ", "");
		
		
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
		

	}
	
	private void deleteCar() throws RuntimeException {
//			(1) 주차장이 비어 있는 경우 "등록된 차량이 없습니다." 메시지를 출력하고 deleteCar() 메소드를 종료한다.
//	        (2) sc 인스턴스를 이용해서 제거할 차량번호를 입력 받은 뒤 해당 차량번호와 일치하는 정보를 삭제한다.
//	        (3) 차량번호가 "288러1111"인 차량을 삭제한 경우 "차량번호 288러1111 차량이 삭제되었습니다." 메시지를 출력한다.
//	        (4) 입력된 차량번호와 일치하는 정보가 없는 경우 "대상 차량이 존재하지 않습니다." 메시지를 출력한다.
		if (idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		
		System.out.print("제거할 차량번호 >>> ");
		String carNo = sc.next().replace(" ", "");
		
		for (int i = 0; i < idx; i++) {
			if (cars[i].getCarNo().equals(carNo)) {
				System.arraycopy(cars, i +1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호 " + carNo + "차량이 삭제되었습니다.");
				return;
			} 
			
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
		
	}
	
	private void printAllCars() throws RuntimeException {
		
//			(1) 주차장이 비어 있는 경우 "등록된 차량이 없습니다." 메시지를 출력하고 printAllCars() 메소드를 종료한다.
//	        (2) 가장 먼저 주차장이름을 출력한다.
//	        (3) 저장된 모든 차량(cars) 정보를 System.out.println() 메소드를 이용해서 출력한다.
		
		if (idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		
		System.out.println(name);
		for (int i = 0; i <idx; i++) {
			System.out.println(cars[i]);
		}
	}
	
	public void manage() {
//		(1) "1.추가 2.삭제 3.전체 0.종료" 메뉴를 운용한다.
//      (2) 무한루프 내부에서 사용자 입력(1,2,3,0)에 따라서 적절한 메소드를 호출한다.
//		(3) 잘못된 메뉴를 입력한 경우 "존재하지 않는 메뉴입니다." 메시지를 출력한다.
		while (true) {
			try {
				System.out.print("1.추가  2.삭제  3.전체  0.종료 >>> ");
				int input = sc.nextInt();
				sc.nextLine();
				
				switch (input) {
				case 1 : addCar(); break;
				case 2 : deleteCar(); break;
				case 3 : printAllCars(); break;
				case 0 : System.out.println("주차장 프로그램을 종료합니다.");
					return;
				default : System.out.println("존재하지 않는 메뉴입니다.");
				}
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		
		} // while  끝.
      
	}
	
}
