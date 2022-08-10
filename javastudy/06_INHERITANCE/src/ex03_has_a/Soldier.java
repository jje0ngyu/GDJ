package ex03_has_a;

public class Soldier {

	// 필드
	private Gun gun;
	
	
	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	
	
	// 메소드
	public void reload (int bullet) {
		gun.reload(bullet);
	}
	public void shoot() {
		gun.shoot();  //* 군인이 가지고 있는 총 쏘기
	}
	
}
