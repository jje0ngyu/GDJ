package quiz04_employee;

public class Temporary extends Employee {
	
	private int pay;
	private int workTimes;
	
	public Temporary() {
	}
	
	public Temporary(int empNo, String name, int pay, int workTime) {
		super (empNo, name);
		this.pay = pay;
		this.workTimes = workTime;
	}

	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getWorkTimes() {
		return workTimes;
	}
	public void setWorkTimes(int workTimes) {
		this.workTimes = workTimes;
	}

	@Override
	public String toString() {
		return super.toString() + ", pay=" + pay + ", workTimes=" + workTimes + "]";
	}

}
