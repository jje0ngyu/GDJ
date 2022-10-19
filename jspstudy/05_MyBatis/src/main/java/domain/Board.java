package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Board {
	private int boardNo;	//* DB 칼럼과 이름을 맞추기 위해서 자바에서 변수 이름도 BOARD_NO로 맞췄으나, 프레임워크의 도움으로 자바이름규칙(camel case)으로 바꾼다.
	private String title;
	private String content;
	private Date createDate;
	
	
}
