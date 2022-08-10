package quiz05_exam;

public class Exam {


	
	private String examName;
	private int kor;
	private int eng;
	private int mat;
	
	public Exam(String examname) {
		this.examName = examname;
		
	}

	
	public void setScore() {
		this.kor = (int)(Math.random() * 101);
		this.eng = (int)(Math.random() * 101);
		this.mat = (int)(Math.random() * 101);
	}
	
	public void examInfo() {
		int total = kor + eng + mat;
		System.out.println(examName + " 성적");
		System.out.println("국어 : " + kor + " 영어 : " + eng  + " 수학 : " + mat);
		System.out.println("총점 : "  + total + ", 평균 :" + (total / 3.0));
	}
	

	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}


	
	
	
	
}
