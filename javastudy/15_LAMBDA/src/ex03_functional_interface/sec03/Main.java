package ex03_functional_interface.sec03;

public class Main {

	public static void main(String[] args) {
		MyInterface3 me = () -> 10;
		/*
			MyInterface3 me = () -> {
				int a = 10;
				return a;
			};
			
		 */
		System.out.println(me.method());
		
		MyInterface3 you = () -> 20;
		System.out.println(you.method());
	}

}
