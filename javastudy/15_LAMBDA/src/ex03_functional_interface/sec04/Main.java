package ex03_functional_interface.sec04;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = (a,b) -> a + b;
		System.out.println(calculator.add(3, 5));
	}

}
