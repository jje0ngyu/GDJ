package prac1;

public class Watch {
	// 필드
	private int hour;
	private int minute;
	private int second;
	
	// 생성자
	public Watch (int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void addHour (int hour) {
		if (hour < 0)
			return;
		this.hour += hour;
		this.hour %= 24;
	}
	
	
	public void addMinute (int minute) {
		if (minute < 0)
			return;
		this.minute += minute; 		// 15분 + 61분 : 76분 (this.minute)
		addHour(this.minute / 60);  // 76분 / 60분 : 1시간
		this.minute %= 60; 			// 76분 % 60분 : 16분
	}
	
	public void addSecond (int second) {
		if (second < 0)
			return;
		this.second += second;			// 30초 + 3615초 : 3645초 (this.second)
		addMinute(this.second / 60); 	// 3645초 / 60초 : 60분
		this.second %= 60;
	}
	
	public void see() {
		System.out.println(hour + "시" + minute + "분" + second + "초");
	}
	
}
