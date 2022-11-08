package com.gdu.app11.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDTO {

	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	//* int 는 21억까지 커버가능
	//* 변수 이름은 mybatis가 인식할 수 있도록 칼럼명과 동일(카멜케이스로만 변화)
	
	
}
