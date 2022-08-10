package ex01_field;

public class UserMain {

	public static void main(String[] args) {
		
		// 클래스(데이터타입)		 : User		   //* 기본데이터 8개 이 외엔 모두 클래스 데이터타입
	    // 객체(변수 개념, 인스턴스) : user
									  //* int a = 0;   (* a : 변수)
									  //*
		
		//* 동일한 패키지에 있으면 임포트(import)되지 않는다.
		
		// 객체 선언
		// User user = null;
		
		// 객체 생성		//* new 사용
		// user = new User(); 
	
		// 객체 선언과 생성을 한번에
		User user = new User();  //* 클래스와 메소드 이름은 동일하다. (User)
		
		// 모든 User 객체는 필드값을 가지고 있다.
		// 마침표(.)를 이용해서 필드값을 호출한다.
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		
		
		// 필드값 변경
		user.id = "admin";
		user.password = "123456";
		user.email = "admin@web.com";
		user.point = 1000;
		user.isVip = (user.point >= 10000);
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		
	
	
	}

}
