package ex01_one_dim;

public class Ex02_array {

	public static void main(String[] args) {
		
		// 배열의 초기화
		//int[] arr = new int[]{ {10, 20, 30, 40, 50};    //* 초기화에서는 length값을 지정하지 않는다. 중괄호{}를 추가한다.
		int[] arr = {10, 20, 30, 40, 50};				  //* 따라서 new int[]는 작성하지 않아도 되는 값이다.
		
		
		// 최대/최대
		int max = arr[0];		//* 초기 알고리즘의 최댓값은 가장 작은 값으로 시작하고, 최솟값은 가장 큰 값으로 시작한다.
		int min = arr[0];		//*	혹은 arr[0]를 준다. 이 경우, for문의 i는 1로 시작한다. (i = 0일 경우, arr[0]과 arr[0]을 비교하며 시작하기 때문)
		
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {    //* 최댓값 먼저 계산하는 식
			    max = arr[i];	   //* 순서대로 비교하며, 큰 값이 최댓값이 되는 식
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);
		
	}

}
