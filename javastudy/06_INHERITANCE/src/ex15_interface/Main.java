package ex15_interface;

public class Main {

	public static void main(String[] args) {

		// 메소드 호출 연습
		Phone p1 = new SmartPhon();
		p1.call();
		p1.sms();
		((Computer) p1).game();
		((Computer) p1).internet();
	
		
			
		Computer p2 = new SmartPhon();
		((Phone) p2).call();
		((Phone) p2).sms();
		p2.game();
		p2.internet();
		
		
		SmartPhon p3 = new SmartPhon();
		p3.call();
		p3.sms();
		p3.game();
		p3.internet();
	}

}
