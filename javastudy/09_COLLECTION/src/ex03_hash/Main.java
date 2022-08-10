package ex03_hash;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		/*
		Book book1 = new Book();
		
		System.out.println(book1.hashCode()); // 653305407 - book1객체의 참조값
		
		Book book2 = new Book();
		System.out.println(book2.hashCode()); // 1227229563 - book2객체의 참조값

		//* 1. 해시코드 비교
		//* 2. 같은 해시코드를 가진 것들끼리 동등비교
		//* 자바의 해시는 객체참조값
		
		System.out.println(book1.equals(book2)); // false (참조값 비교)
		*/
		
		Book book1 = new Book(1, "어린왕자");
		Book book2 = new Book(2, "홍길동전");
		Book book3 = new Book(3, "소나기");
		Book book4 = new Book(3, "소나기");
		
		System.out.println(book3.hashCode());	//* 1-1) Book 클래스에서 오버라이드 했기 때문에 해시값이 같다.
		System.out.println(book4.hashCode());
		
		Set<Book> books = new HashSet<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);	
		books.add(book4);	// 중복 저장 시도 (정상 동작하려면 Book 클래스에 hashCode(), equals() 메소드를 오버라이드 해야 함.)
		//* 1-2) 해시값이 같기 때문에 book3와 book4는 같아, "소나기"가 2번 등록되지 않았다.
		
		for(Book book : books) {
			System.out.println(book);
		}
	}
}
