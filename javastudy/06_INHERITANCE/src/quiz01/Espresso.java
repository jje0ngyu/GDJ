package quiz01;

public class Espresso extends Coffee {

	private int water;
	
	// 생성자
	public Espresso(String origin, int water) {
		super(origin);
		this.water = water;
	}

	@Override
	public void info() {
		super.info();
		System.out.println("물" + water + "ml");
	}
}
