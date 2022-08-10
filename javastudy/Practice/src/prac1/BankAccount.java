package prac1;

public class BankAccount {
	
	// 필드
	private String accNo;
	private long balance;
	
	
	// 생성자
	public BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	
	//* 입금하기
	public void deposit(long money) {  //* 입금액 계좌에 넣기
		if (money >= 0 ) {
			balance += money;
		} else {					 //* 마이너스 입금 불가
			System.out.println("불가");
		}		
		return;
	}
	
	//* 출금하기
	public long withdraw (long money) {
		if (money <= balance) {
			balance -= money;
			System.out.println(balance);
			return money;
		} else {
			System.out.println("잔액보다 큰 금액 출금 (불가)");
			return 0;
		}
		
	}
	
	//* 계좌 정보 출력
	public void inquiry() {
		System.out.println("계좌번호: " + this.accNo + ", 잔액 " + balance + "원");
	}
	
	//* 계좌 이체
	public void transfer (BankAccount other, long money) {
		if (money <= balance) {
			long withdrawalMoney = withdraw(money);
			other.deposit(withdrawalMoney);
		} else {
			System.out.println("실패");
		}
		
	}

		
}
