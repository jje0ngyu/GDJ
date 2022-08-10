package ex01_field;

public class User {
	
	// User를 구성하는 속성(Attribute)이 필드(Field)이다.
	// 필드는 일반 변수와 달리 자동으로 초기화된다.
	//* 모든 User는 아래 5개의 필드(Field)값을 가진다.
	
						// (초기값)
	String id;			// null
	String password;	// null
	String email;		// null
	int point;			// 0
	boolean isVip;    	// false  //* VIP회원 여부
}
