package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import domain.Board;
import repository.BoardDao;

/*
 	JUnit 단위 테스트
 	
 	1. DAO의 메소드 단위로 단위 테스트를 수행한다.
 	2. Service 실행 결과가 "특정값"인 경우 Service를 대상으로 단위 테스트를 수행할 수 있다. (* ActionForwd가 아닐 경우)
 	3. 프로젝트의 BuildPath에서 JUnit 라이브러리를 추가하고 사용한다.
 	4. 테스트 수행
 		프로젝트 실행 : Run - JUnit
 	5. 주요 애너테이션
 	 	1) @Test   : 단위 테스트를 수행하는 메소드
 	 	2) @Before : 단위 테스트 수행 이전에 실행하는 메소드	(* Before ~  , BeforeEach 같이 어쩌구저쩌구)
 	 	3) @After  : 단위 테스트 수행 이후에 실행하는 메소드    (* After ~ )
 	
 */


public class BoardTest {

	@Test
	public void 목록테스트() {	// 메소드명은 '한글'을 주로 사용 (* 협업용 테스트가 아닌, 개발자 혼자 보는 것이기 때문에 한글 사용 가능)
		
		// 목록의 개수가 3개이면 테스트 성공, or 실패
		List<Board> boards = BoardDao.getInstance().selectAllBoards();
		assertEquals(3, boards.size());
		
	}

}
