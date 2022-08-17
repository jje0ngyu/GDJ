package ex04_join;

public class Main {

	public static void main(String[] args) {
		
		// Calculator를 2개 준비
		// 작업을 반으로 나눠서 진행
		
		// Calculator가 동시에 연산을 수행하려면 Calculator를 스레드로 처리해야 함
		Calculator calc1 = new Calculator(1, 5000);
		Thread thread1 = new Thread(calc1);
		// 1번째 계산기 동작 시작
		thread1.start();  //* 스레드 (동시 수행을 위해) 사용하려면 메소드 start() 사용
		
		Calculator calc2 = new Calculator(5001, 10000);
		Thread thread2 = new Thread(calc2);
		// 2번째 계산기 동작 시작
		thread2.start();
			
		try {
			// 모든 계산기의 동작이 끝나면 함께 수행
			// join() :  스레드가 종료(die)될 때까지 기다린다.
			thread1.join();
			thread2.join();
			
		} catch (InterruptedException e) { //* join() 의 예외
			e.printStackTrace();
		}
		System.out.println(thread1.isAlive());  //* 계산 중이면 true, 계산이 끝났으면 false
		System.out.println(thread2.isAlive());  //* join() 를 사용하여, false 반환
		
		System.out.println(calc1.getTotal() + calc2.getTotal());
			
	}
}
