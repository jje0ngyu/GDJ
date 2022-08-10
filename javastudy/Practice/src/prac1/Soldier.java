package prac1;
	public class Soldier {
		
		// 필드
		private String name;
		private Gun gun;
		
		
		// 생성자
		public Soldier (String name, Gun gun) {
			super(); //* construct new name
			this.name = name;
			this.gun = gun;	
		}

		// 메소드
		public void shoot() {
			gun.shoot();
		}
		
		// 장전
		public void reload (int bullet) {
			gun.reload(bullet);
		}
		
		// 군인 정보
		public void info() {
							// 이름 : 총기 (남은 총탄)
			System.out.print(name + " : ");
			gun.info();
		}
		
		
	}