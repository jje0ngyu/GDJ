package ex02_datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex05_LocalDateTime {

	public static void main(String[] args) {
		
		// java time.LocalDateTime 클래스
		// JDK 1.8부터 사용이 가능한 클래스 * @since 1.8
		// 특정 날짜 요소 사용이 가능
		// 날짜의 패턴 지정이 가능
		
		LocalDateTime now = LocalDateTime.now();  // 현재 날짜와 시간
		
		// 특정 날짜 요소 사용
		int year = now.getYear();
		int month = now.getMonthValue();  // 1 ~ 12
		int day = now.getDayOfMonth();    // 1 ~ 31
		int hour = now.getHour();
		int miute = now.getMinute();
		int second = now.getSecond();
		
		// * 단어를 더블클릭하면 블락된다.
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(miute);
		System.out.println(second);
		
		// 패턴
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("a h:mm yyyy-MM-dd"); // 결과: 문자열 패턴 지정
		String date = dtf.format(now);
		System.out.println(date);
		
	}

}
