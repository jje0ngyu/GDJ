package com.gdu.app06.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
/* 롬복이 사용되지 않는다면, 롬복 추가 후 STS를 재실행해야 한다.*/

public class BoardDTO {

	private int board_no;
	private String title, content, writer, create_date, modify_date;
	
}
