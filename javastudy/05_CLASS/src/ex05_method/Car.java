package ex05_method;

public class Car {
	
	
	// 필드
	int oil;
	int speed;

	// 메소드
	
	// 1. 기름 넣기
	// 반환타입 : void (반환값이 없다)
	// 메소드명 : addOil
	// 매개변수 : int o
	void addOil(int o) {
		oil += o;
		if (oil > 60) {
			oil = 60;
		}
	}
	
	// 2. 달리기
	// 반환타입 : void
	// 메소드명 : pushAccel
	// 매개변수 : X
	void pushAccel() {
		if (oil == 0) {		//* 기름이 없을 경우, 달릴 수 없도록 설정
			return;  // 반환타입이 void일 때만 사용가능
		}
		if (speed == 120) {	//* 속도가 최대일 경우, 가속시 오일 감소하도록 설정
			oil--;
			return;
		}
		// 속도는 25씩 증가, 최대 속도 120
		// 기름은 1씩 사용
		speed += 25;		//* 가속시 속도가 증가하도록 설정
		oil--;				//* 가속시 오일이 감소하도록 설정
		if (speed > 120) {	//* 속도값이 120을 초과하지 않도록 설정
			speed = 120;
		}
		
	}
	
	// 3. 멈추기
	// 반환타입 : void
	// 메소드명 : pushBrake
	// 매개변수 : X
	void pushBrake() {
		// 속도는 25씩 감소
		if (speed == 0) {  //* 속도가 0일 경우, 브레이크 작동 X
			return;
		}
		
		speed -= 25;	   //* 속도가 0보다 클 경우, 속도 감속
		if (speed < 0) {   //* 속도가 0보다 작은 결과값일 경우, 속도는 0미만으로 출력되지 않도록 설정
			speed = 0;
		}
	}
	
	// 4. 계기판 (기름, 속도) 확인
	// 반환타입 : void
	// 메소드명 : panel
	// 매개변수 : X
	void panel() {
		System.out.println("기름 " + oil);
		System.out.println("속도 " + speed);
	}
}
