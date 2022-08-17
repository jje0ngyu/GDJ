package ex03_runnable;

public class Main {

	public static void main(String[] args) {
		
		// Runnable 인터페이스를 구현한 클래스는 Thread로 바꿔야 start() 메소드를 호출할 수 있다.
		//* 사유 : Runnable 인터페이스에는 run() 메소드밖에 없다.
		
//		Robot robot = new WashRobot("로봇");
//		Thread thread = new Thread(robot);     * 참고) 상속 문제로 실행되지 않는다.
//해결1:Thread thread = new Thread((Runnable)robot); 		
		
		Runnable robot1 = new WashRobot("제피R");
		WashRobot robot2 = new WashRobot("제피L");

		Thread thread1 = new Thread(robot1);
		Thread thread2 = new Thread(robot2);


		thread1.start();
		thread2.start();
	}

}
