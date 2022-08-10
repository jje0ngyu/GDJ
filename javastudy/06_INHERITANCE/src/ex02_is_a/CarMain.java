package ex02_is_a;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		
		System.out.println("자동차");
		car.drive();

		Ev ev = new Ev();
		System.out.println("전기차");
		ev.drive();
		ev.charge();
		
		Hybrid hybrid = new Hybrid();
		System.out.println("하이브리드차");
		hybrid.drive();
		hybrid.charge();
		hybrid.addOil();
	}

}
