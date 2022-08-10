package quiz04_employee;

public class Employee {
	
	private int empNo; 		// 사번
	private String name; 	// 이름
	private Regular[] regular;
	private int regIdx;
	private int temIdx;
	private int totalSalary;
	
	public Employee() {
	}
	
	public Employee(int empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getRegIdx() {
		return regIdx;
	}
	public void setRegIdx(int regIdx) {
		this.regIdx = regIdx;
	}

	public int getTemIdx() {
		return temIdx;
	}
	public void setTemIdx(int temIdx) {
		this.temIdx = temIdx;
	}

	public void wage() {
		
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name;
	}
	
	

	
	
}
