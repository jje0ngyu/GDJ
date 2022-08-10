package quiz02;

public class Americano {

	private Espresso espresso;
	private int shot;
	private String type;
	
	
	// 생성자

	public Americano(Espresso espresso, int shot,String type) {
		super();
		this.espresso = espresso;
		this.shot = shot;
		this.type = type;
	}
	
	
	public void info() {
		espresso.info();
		System.out.println(shot + "샷");
		System.out.println(type + " 아메리카노");

	}
	
}
