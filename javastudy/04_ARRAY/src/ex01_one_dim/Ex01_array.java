package ex01_one_dim;

public class Ex01_array {

	public static void main(String[] args) {
		
		// 배열(Array)
		// 1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
		// 2. 구성 요소
		//	   1) 인덱스 : 각 변수의 위치 정보. 0으로 시작
		//	   2) 배열명 : 모든 변수를 관리하는 하나의 이름
		// 3. 각 변수는 배열명에 대괄호[]와 인덱스를 붙여서 구분
		
		// (★) 배열 선언 및 생성
		// 1. 배열 선언
		//    int[] arr;   (* 추천)("int[]" : 인트 배열 타입)
		//	  int arr[];   (* C언어 호환)
		// 2. 배열 생성
		//	  arr = new int[3];    (* [] 안에 관리할 변수의 갯수 입력)
		// 3. 배열 선언 및 생성
		//	  int[] arr = new int[3];    (* 배열의 선언과 생성을 1줄로 작성)

		// (★) 배열 요소
		// 1. 배열로 관리되는 각각의 변수
		// 2. 모든 배열 요소의 호출
		// 	  arr[0]    (* 첫 번째 배열 요소 호출: 첫 번째 배열의 이름)
		//	  arr[1]    (* 두 번째 배열 변수)
		//    arr[2]    (* 세 번째 배열 변수)
		// 3. 배열 요소는 자동으로 초기화된다. (어떤 값을 가진다.)
		//	  값이 없음을 의미하는 0, 0.0, false, null 값을 가진다.    (* boolean의 값이 없음은 false이다.) (* string의 값이 없음은 null이다.)
		
		// 배열의 장점
		// ** 변수 3개가 있는 상황
		// 일반 변수				배열
		// int a, b, c;				int[] arr = new int[3];
		// System.out.println(a);	for(int i = 0; i < 3; i++) {
		// System.out.println(b);		System.out.printn(arr[i]);
		// System.out.println(c);	}
		//
		
		int[] arr = new int[5];    //* 숫자 3은 arr의 'length'이다. 여기에 종속된 값은 arr.length로 작성한다.
		
		for(int i = 0; i < arr.length; i++) {    //* arr를 사용할 때 변수는 i, j, k 순으로 사용한다.
			System.out.println(arr[i]);
		} 
		
		arr[0] = 100;
		arr[1] = 50;
		arr[2] = 80;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int total = 0;    //* 더하기를 수용할 토탈 변수 생성
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		double average = (double) total / arr.length;    //* total에 캐스팅double을 해준다.
		//* 캐스팅하는 이유: 캐스팅 전에는 total과 3 둘 다 int이기 때문에, int값이 나온다.
		
		System.out.println("평균 : " + average + "점");
		
		
		
		
		
		
	}

}
