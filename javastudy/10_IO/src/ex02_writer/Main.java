package ex02_writer;


import java.io.BufferedWriter;
// ctrl + shift + o  : 자동 임포트 (필요한 것 : 추가 / 안 쓰는 것 : 삭제)
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	public static void m1() {
		
		System.out.println("=== 파일 생성 ===");
		
		FileWriter fw = null;	//* 여기서 문제 발생 가능성 있다.
		File dir = new File("C:\\storage");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "m1.txt");
		
		System.out.println("=== 출력 스트림 (내용물) 생성을 진행 ===");
		
		try {
			// C:\\storage\\m1.txt 파일과 연결되는 문자 출력 스트림
			// 출력 스트림이 생성되면 파일도 새로 생성됨
			fw = new FileWriter(file);	// new FileWriter("C:\\storage\\m1.txt")와 같다.
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw!=null) {	//* finally 구문이기 때문에, fw = null 로 넘어오기도 하기 때문에, if 사용 필수
					fw.close();	//* fw.close 도 try-catch 사용
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	
	}
	
	public static void m2() {
		File file = new File("C:\\storage", "m2.txt");
		
		FileWriter fw = null;
		try {
			
			// 출력 스트림 생성 (파일도 함께 생성)
			fw = new FileWriter(file);
			
			// 출력할 데이터
			// 1. 1글자 : int (★)
			// 2. 여러 글자 : char[], String
			int c = 'I';
			char[] cbuf = {' ', 'a', 'm'};
			String str = " IronMan";
			
			// 출력 스트림으로 보내기(출력)
			fw.write(c);
			fw.write(cbuf);
			fw.write(str);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void m3() {
		
		// try - catch - resources 문
		// 1. resources는 자원을 의미
		// 2. 여기서 자원은 스트림(stream)을 의미
		// 3. 스트림의 종료(close)를 자동으로 처리하는 try-catch 문을 의미
		// 4. 형식
		//		try (스트림 생성) {
		//			코드
		//		} catch (Exception e) {
		//			e.prinsStackTrace();
		//		}
		
		File file = new File ("C:\\storage", "m3.txt");
		try (FileWriter fw = new FileWriter(file)) {
			
			fw.write("나는 닥터 스트레인지이다.");
			fw.write("\n");	// 줄 바꿈
			fw.write("너는 도르마무냐? \n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void m4() { //(★★★ 사용법 반드시 숙지)
		File file = new File ("C:\\storage", "m4.txt");
		
		try (FileWriter fw = new FileWriter(file)) {
			
			char[] cbuf = {'a', 'b', 'c', 'd', 'e'};
			String str = "가나다라마";
			
			fw.write(cbuf, 0, 2);	//cbuf 의 인덱스 0 부터, 2글자 사용  // a b
			fw.write(str, 2, 3);	//str 의 인덱스 2부터, 3글자 사용	 // 다라마
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void m5() {
		// FileWriter는 느리기 때문에
		// 빠른 속도가 필요한 경우 BufferedWriter를 추가해서 함께 사용한다.
		
		File file = new File("C:\\storage", "m5.txt");
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			//출력 메인 스트림
			fw = new FileWriter(file);
			// 속도 향상을 위한 보조 스트림
			// 메인 스트림이 없으면 사용 불가  (* 메인에 추가를 해주는 개념) 
			bw = new BufferedWriter(fw);
			bw.write("오늘은 수요일인데 수업이 안 끝나요.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 메인 스트림은 닫을 필요가 없다. (보조 스트림을 닫으면 메인 스트림이 자동으로 닫힌다.)
				if( bw != null) {
				bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void m6() {
		System.out.println("=== 줄 바꿈을 위해 사용되는 PrintWriter 클래스 ===");
		
		// PrintWriter 클래스는 write() 메소드 외
		// print(), println() 메소드를 지원한다.	//* println을 쓰기 위해 PringWriter를 자주 사용한다.
		
		File file = new File ("C:\\storage", "m6.txt");
		
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(file);
			
			// write() 메소드는 줄 바꿈을 "\n"으로 처리한다.
			out.write("안녕하세요\n");
			
			// println() 메소드는 자동으로 줄 바꿈이 삽입된다.
			out.println("반갑습니다.");
			out.println("처음 뵙겠습니다."); //* 줄 바꿈 확인용
			
		} catch (IOException e) {
			e.printStackTrace();			
		} finally {
			try {
				if (out != null) out.close();
			} catch  (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		m6();

	}

}


























