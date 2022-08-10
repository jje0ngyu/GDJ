package exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {
	
	public static void main(String[] args) {
		ArrayList();
		Array_asList();
		set();
		hashmap();
		library();
		rsp();		// 가위바위보 게임
		random();
	}
	
	public static void ArrayList() {
		System.out.println("=== 어레이리스트 메소드입니다. ===");
		
		List<String> list = new ArrayList<String>(); //* 주의: List 인터페이스 임포트, ArrayList 임포트
		list.add("cat");
		list.add("dog");
		list.add("rabbit");	//* 리스트는 꼭 .add 해서 값을 입력해주기
		list.add(0, "snake"); //* 원하는 위치에 값 추가하기
		
		
		list.remove("rabbit");
		System.out.println(list);	// snake cat dog
//		boolean result = list.remove("rabbit");		//* true, false값 반환
//		System.out.println(result);						//* 지운 값 반환
		
		list.set(0, "piano"); 	// 삭제된 값을 제외하여 번호를 붙임. 
		System.out.println(list);	// piano, cat, dog

		boolean result = list.isEmpty();
		System.out.println("list에 값이 없다. >>> " + result);
		
		if (list.contains("rabbit")) {
			System.out.println("there is rabbit");
		} else {
			System.out.println("there is not rabbit");
		}
		
		List<Integer> num = new ArrayList<Integer>();
		num.add(4);
		if (num.contains(4)) {
			System.out.println("there is 4");
		} else {
			System.out.println("there is no 4");
		}
		
	}
	public static void Array_asList() {
		System.out.println("=== 어레이_에즈리스트 메소드입니다. ===");
		
		List<String> list = Arrays.asList("sun", "mon", "tus", "wed");
		int size = list.size();	// list의 길이는 size().
		System.out.println(size); 	//4
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));

		System.out.println("=== 순회입니다. === 메소드를 1번만 호출하세요.");
		for (int i = 0, length = list.size(); i < length; i++) {
			System.out.println(list.get(i));
		}
		System.out.println("=== 향상 for문 입니다. === 사용 방법은 기존과 동일합니다.");
		for (String element : list) {
			System.out.println(element);
		}
	}
	
	public static void set() {
		
	}
	
	public static void hashmap() {
		
	}
	
	public static void library() {
		
	}
	
	public static void rsp() {
		
	}
	
	public static void random() {
		
	}

}
