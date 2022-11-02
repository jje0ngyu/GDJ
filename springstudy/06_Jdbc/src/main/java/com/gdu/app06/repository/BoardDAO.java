package com.gdu.app06.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.app06.domain.BoardDTO;


/* --------------------------------------------------------------------
 @Repository : DAO 전용 @Component
 			   BoardDAO 에게 자동으로 Container에 Bean을 저장시킨다.
 			   트랜잭션 기능이 추가되어 있다.
----------------------------------------------------------------------- */
	/*
		■ 설명 ■
		
		Q. 왜 @Component 를 사용하나?
		A. BoardDAO 를 클래스(객체)로 등록하고자 사용한다.
		   즉, 애너테이션을 사용함으로써 Container 에 Bean 으로 자동으로 저장한다.
		
		   	※ 주의 ※
			   각 클래스별로 사용하는 전용 @Component 이름이 있다.
			   DAO     : @Repository
			   Service : @Service
		
		Q. @Component, @Repository, @Service 은 왜 자동으로 Bean에 저장하나?
		A. 애너테이션이 동작하는 이유는 'servlet-context.xml' 에 아래와 같은 코드(component-scan)가 등록되어 있기 때문이다.
		   <context:component-scan base-package="com.gdu.app06" />
		   
		-------------------------------------------------------------------------------------------------------------------
		
		■ 추가 설명 ■
		
		Container에 Bean을 추가하는 방법은 3가지가 있다.
		① root-context.xml 에 작성
		② BeanConfig.java  에 작성
		③ @Component       사용  ( 추천 ★ )
		
		▷ 컴포넌트를 사용함으로써 , xml/java 에 Bean 코드를 작성하지 않아도 된다.
	
	 */
@Repository
public class BoardDAO {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	private String sql;
		/*
			■ 설명 ■
		
			private 메소드 : 필드가 선언된 곳에서만 사용! (여기선, BoardDAO 에서만 사용)
							 메소드를 자동완성할 때, 빨간색 사각형이 보인다.
			
		*/
	
	
	
	/* -----------------------------------------------------------------------
	 가장 먼저 할 메소드 작업!
	 
	 	Connection을 열고(getConnection()), 닫는(close()) 메소드를 작성해준다. 
	-------------------------------------------------------------------------- */
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void close() {
		try {
			if (rs != null) { rs.close(); }
			if (ps != null) { ps.close(); }
			if (con != null) { con.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* -----------------------------------------------------
		레파지토리 계층의 이름은 "DB 친화적"으로 작성한다.
	-------------------------------------------------------- */
	public List<BoardDTO> selectAllBoards(){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
	
		try {
			con = getConnection();
			sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			ps  = con.prepareStatement(sql);
			rs  = ps.executeQuery();
			
			
			while (rs.next()) {
				BoardDTO board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				boards.add(board);
			}
				/*
					■ 설명 ■
					
					1. 검색된 결과가 있을 경우 : rs.next() == true
							▷ 결과가 있다면 메소드를 계속 실행하여, 전체목록을 불러오도록 한다.
					
					2. rs.next()로 불러온 1열의 SQL 결과를 BoardDTO에 저장하기 위해 new BoardDTO로 각각 저장한다.
					3. rs.next()의 결과물은 (rs.get데이터타입(인텍스번호))로 불러온다.
					 		▷ 데이터타입 : DTO에 저장한 데이터타입을 참고하여 getInt, getString 등을 사용하면 된다.
							▷ 인덱스번호 : SQL의 SELECT에 호출된 순서대로 인덱스 번호가 1부터 시작한다.
							
				  	4. 위에 만들어진 데이터를 ArrayList에 저장
					
				 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return boards;
	}
	
	public BoardDTO selectBoardByNo(int board_no) {
		BoardDTO board = null;
		
		return board;
	}
	
	public int insertBoard(BoardDTO board) {
		int result = 0;
		return result;
		
	}
	public int updateBoard (BoardDTO board) {
		int result = 0;
		return result;
	}
	public int removeBoard (int board_no) {
		int result = 0;
		return result;
	}
	
	
}
