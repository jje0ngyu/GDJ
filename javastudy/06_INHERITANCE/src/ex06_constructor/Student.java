package ex06_constructor;

public class Student extends Person {

	private String school;
	
	//* Source탭에서 'Generate Constructor using Fields...' 선택하면 아래 코드가 자동 입력됨.
	//* 상속 관계를 먼저 입력해줄 것
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
