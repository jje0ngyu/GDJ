package ex14_interface;

public class Circle implements Shape {

	//* implements : 구현하라.
	//* 인터페이스를 상속 받아서 구현하는 것. (즉 extends 와 같은 의미이지만, 구분해서 사용)
	private double radius;

	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	
	@Override
	public double getArea() {
		return PI * Math.pow(radius, 2); 		//* 인터페이스 Shape 에서 선언해준 pi의 상수값을 가져옴.
	}
	

}
