package ex07_override;

public class Espresso extends Coffee {
	
	@Override 				//* 오버라이드 했다는 것을 자바에게 알려줌으로써 오타를 방지할 수 있다.
	public void taste() {	//* 오버라이드를 하지 않았다면, 'tate'로 오타가 발생해도, 문제없이 생성자를 생성할 수 있다.
		System.out.println("쓰다");
	}
	
	public void addWater() {
		System.out.println("Americano");
	}
}
