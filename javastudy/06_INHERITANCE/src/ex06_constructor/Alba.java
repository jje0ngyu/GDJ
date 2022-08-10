package ex06_constructor;

public class Alba extends Student {

	private String company;
	
	public Alba(String name, String school, String company) {
		super(name, school);	//* super 와 this.company 의 위치를 바꾸면 오류. 보통 Generate Constructor...를 사용 
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
