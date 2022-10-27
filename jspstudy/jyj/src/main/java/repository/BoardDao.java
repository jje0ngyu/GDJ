package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Board;


public class BoardDao {

	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// Singleton - pattern
	private static BoardDao dao = new BoardDao();
	private BoardDao() {
		try  {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.board.";
	
	// 게시글 목록
	public List<Board> selectAllBoards() {
		SqlSession ss = factory.openSession();
		List<Board> boards = ss.selectList(mapper + "selectAllBoards");
		ss.close();
		return boards;
	}
	
	// 전체 게시글 수
		public int selectAllBoardsCount() {
			SqlSession ss =factory.openSession();
			int count = ss.selectOne(mapper + "selectAllBoardsCount");
			ss.close();
			return count;
		}
	
	
	// 게시글 삽입
	public int insertBoard(Board board){
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertBoard", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
		
	}
		
	// 게시글 상세보기
	public Board selectBoardByNo(int boardNo) {
		SqlSession ss = factory.openSession();
		Board boards = ss.selectOne(mapper + "selectBoardByNo", boardNo);
		ss.close();
		return boards;
	}

	// 게시글 수정
	public int updateBoard(Board board) {
		SqlSession ss = factory.openSession(false);	// UPDATE(커밋이 필요한 경우)
		int result = ss.update(mapper + "updateBoard", board);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 게시글 삭제
	public int deleteBoard(int boardNo){
		SqlSession ss = factory.openSession(false); // DELETE(커밋이 필요한 경우)
		int result = ss.delete(mapper + "deleteBoard", boardNo);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
}
