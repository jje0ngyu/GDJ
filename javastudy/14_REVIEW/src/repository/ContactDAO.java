package repository;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.ContactDTO;

public class ContactDAO {

	private static ContactDAO contactDAO = new ContactDAO();
	
	private ContactDAO () {
		
	}
	public static ContactDAO getInstance() {
		return contactDAO;
	}
	
	
	private Connection con;			// DB접속
	private String sql;				// 쿼리문
	private PreparedStatement ps;	// 쿼리문 실행
	private ResultSet rs;			// SELECT 결과
	private int result;				// INSERT, UPDATE, DELETE 결과
	
	
	// 공통 메소드 1
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Properties p = new Properties();
		p.load(new FileReader("db.properties"));
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		return DriverManager.getConnection(url, user, password);
	}
	
	// 공통 메소드 2
	public void close() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 연락처 추가 메소드
	public int insertContact(ContactDTO contact) {
		try {
			con = getConnection();
			sql = "insert into contact values (contact_seq.nextval, ?, ?, ?, sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 연락처 수정 메소드
	public int updateContact(ContactDTO contact) {
		try {
			con = getConnection();
			sql = "update contact set name = ?, tel =?, email =? where contact_no = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setInt(4, contact.getContact_no());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	// 연락처 목록 메소드
	public List<ContactDTO> selectAllContacts() {
		List<ContactDTO> contacts = new ArrayList<ContactDTO>();
		
		try {
			con = getConnection();
			sql = "select contact_no, name, tel, email, reg_date from contact";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ContactDTO contact = ContactDTO.builder()
						.contact_no(rs.getInt(1))
						.name(rs.getString(2))
						.tel(rs.getString(3))
						.email(rs.getString(4))
						.reg_date(rs.getDate(5))
						.build();
				contacts.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contacts;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
