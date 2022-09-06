package ex05_delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import domain.Board;

public class Review {
	public static void insert() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제목 >>> ");
		String title = sc.nextLine();
		
		System.out.print("내용 >>> ");
		String content = sc.nextLine();
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO BOARD (BOARD_NO, TITLE, CONTENT, HIT, CREATE_DATE) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, 0, SYSDATE)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void update() {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("수정할 게시글 번호 >>> ");
			int boardNo = sc.nextInt();
			sc.nextLine();
			
			System.out.print("수정할 게시글 내용 >>> ");
			String content = sc.nextLine();
			
			Board board = new Board();
			board.setBoard_no(boardNo);
			board.setContent(content);
			
			// 접속
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			// 쿼리문
			String sql = "UPDATE BOARD SET CONTENT = ? WHERE BOARD_NO = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getContent());
			ps.setInt(2, board.getBoard_no());
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete() {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("삭제할 게시글 번호 >>> ");
			int board_no = sc.nextInt();
			sc.nextLine();
			
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//insert();
		//update();
		delete();
	}

}
