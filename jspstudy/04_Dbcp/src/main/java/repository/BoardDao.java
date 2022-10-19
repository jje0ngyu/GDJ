package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;

public class BoardDao {
	
	// field
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;	// 쿼리문 작성
	
	// Connection Pool 관리
	private DataSource dataSource;
	
	// singleton - pattern
	private static BoardDao dao = new BoardDao();
	//* static : 미리, 하나만! 만들어둔다.
	//* static이 붙은 메소드들은 이름으로 호출하기 때문에 '클래스 메소드'가 된다.
	
	
	
	
	private BoardDao() {
	//* 내부에서만 사용한다!
		try {
			// DataSource 객체 생성
			// context.xml에서 name="jdbc/oracle11g"인 Resource를 찾아서 생성 (JNDI : *name을 통해 찾는 것)
			Context ctx = new InitialContext();	// *context : javax.naming 인터페이스
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			dataSource = (DataSource)envCtx.lookup("jdbc/oracle11g");
			// dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
	//* 외부에서 사용하려면 미리 만들어논 메소드를 사용한다. (static으로 만들었으므로, static으로 만들어준다.)
	//* getInstance 메소드를 사용해 호출할 수 있도록 한다. (반환값: dao)
		return dao;
	}
	
	
	
	
	
	// method
	// 1. 접속/자원 해제
	public void close (Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}	// Connection Pool의 close()는 Connection 종료가 아닌 Connection 반환
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	// 2. 목록 반환하기
	public List<Board> selectAllBoards(){
		List<Board> boards = new ArrayList<Board>();
		try {
			con = dataSource.getConnection();	// CP(Connection Pool)로부터 Connection 대여
			sql = "SELECT BOARD_NO, TITLE, CONTENT, CREATE_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			ps = con.prepareStatement(sql);		//* sqlInjection을 예방하기 위한 보안차원으로 prepareStatement 사용
			rs = ps.executeQuery(); 	// SELECT문은 executeQuery() 사용
			while(rs.next()) {
				// Board board는 한 개의 게시글을 의미한다.
				Board board = new Board();
				board.setBoard_no( rs.getInt(1));	   // rs.getInt("BOARD_NO")
				board.setTitle( rs.getString(2));	   // rs.getString("TITLE")
				board.setContent( rs.getString(3));    // rs.getStrting("CONTENT")
				board.setCreate_date( rs.getDate(4));  // rs.getDate("CREATE_DATE")
				
				// 가져온 게시글을 리스트에 추가함 
				boards.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boards;
	}
	
	
	
	
	
	
	// 3. 상세보기
	//* PK값을 받아온다.
	public Board selectBoardByNo(int board_no) {
		//* 게시글이 없다면 반환하지 않도록 초기값: null 
		Board board = null; 
		try {
			con = dataSource.getConnection();	// CP(Connection Pool)로부터 Connection 대여
			sql = "SELECT BOARD_NO, TITLE, CONTENT, CREATE_DATE FROM BOARD WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);		// 1번째 물음표(?)에 board_no 전달하기
			rs = ps.executeQuery();		// SELECT문은 executeQuery(); 사용
			if (rs.next()) {			// 상세보기는 if문
				//* rs.next() 가 true 일때, (결과값이 있을 때 생성하기)
				board = new Board();
				board.setBoard_no(    rs.getInt(1));	   // rs.getInt("BOARD_NO")
				board.setTitle(       rs.getString(2));	   // rs.getString("TITLE")
				board.setContent(     rs.getString(3));    // rs.getStrting("CONTENT")
				board.setCreate_date( rs.getDate(4));      // rs.getDate("CREATE_DATE")
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return board;
	}
	
	
	
	
	//* DML (INSERT, UPDATE, DELETE 는 executeUpdate() 사용 !
	// 4. 게시글 삽입
	public int insertBoard(Board board) {
		int result = 0;
		
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			result = ps.executeUpdate();	// INSERT문은 executeUpdate() 메소드 사용
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null); //* rs 값은 select문에서만 사용하므로, 여기서는 null값으로 작성한다. (사용하지 않았으므로 'null'입력)
		}
		return result;
		
		
	}
	
	
	
	
	// 5. 게시글 수정
	public int updateBoard(Board board) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoard_no());
			result = ps.executeUpdate();	// UPDATE문은 executeUpdate() 메소드 사용
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
	
	
	
	
	// 6. 게시글 삭제
	//* 삭제한 게시글의 번호(PK)가 입력되기 때문에 int
	public int deleteBoard(int board_no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM BOARD WHERE BOARD_NO=?";
			ps  = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			result = ps.executeUpdate();	// DELETE문은 executeUpdate() 메소드 사용
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
		
	}
	

}
