package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void m1() { //* try-catch, Exception 클래스 확인
		try {
			String[] hobbies = new String[3];
			hobbies[1] = "Swimming";
			hobbies[2] = "running";
			for (String hobby : hobbies) {
				System.out.println(hobby.substring(0, 2));
			}
		} catch(Exception e) {	// RuntimeException, NullPointerException 가능
			System.out.println("NullPointerException 발생");
		}
	}
	
	
	public static void m2() {	// catch블록은 여러 개를 달 수 있으며, 상속 관계에 주의한다.
		try {
			String input = "20,21,, 22,23,24,25";
			
			String[] inputArr = input.split(",");
			
			int[] ages = new int[inputArr.length];
			for (int i = 0; i < inputArr.length; i++) {
				ages[i] = Integer.parseInt(inputArr[i]);
				System.out.println("변환 값 : " + ages[i]);
			}
		} catch(NumberFormatException e) {		//RuntimeException, Exception 가능
			System.out.println("NullPointerException 발생");
			
		} catch(Exception e) {
			System.out.println("Exception 발생");
		}
		
//		int[] ages = {20, 21, 22, 23, 24, 25};
		
	}
	
	
	public static void m3() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("정수1 >>> ");
			int a = sc.nextInt();
			System.out.println("정수2 >>> ");
			int b = sc.nextInt();
			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));
			System.out.println(a + "%" + b + "=" + (a % b));
			sc.close();
		} catch (ArithmeticException e){
			System.out.println("ArithmeticException 발생");
		} catch (InputMismatchException e){
			System.out.println("InputMismatchException 발생");
		} 
	}
	
	
	public static void m4() {
		try {
			File file = new File("C:\\sample.txt");
			FileReader fr = new FileReader(file);	// try-catch 문이 없으면 실행이 불가능한 CheckedException.
		} catch (Exception e) {
			// 예외1 : 파일이 없을 경우 (FileException)
			// 예외2 : 파일은 있지만 읽히지 않을 경우 (IOException)
		}
	}
	
	
	public static void main(String[] args) {
		m1();

	}

}
