package ex16_interface;

// extends Pet : 애완동물이다.
// implements Walkable : 산책이 된다.

public class Dog extends Pet implements Walkable {

	//* 생성자만 생성 (generate superclass)
	public Dog(String petName) {
		super(petName);
	}
	
	

}
