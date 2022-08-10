package quiz03_bank;

public class Main {

	public static void main(String[] args) { // throws BankException { //* 아무도 try-catch를 안 할 수도 있다.
		//* 계속 돌릴 수도 있지만, 되도록 try-catch 넣어서 작동하도록 한다.
		
		Bank me = new Bank("1111", 10_000);
		Bank mom = new Bank("2222", 100_000);
		
		try {
			me.deposit(-100);
			mom.transfer(me, 0);
		} catch (BankException e) {
			System.out.println(e.getMessage() + "," + e.getErrorCode());
		}
		
		me.inquiry();
		mom.inquiry();
	}
}
