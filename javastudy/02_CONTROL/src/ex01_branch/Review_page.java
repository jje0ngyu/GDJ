package ex01_branch;


public class Review_page {

	public static void main(String[] args) {

		int n = 1;
		
		switch (n % 2) {
		case 0: System.out.println("짝수"); break;
		default: System.out.println("홀수");
		}
		
		// 연습3 (♣)
		// 분기 출력하기
		// 1 ~ 3월 : 1분기
		// 4 ~ 6월 : 2분기
		// 7 ~ 9월 : 3분기
		// 10~12월 : 4분기
		int month = 9;
		
		switch ((month - 1) / 3) {
		case 0: System.out.println("1분기"); break;
		case 1: System.out.println("2분기"); break;
		case 2: System.out.println("3분기"); break;
		case 3: System.out.println("4분기"); break;
		}
		
		int score = 90;
		String grade;
		
		switch (score / 10) {
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default : grade = "F";
		}
		
		System.out.println(score + "점은 " + grade + "학점입니다.");
		
		// 연습5 (♣)
		// 등급 (1,2,3)에 따른 권한 출력
		// 1등급 : 쓰기 실행 읽기
		// 2등급 : 실행 읽기
		// 3등급 : 읽기
		// 나머지 : 없음
		int level = 1;
		String right = ""; //권한
		
		switch (level) {
		case 1: right += "쓰기";
		case 2: right += "실행";
		case 3: right += "읽기"; break;
		default : right += "없음";
		}
		System.out.println(right);
		
	}
}