package ex02_thread;

public class Gun {
	
	private int bullet;
	
	public Gun(int bullet) {
		super();
		this.bullet = bullet;
	}
	
	public int getBullet() {  /* Soldier의 총알 확인을 위해 getter, setter 생성 */
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

	public void shoot() {
		if (bullet == 0) {	/* 총알이 없을 경우 */
			System.out.println("총알 없음");
			return;
		}
		bullet--;
		System.out.println("빵야! " + bullet + "발 남음");
	}
}
