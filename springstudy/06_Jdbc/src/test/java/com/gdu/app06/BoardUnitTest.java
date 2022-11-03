package com.gdu.app06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.repository.BoardDAO;

/* --------------------------------------------------------------------------------------------------
	■ 단위테스트 하는 방법 개요 ■
	
		1. 단위 테스트를 하기 위해 애너테이션을 2개 추가한다. (@RunWith, @ContextConfiguration)
		2. BoardUnitTest {} 에 DAO 단위로 테스트를 진행할 코드를 작성한다.
		3. 단위 테스트를 진행할 메소드 위에 애너테이션(@Test)을 추가 후,
		 	프로젝트 폴더를 우클릭 → Run As → JUnitTest 클릭
   -------------------------------------------------------------------------------------------------- */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

	/*
		■ 설명 ■
		
		1. @RunWith(SpringJUnit4ClassRunner.class)
				▷ JUnit4를 이용한 테스트를 수행하기 위해 필요한 클래스
				   
		2. @ContextConfiguration
				▷ 컨테이너에 저장된 Bean이 어디에 있는지 알려준다.
 				▷ Bean 어떻게 저장했는지에 따라 locations ={} 작성 방법이 다름
 	
		 	① root-context.xml 에 <bean> 태그를 작성한 경우
		 			@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
		 			
		 	② com.gdu.app06.config.SpringBeanConfig.java에 @Bean을 작성한 경우
		 			@ContextConfiguration(classes={SpringBeanConfig.class})
		 			
		 	③ component-scan과 컴포넌트(@Component, @Service, @Repository 등)를 이용한 경우
		 			@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
 			
 			* Bean이 여러 개일 경우, 배열{}에 콤마(,)를 찍고 이어 쓰면 된다. EX) {a, b, c}
	*/


public class BoardUnitTest {
	/* --------------------------------------------------------------------
		DAO 단위로 Unit 테스트를 진행하기 때문에 BoardDAO 를 선언해준다.
	   -------------------------------------------------------------------- */
	@Autowired
	private BoardDAO dao;
	
	
	// @Test
	public void 삽입테스트() {
		
		BoardDTO board = new BoardDTO(0, "테스트제목", "테스트내용", "테스트작성자", null, null);
		assertEquals(1, dao.insertBoard(board));
		
	}
	
	@Test
	public void 조회테스트() {
		assertNotNull(dao.selectBoardByNo(2));
	}
}
