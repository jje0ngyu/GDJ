package ex04_builder;

//* 빌더 패턴은 롬복에서 지원해주므로, 암기보단 패턴의 존재 확인

public class Main {

	public static void main(String[] args) {
		
		User user = User.builder()
				.userNo(1)
				.id("admin")
				.email("admin@naver.com")
				.build(); 	//* 더 이상 적어줄 내용이 없다면, 끝냄을 알리는 build() 메소드 호출
		
		System.out.println(user);
	}

}
