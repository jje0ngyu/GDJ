package prac1;

public class Gun {

	public static String getBullet;
	// 필드
	private String model;
	private int bullet;
	private final int MAX_BULLET = 6;
	
	
	//* 총기 정보 입력
	// 생성자
	public Gun(String model, int bullet) {
		this.model = model;
		this.bullet = bullet;
	}


	// 메소드
	// 총알 발사
	public void shoot() {
		
		if (bullet > 0) {   //* 총이 한 발 이상 있을 경우
			bullet --;
			System.out.println("빵야! " + this.bullet + "발 남았다.");
		} else {
			bullet = 0;		//* 총이 한 발도 없을 경우
			System.out.println("헛빵!");
			return;
		}
	}
	
	
	// 장전
	public void reload(int bullet) {
		this.bullet += bullet;
		if (this.bullet > MAX_BULLET)
			this.bullet = MAX_BULLET;
		System.out.println(bullet + "발이 장전되었다. 현재 " + this.bullet + "발.");
	}
	
	public void info() {
		System.out.println(model + "(" + bullet + ")");
	}
	
}
