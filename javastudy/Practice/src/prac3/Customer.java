package prac3;

public class Customer {
	
	// 필드
	private int money;	// 가진 돈
	private int cnt;	// 구매한 빵의 개수

	// 생성자
	public Customer(int money) {
		this.money = money;
	}
	
	// 구매 (구매 후 출력)
	// Bakery에서 판매한 빵을 가질 수 있다. (Bakery의 sell() 메소드 사용)
	public void buy(Bakery bakery, int buyMoney) throws RuntimeException {
		
		
		// 가진 돈 보다 많은 빵은 구매할 수 없다. (예외)
		if (buyMoney > money) {
			throw new RuntimeException("소지 금액 부족");
		}
		
		BreadAndChange bnc = bakery.sell(buyMoney);
		
		// (머니 / 빵가격) = 구매한 빵 개수 > 출력될 cnt
		// 구매하고 남은 돈
		cnt += bnc.getBread();
		money += bnc.getChange();
		
		money -= buyMoney;
		
		System.out.println("구매한 빵 " + cnt + "개, 남은돈 " + money + "원");
		
	}

	
}
