package quiz03_bank;

public class Bank {

	private String accNo;
	private long balance;
	
	public Bank(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}

	// 입금
	public void deposit (long money) throws BankException {
		if ( money < 0) {
			throw new BankException("마이너스 입금 불가", 1);
		}
		balance += money;
	}
	
	// 출금
	public long withdrawal (long money) throws BankException {
		if (money < 0) {
			throw new BankException("마이너스 출금 불가", 2);
		}
		if (money > balance) {
			throw new BankException("잔액 부족", 3);
		}
		balance -= money;
		return money;
	}
	
	// 이체
	public void transfer(Bank other, long money) throws BankException {
		other.deposit(withdrawal(money));	//* withdrawal을 호출했으므로, 여기서 try-catch하거나 다시 throws 해줘야함.
	}
	
	// 계좌정보
	public void inquiry() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", balance=" + balance + "]";
	}

	

}
