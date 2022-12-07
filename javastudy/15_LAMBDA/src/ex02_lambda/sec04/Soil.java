package ex02_lambda.sec04;

public class Soil {

	private int totalOil = 1000;
	private int payPerLiter = 2000;
	private int earning;
	
	// 3. 메소드의 매개변수로 익명 객체 저장하기
	public void sellOil(Car car) {
		car.addOil();
	}
	
	public int getTotalOil() {
		return totalOil;
	}

	public void setTotalOil(int totalOil) {
		this.totalOil = totalOil;
	}

	public int getPayPerLiter() {
		return payPerLiter;
	}

	public void setPayPerLiter(int payPerLiter) {
		this.payPerLiter = payPerLiter;
	}

	public int getEarning() {
		return earning;
	}

	public void setEarning(int earning) {
		this.earning = earning;
	}

	
	// 1, 익명 객체를 필드에 저장하기
	private Car car = new Car() {
		@Override
		public void addOil() {
			int oil = 10;
			totalOil -= oil;
			earning += oil + payPerLiter;
			System.out.println("감사합니다 모닝");
		}
	};
	
	
	
}
