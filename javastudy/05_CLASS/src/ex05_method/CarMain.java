package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Car car = new Car();
		
		car.addOil(50);
		car.addOil(5);
		car.addOil(100);    //* 기름양이 최대값을 초과하여 출력되는지 확인 
		
		car.pushAccel();	//* 증속 및 감유하는지 확인
		car.pushAccel();
		
		car.pushBrake();	//* 감속하는지 확인 
		
		
		car.panel();		//* 위의 모든 값이 적용되어 출력되는지 확인
		

	}

}
