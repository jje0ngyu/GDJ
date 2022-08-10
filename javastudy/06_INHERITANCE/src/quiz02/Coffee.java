package quiz02;

public class Coffee {
	
	private String origin;
	

	public Coffee(String origin) {
		super();
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	
	public void info() {
		System.out.println(origin + "원두");
	}
	
}
