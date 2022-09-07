package ex06_select;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Board;

public class Review {

	public static void inputstream() {
		File file = new File ("C:\\storage", "b1.bin");
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			StringBuilder sb = new StringBuilder();
			byte[] b = new byte[5];
			int readByte = 0;
			
			while ((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public static void dataInputStream() {
		File file = new File ("C:\\storage", "b3.dat");
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			
			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println(name + ", " + age + ", " + height);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
/*	public static void objectInputStream() {
		File file = new File ("C:\\storage", "b4.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			List<User> users = (List<User>)ois.readObject();
			User user = (User)ois.readObject();
			
			for (User u : users) {
				System.out.println(u);
			}
			System.out.println(user);
			
		} catch (ClassNotFoundException e) {e.printStackTrace();
		} catch (IOException e) { e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException e) { e.printStackTrace();
			}
		}
	}
	*/
	public static void selectList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select board_no, title, content, hit, create_date from board order by board_no desc";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			List<Board> boards = new ArrayList<Board>();
			
			while (rs.next()) {
				Board board =new Board();
				board.setBoard_no(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setCreate_date(rs.getDate("create_date"));
				
				boards.add(board);
			}
			for (int i = 0; i < boards.size(); i++) {
				System.out.println(boards.get(i));
			}
			/*
			 for (Board board : boards)
			 	System.out.println(board);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//inputstream();
		//dataInputStream();
		//objectInputStream();
		//selectList();
		

	}

}
