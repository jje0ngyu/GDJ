package ex07_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {

	public static void printMovies(List<String> list) {

		// 일반 for문
		for (int i = 0, size = list.size(); i < size; i++) {
			System.out.print(list.get(i));
			if (i < size - 1) { // size - 1 : 마지막 요소의 인덱스
				System.out.print(", ");
			}
		} // csv 파일
		System.out.println();
	}

	public static void main(String[] args) {

		List<String> movies = new ArrayList<String>();
		movies.add("아바타");
		movies.add("쇼생크탈출");
		movies.add("명량");
		movies.add("에일리언");
		movies.add("여인의향기");

		System.out.println("=== 마지막 배열 뒤엔 , 표 찍지 않기 ===");
		printMovies(movies); // 아바타 → 쇼생크탈출 → 명량 → 에일리언 → 여인의향기

		// movies 리스트를 오름차순 정렬시킴
		System.out.println("=== 오름차순 배열 (sort) ===");
		Collections.sort(movies);
		printMovies(movies);
		
		// movies 리스트를 내림차순 정렬시킴
		System.out.println("=== 내림차순 배열 (reverse) ===");
		Collections.reverse(movies);
		printMovies(movies);
		
		// 특정 요소의 인덱스 반환
		// 이진 검색(binary search)을 이용하므로 검색 속도가 매우 빠름
		// 단, 크기순으로 정렬이 되어 있어야 함.
		System.out.println("=== 아바타의 인덱스 찾기 ===");
		int idx = Collections.binarySearch(movies, "아바타");
		System.out.println(idx);
	}

}
