package quiz04_employee;

public class Regular extends Employee {	//* 여기에 toString 하지 않으면 월급이 출력되지 않음.

	private int salary;
	private int totalSalary;
	private Employee employee;
	
	public Regular() {
	}
	
	public Regular(int empNo, String name, int salary) {
		super(empNo, name);
		this.salary = salary;
		employee.setRegIdx(1);
	}
	
	public int getSalary() {
		return salary;
	}
	
	@Override
	public void wage() {
		super.wage();
		for (int i = 0; i < employee.getRegIdx(); i++) {

		}
	}

	
	
//	@Override
//	public String toString() {
//		return "Regular [salary=" + salary + "]";
//	}


	
	@Override
	public String toString() {
		return super.toString() + " ,salary=" + salary + "]";	//* 부모의 toString을 호출하고 이어서 작성
	}
	
	
	
}
