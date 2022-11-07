package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDAO {
	
	private SqlSessionFactory factory;
	
	private static FreeDAO dao = new FreeDAO();
	private FreeDAO() {
		try  {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FreeDAO getInstance() {
		return dao;
	}

	
	// method
	// 전체목록
	String mapper = "mybatis.mapper.free.";
	public List<Free> selectAllFrees(){
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectAllFrees");
		ss.close();
		return frees;
	}
	
	// 등록
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertFree", free);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
		
	// 상세보기
	public Free selectFreeByNo(long freeNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectFreeByNo", freeNo);
		ss.close();
		return free;
	}
		
	// 수정
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateFree", free);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 조회수 증가
	public int updateHits(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateHits", free);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 삭제
	public int deleteFree(long freeNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteFree", freeNo);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 조회수 TOP
	public List<Free> selectFreesTop() {
		SqlSession ss = factory.openSession();
		List<Free> top = ss.selectList(mapper + "selectFreesTop");
		ss.close();
		return top;
	}
}
