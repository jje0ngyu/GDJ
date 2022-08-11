package ex03_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void m1() {
		System.out.println("=== 텍스트를 읽어들이는 리더 ===");
		System.out.println("=== 1글자씩 불러 오기 ===");
		
		File file = new File("C:\\storage","m2.txt");
		FileReader fr = null;
		
		try {
			// FileReader 클래스 생성
			// file 객체에 등록된 파일이 없으면 FileNotFoundException 발생
			fr = new FileReader(file);			
			
			// FileReader 입력 데이터
			// 1. 1글자 : int
			// 2. 여러 글자 : char[]  //* 스트링 배열 안 된다.
			
			// 1글자를 저장할 변수
			int c;
			
			// read() 메소드
			// 1. 읽은 문자를 반환
			// 2. 모두 읽어서 읽은 문자가 없으면 -1 반환
	
			// String str에 파일 내용 저장하기 (String타입으로 전환)
			
			StringBuilder sb = new StringBuilder();
			/*
			while(true) {
				c = fr.read();	//* 1글자 읽기
				if ( c == -1 ) {
					break;
				}
				str += ((char)c); 	//* String의 + 연산은 성능을 낮추는 요인이다. (사용금지) > StringBuilder 활용하여 극복하기.
				sb.append((char)c); //* StringBuilder에 누적시키는 방법.
			}
			String str = sb.toString();
			System.out.println(str);
			*/
			
			while ((c = fr.read()) != 1) {
				sb.append((char)c);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // finally 
	}
	
	public static void m2() {
		System.out.println("=== n글자 수만큼 불러오기 ===");
		
		File file = new File("C:\\storage", "m3.txt");
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			
			// 5글자를 저장할 배열
			char[] cbuf = new char[5];
			
			// read(char[] cbuf) 메소드
			// 1. 읽은 글자는 cbuf 배열에 저장
			// 2. 실제로 읽은 글자 수를 반환    	
			// 3. 읽은 글자가 없으면 -1 반환
			
			// m3.txt 파일 읽는 과정
			//횟수	 readCnt	cbuf
			// 1		5		a  p  p  l  e
			// 2 		5	    \n m  a  n  g
			// 3		2	    o  \n a  n  g   (* 비어있는 공간에는 이전에 읽었던 문자열이 반환)
			// 4       -1
			while(true) {
				
				int readCnt = fr.read(cbuf);
				
				if(readCnt == -1) {	 //* 불러올 값이 없으면 while 멈춤
					break;
				}
				
				for (int i = 0; i < readCnt; i++) { 	// 읽은 글자 수 (readCnt)만큼 반복
					System.out.print(cbuf[i]);			//* 주의 : 마지막 글자 수의 경우! 읽고 저장할 수 있도록 length가 아닌, readCnt 사용)
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { 
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void m3() {
		// m3.txt 읽어서 String str에 저장하기 (char[] 이용)
		File file = new File("C:\\storage", "m3.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			
			char[] cbuf = new char[5];
			StringBuilder sb = new StringBuilder();

			/*  무한루프 이용법 (참고)
			while(true) {
				int readCnt = fr.read(cbuf);
				if (readCnt == -1) {
					break;
				}
				sb.append(cbuf, 0, readCnt);	// cbuf 배열의 인덱스 0부터 readCnt개만큼만 추가
			}
			
			*/

			int readCnt;
			while ((readCnt = fr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			
			String str = sb.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void m4() {
	
		System.out.println("=== 한 줄씩 읽어들이는 readLine() ===");
		// FileReader는 느리기 때문에
		// BufferedReader를 추가해서 속도를 향상시킨다.
		
		// BufferedRreader는 readLine() 메소드를 지원
		// 한 줄씩 읽어서 String에 저장
		// 읽은 내용이 없으면 null 반환
		
		File file = new File("C:\\storage", "m3.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			String str = sb.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void m5() {
		System.out.println("=== tra-catch-resources 문 : finally 사용 X, .close() 사용X ===");
		
		// try - catch - resources 문으로 m4() 다시 풀기
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\storage\\m3.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			String str = sb.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		m5();		
	}

}
