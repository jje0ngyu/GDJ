package ex01_one_dim;

import java.util.Arrays;

public class Ex03_array {

	public static void main(String[] args) {
		
		// 배열의 데이터타입
		// int[] : 참조 타입 (Reference Type)
		
		/*
		int[] arr = { 10000, 20000, 30000 };
		
		       |-------|
		arr    | 0x123 |         (* arr[]는 모두 0x123)
		       |-------|
		       |  ...  |
		       |-------|
		arr[0] | 10000 | 0x123   (* 3개의 변수값이 연속된 메모리 공간을 사용)
		       |-------|
		arr[1] | 20000 |         (* 인덱스 1은 참조값 0x123에서 1칸 떨어져있음을 의미)		 
		       |-------|
		arr[2] | 30000 |         (* 인덱스 2는 참조값 0x123에서 2칸 떨어져있음을 의미)
		       |-------|
		*/

		// 배열의 길이 늘리기
		// 1. 배열의 길이는 변경할 수 없다.
		// 2. 늘어난 길이의 새로운 배열을 만들고,
		//	  기존 배열의 값을 모두 새로운 배열로 옮기고,
		// 	  기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		
		
		// 길이가 5인 배열을 사용하다가
		// 길이가 1000인 배열로 바꾸기
		int[] arr = { 1, 2, 3, 4, 5 };
		
		int[] temp = new int[1000]; // (1) 늘어난 길이의 새로운 배열 만들기
		
		System.arraycopy(arr, 0, temp, 0, arr.length); // (2) 기존 배열의 값을 모두 새로운 배열로 옮기기
													   //* arr의 0번 값을 temp 0번 값으로 arr.length번 옮겨라
		arr = temp;  // (3) 기존 배열의 참조값을 새로운 배열의 참조값으로 수정하기
					 //* 이름은 계속 arr을 사용 (이름 유지)
		System.out.println(arr.length);   // 1000
		System.out.println(Arrays.toString(arr));   // [1, 2, 3, 4, 5, 0, 0, ... 0, 0]
		
		
		
	}

}
