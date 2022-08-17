package ex01_thread;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		Process process1 = new Process("연산");
//		process.run();	//* ★ thread는 start() 메소드를 사용하므로써, run() 메소드를 실행한다.
		process1.start(); // Process 클래스의 오버라이드된 run() 메소드가 호출
		
		Process process2 = new Process("제어");
		process2.start();
		
		System.out.println("main 종료");
			
	}

}
