package ex04_has_a_inheritance;

public class Review_Page {
	String getCoffee(int money, int button) {
		String[] menu = { "아메리카노", "카페라떼" };
		return menu[button - 1] + " " + (money / 1000) + "잔";
	}
}

