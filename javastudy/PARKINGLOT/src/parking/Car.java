package parking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor	//생성자
@NoArgsConstructor	//모든 필드값을 매개변수로 전달받아서 필드 초기화를 진행하는 생성자
@Getter
@Setter
@ToString

public class Car {
	
	// 필드
	private String carNo;	// 차량번호
	private String model;	// 차량모델
	
	// 메소드
	// getter
	// setter
	// toString()
}
