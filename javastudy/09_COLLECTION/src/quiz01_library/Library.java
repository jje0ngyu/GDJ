package quiz01_library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {
	// addBook() 		- FULL check하지 않음.
	// removeBook()		- Empty Check 필요함 (예외처리로 변경)
//		removeBookByIndex()  - 인덱스 정보를 이용해서 제거
	//	removeBookByObject() - 객체(Book) 정보를 이용해서 제거
	// findBook() 		- Empty Check 필요함 (예외처리로 변경)
	// printAllBook()	- Empty Check 필요함 (예외처리로 변경)
//		*추가
//		modifyBook() 	- 책 제목을 입력 받아서 일치하는 책의 정보를 변경
	
	private Scanner sc;
	private List<Book> books;
//	private int idx;	//* List를 사용함으로써, 배열이 사라지고, idx도 불필요.
	
	public Library() {
		sc = new Scanner(System.in);
		books = new ArrayList<Book>();
	}
	
	
	
	private void addBook() {
		System.out.println("=== 책 등록 ===");
		System.out.println("책 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.println("제목 입력 >>> ");
		String title = sc.next();
		System.out.println("저자 입력 >>> ");
		String author = sc.next();
		
		Book book = new Book(bookNo, title, author);
		books.add(book); //* (♣)
	}
	
	
	
	private void removeBookByIndex() {
		// Book remove(int index) 메소드 이용
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("=== 책 삭제 ===");
		System.out.print("삭제할 책의 번호 >>> ");
		int bookNo = sc.nextInt();
		for (int i = 0, length = books.size(); i < length; i++) {
			if (books.get(i).getBookNo() == bookNo) {
				Book removeBook = books.remove(i);
				System.out.println(removeBook + " 책을 삭제했습니다.");
				return;
			}
		}
		throw new RuntimeException("책 번호가 " + bookNo + "인 책이 없습니다.");
		}
	
	
	
	private void removeBookByObject() {
		// boolean remove(Object obj)
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("책 번호 입력 >>> ");
		int bookNo = sc.nextInt();
		System.out.println("제목 입력 >>> ");
		String title = sc.next();
		System.out.println("저자 입력 >>> ");
		String author = sc.next();
		
		Book book = new Book(bookNo, title, author);
		if(books.remove(book)) {
			System.out.println(book + " 책을 삭제했습니다.");
			return;
		}
		throw new RuntimeException("책 번호가 " + book + "인 책이 없습니다.");
	}
	
	
	
	private void findBook() {
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("=== 책 조회 ===");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title = sc.next();
		for (int i = 0, length = books.size(); i < length; i++) {
			if (books.get(i).getTitle().equals(title)) {	
				System.out.println(books.get(i));
				return;
			}
		}
		throw new RuntimeException("제목이 " + title + "인 책이 없습니다.");
	}
	
	
	
	private void printAllBooks() {
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
		System.out.println("=== 전체 조회 ===");
		for(Book book : books) {
			System.out.println(book);
		}
	}

	
	
	private void modifyBook() {
		if (books.isEmpty()) {
			throw new RuntimeException("등록된 책이 한 권도 없습니다.");
		}
	}
	
	
	
	public void manage() {
		try {
			while(true) {
				System.out.print("1.추가  2.삭제  3.조회  4.전체목록  5.수정  0.프로그램종료 >>> ");
				int choice = sc.nextInt();
				sc.nextLine();	//* ex) 1을 입력 후, 불필요한 엔터 입력키를 프로세스에서 버리는 작업
				switch(choice) {
				case 1 : addBook(); break;
				case 2 : removeBookByIndex(); break; 	//removeBookByObject() 가능
				case 3 : findBook(); break;
				case 4 : printAllBooks(); break;
				case 5 : modifyBook(); break;
				case 0 : System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					return;	// manage() 메소드 종료
				default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
				}
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.out.println("명령은 정수입니다.");
		
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
