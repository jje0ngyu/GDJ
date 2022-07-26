package com.gdu.app08.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.gdu.app08.domain.BoardDTO;

@Repository  // 컴포넌트로 등록
public class BoardDAO {

	// JdbcTemplate
	// Connection, PreparedStatement, ResultSet을 내부에서 사용하는 스프링 클래스
	// DriverManagerDataSource에 의해서 Connection Pool 방식으로 동작
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BoardDTO> selectAllBoards() {
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY BOARD_NO DESC";
		List<BoardDTO> boards = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));
		return boards;
	}
	
	public BoardDTO selectBoardByNo(final int board_no) {  // 예전에 매개변수 해킹 시도가 있었다. 그래서 final이 붙을 수 있다. 
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD WHERE BOARD_NO = ?";
		BoardDTO board = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), board_no);
		return board;
	}
	
	public int insertBoard(final BoardDTO board) {
		String sql = "INSERT INTO BOARD (BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE) "
				   + "VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";

		
		//* PreparedStatementSetter() 인터페이스 사용하는 방법
		//* ps 에 값을 전달하기만 하면 끝난다.
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			//* jdbcTemplate.update() 는 insert, update, delete 쿼리에서 사용하면 된다.
			//* executeUpdate(); 를 사용하는 것과 동일한 것 같다.
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setString(3, board.getWriter());
			}
		});
		return result;
	}
	
	public int updateBoard(final BoardDTO board) {
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, MODIFY_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE BOARD_NO = ?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setInt(3, board.getBoard_no());
			}
		});
		return result;
	}
	
	public int deleteBoard(final int board_no) {
		String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, board_no);
			}
		});
		return result;
	}
	
}