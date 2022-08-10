package ex14_interface;

public interface Shape {
	
	// private String type;   *내부적으로 static 을 가지고 있다.
	// final 상수
	public final static double PI = 3.141592;	//* static 생략 가능
	
	// 추상 메소드
	public abstract double getArea(); //* abstract 생략 가능
	
	// default 메소드 (본문이 있는 메소드) 1.8버전 이상에서만 가능
	public default void message() {
		System.out.println("나는 도형이다.");
	}
	
	

}
