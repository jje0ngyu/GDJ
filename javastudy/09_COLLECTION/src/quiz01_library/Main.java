package quiz01_library;

public class Main {

	public static void main(String[] args) {
//		Library library = new Library();
//		library.manage();
		
		Book book1 = new Book(1, "어린왕자", "생텍쥐베리");
		Book book2 = new Book(1, "어린왕자", "생텍쥐베리");
		
		System.out.println(book1.equals(book2));	//* Book 클래스에서 @Override equals를 생성하여 true 반환.
		
		Library library = new Library();
		library.manage();
	}
}
