package ex03_singleton;

public class User {

	// static 필드
	// 객체 생성 이전에 메모리에 미리 만들어 두는 필드
	//* 미리 유저를 하나 만들어 둬라! 여기서!
	//* 필요하면 User getInstance() {} 를 사용해서 사용할 수 있다.
	//* 외부에서는 사용할 수 없다.
	//* DB 접는하는 것은 한 놈만 가능하다.
	
	private static User user = new User();
	
	private User() {	// User 객체 생성은 User 내부에서만 가능하다.
		
	}
	
	// static 메소드 (클래스 메소드)
	// 클래스가 생성될 때 함께 생성되는 메소드
	// 객체 생성 이전에 만들어지기 때문에 객체로 접근하지 않는다.
	// 클래스 이름으로 접근한다.
	// User user = User getInsance();  * 다른 방법으로 호출 불가 (≒ Calendar)
	
	public static User getInstance() {	
		return user;
	}
}
