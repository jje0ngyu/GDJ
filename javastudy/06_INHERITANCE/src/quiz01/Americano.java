package quiz01;

public class Americano extends Espresso{

	private String type;
	
	// 생성자
	public Americano(String origin, int water, String type) {
		super(origin, water);
		this.type = type;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println(type + " 아메리카노");
	}
	
}
