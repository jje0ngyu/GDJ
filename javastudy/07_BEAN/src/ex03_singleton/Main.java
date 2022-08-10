package ex03_singleton;

public class Main {

	public static void main(String[] args) {

		// singleton 객체는 하나만 생성된다.
		//* 여러 개의 객체가 생성되면 안 될 때 사용한다. (즉, new User 를 차단)
		
		User user1 = User.getInstance();
		System.out.println(user1);
		
		User user2 = User.getInstance();
		System.out.println(user2);
		
		// User user = new User(); 		외부에서는 새로운 객체를 생성할 수 없다.
	}

}
