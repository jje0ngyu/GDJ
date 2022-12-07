package ex03_functional_interface.sec02;

public class Main {

	public static void main(String[] args) {
		// 곧바로 람다로 만들기
		MyInterface2 me = (a) -> System.out.println(a);
		me.method(10);
	}

}
