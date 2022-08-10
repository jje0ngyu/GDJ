package ex12_object_calss;

public class Person {

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("먹는다.");
	}
	
	@Override
	public String toString() {
		return "이름 : " + name;	// System.out.println(person); 에서 사용됨
	}
	
	@Override
	public boolean equals(Object anObject) {  // p1.equals(p2) 에서 사용됨
		Person p = (Person) anObject;	// Person 클래스로 바꿔주고
		return name.equals(p.name);		// 비교한다.
		
	//* Object는 모든 걸 저장할 수 있다.
	//* Object에 저장된 객체는 캐스팅해서 사용한다.
	//* 객체 정보 확인을 위해서는 toString() 메소드를 만든다.
	//* 객체 정보 비교를 위해서는 equals() 메소드를 만든다.
	//* source 메뉴에 가면 toString(), equals() 를 만들어 준다.
	}
}
