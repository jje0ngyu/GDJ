package quiz02;

public class CoffeeMain {

	public static void main(String[] args) {
		Espresso espresso = new Espresso("케냐", 50);
		espresso.info();	// 케냐 원두, 물 50ml
		
		Americano americano = new Americano(espresso, 300, "아이스");
		americano.info();	// 케냐 원두, 물 300ml, 아이스 아메리카노
		

	}

}
