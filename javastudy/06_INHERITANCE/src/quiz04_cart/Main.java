package quiz04_cart;

public class Main {

	public static void main(String[] args) {

		// quiz04_cart : Product, Snack, Meat, Milk, Customer
		//	- Snack, Meat, Milk는 모두 Product이다.
		// 	- 모든 Product는 이름(name)과 가격(price)만 가진다.
		//	- 고객(Customer)은 모든 Product를 10개 담을 수 있는 cart를 가진다.
		//	- 고객은 돈(money)과 보너스포인트(bonusPoint, 구매액의 10%)를 가진다.
		
		Customer customer = new Customer();	// 아직 돈이 없는 고객
		customer.setMoney(10000);			// 10000원이 생긴 고객
		
	
		customer.buy(new Snack("홈런볼", 1500));	// 1500원짜리 홈런볼을 산다. (카트에 담는다.)
		customer.buy(new Meat("한우", 5000));		// 5000원짜리 한우를 산다. (카트에 담는다.)
		customer.buy(new Milk("서울우유", 2500));	// 2500원짜리 서울우유를 산다. (카트에 담는다.)
		customer.buy(new Meat("불고기", 5000));		// 구매불가
		customer.buy(new Meat("소고기", 5000));		// 구매불가
		
		customer.receipt();							// 영수증을 본다.
		
		/*
		  홈런볼	1500원
		  한우  	5000원
		  서울우유  2500원
		  ----------------
		  구매총액 	9000원
		  보너스 	 900원
		  남은돈	1000원
		 */
		
	}

}
