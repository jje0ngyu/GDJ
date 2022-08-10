package ex11_downcasting;

public class Main {

	public static void main(String[] args) {

		// 임의의 자동차 10대 배열에 저장하기 (33% 확률로 랜덤 생성)
		
		
		Car[] cars = new Car[10];
		
			for (int i = 0; i < cars.length; i++) {
				if(Math.random() < 0.33) {
					cars[i] = new Car();
				} else if (Math.random() < 0.66) {
					cars[i] = new Ev();
				} else {
					cars[i] = new Hybrid();
				}
			}

		// Car이면 drive() 호출
		// Ev이면 charge() 호출
		// Hybrid이면 addOil() 호출
			
		//* 상속 관계일 경우, 서브클래스를 먼저 if문에, 슈퍼클래스를 마지막 else에 넣는다.
		//* if에 슈퍼클래스를 넣을 경우, 모든 결과값이 슈퍼클래스가 된다. (ex. '운전하다' 10개)
		for (int i = 0; i < cars.length; i++) {
			if(cars[i] instanceof Hybrid) {
				((Hybrid)cars[i]).addOil();
			} else if(cars[i] instanceof Ev) {
				((Ev)cars[i]).charge();
			} else if (cars[i] instanceof Car) {
				cars[i].drive();
			}
		}
		
		
	}

}
