package quiz03_random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {	
	
	public static void main(String[] args) {
		
	// 정수를 몇 개 저장할지 (최대 100개) 입력받아서 해당 길이를 가진 배열을 생성하고
	// 이곳에 1에서 100사이 범위의 정수를 랜덤하게 삽입하시오.
	// 같은 값은 생성하지 못하도록 설정하고 생성된 배열을 출력시오.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 개의 랜덤을 생성할까요? >>> ");
		int cnt = sc.nextInt();
		sc.nextLine();
		
		
		if (cnt < 1 || cnt > 100) {
			System.out.println("다음에는 1~100 사이로 입력하세요.");
			return;
		}
		
		int[] arr = new int[cnt];
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < cnt) {
			set.add((int)(Math.random() * 100 + 1));
		}
		
		int idx = 0;
		for (Integer n : set) {
			arr[idx++] = n;
		}
		
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr[i] + "  ");
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		
	}
}
