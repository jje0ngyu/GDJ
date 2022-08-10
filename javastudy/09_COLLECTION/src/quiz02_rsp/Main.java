package quiz02_rsp;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		String[] rsp = {"가위", "바위", "보"};
		
		// rsp 배열에서 임의의 값을 선택하여 HashSet에 저장한다.
		// rsp[0] == "가위"
		// rsp[1] == "바위"
		// rsp[2] == "보"
		
		// 몇 번만에 HashSet에 모두 넣을 수 있는지 확인한다.

		
		//* 몇 번 반복되는지 모르기 때문에 for문 보단 while을 사용
		Set<String> set = new HashSet<String>();
		int cnt = 0;
		
		while(set.size() < 3) { 	//* Set에 저장된 것이 ~가 아니면 저장.
			int i = (int)(Math.random() * 3); // 0, 1, 2 중 하나
			set.add(rsp[i]); //* 세트의 특성에 따라, 중복된 값을 적용 안 됨.
			cnt++;
		}
		System.out.println(set);
		System.out.println(cnt);
	}
}
