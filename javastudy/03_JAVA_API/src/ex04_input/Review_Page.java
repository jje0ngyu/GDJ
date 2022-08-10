package ex04_input;

import java.util.Scanner;

public class Review_Page {

	public static void main(String[] args) {
		// 220725

		String str1 = "hello";
		String str2 = "hello";
		
		boolean result1 = str1.equals(str2);
		System.out.println(result1);
		
		String str3 = new String ("hi");
		String str4 = new String ("hi");
		
		boolean result2 = str3.equals(str4);
		System.out.println(result2);
		
		boolean result3 = (str1 == str2);
		System.out.println(result3);
		boolean result4 = (str3 == str4);
		System.out.println(result4);
		
		if (str1.equals(str3)) {
			System.out.println("같아요");
		}
		
		System.out.println("7월 26일 수업자료");
	}

}
