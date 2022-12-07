package ex02_lambda.sec01;

/*
	람다식
	
	1. 익명 구현 객체를 생성하기 위한 표현식
	2. 이름이 없는 익명 함수를 사용
	3. 실행(런타임)할 때 익명 구현 객체가 만들어지면서 동작
	4. 형식
		(매개변수) -> { 메소드 본문 }
	5. 예시
		1) (int a) -> { System.out.println(a); }
		2) (a) -> { System.out.println(a); } 	매개변수의 타입은 작성하지 않는다.
		3) a -> System.out.println(a);			매개변수가 하나이거나, 메소드본문이 하나이면 중괄호를 작성하지 않는다.
		4) () -> System.out.println("Hello");	매개변수가 없으면 빈 괄호를 작성한다.
		5) (a, b) -> {
				int result = a + b ;
				return result;					반환타입의 명시를 하지 않는다.
			}
		6) (a, b) -> a + b;
		
	
*/

public class Main {


	public static void main(String[] args) {
		// run() 메소드만 람다식으로 바꾸면, Runnable 익명 구현 객체는 실행할 때 만들어진다.
		Thread thread = new Thread(() -> System.out.println("Hello Wortld"));
		thread.start();
	}

}

// 람다는 언제 사용?
// 람다는 인터페이스 1개에 (추상)메소드 1개만 있을 때 사용 가능하다.
// Functional Interface는 (추상)메소드 1개만 있다.
// 이 Functional Interface를 보면 람다를 사용하겠다고 생각하면 된다.
// Functional Interface는 4개가 있다.
// consumer, runnable... 
// 이 4개의 Functional Interface를 알아야 Stream으로 사용 가능하다.