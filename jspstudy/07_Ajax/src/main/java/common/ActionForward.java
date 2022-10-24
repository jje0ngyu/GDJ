package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionForward {
	private String view;
	private boolean isRedirect;
	
	//* ajax 수업에서는 index 파일에서 ajax 파일로 넘어가기 위해 1회 사용했다.
}
