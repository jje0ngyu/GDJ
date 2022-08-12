package ex05_inputstream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import ex04_outputstream.User;

public class Main {

	public static void m1() {
		System.out.println("=== 바이트 입력 스트림 FileInputStream ===");
		
		File file = new File ("C:\\storage", "b1.bin");
		FileInputStream fis = null;
		
		try {
			
			// 바이트 입력 스트림 생성
			fis = new FileInputStream(file);
			
			// 입력 데이터 단위
			// 1. 1개 : int
			// 2. 여러 개 : byte[]
			
			// 모든 정보를 StringBuilder에 저장한 뒤 확인
			StringBuilder sb = new StringBuilder();
			byte[] b = new byte[5]; 	// 5바이트씩 읽기 위해서 준비
			int readByte = 0; 
			
			// int read(byte[] b)
			// 읽은 내용은 byte배열 b에 저장
			// 읽은 바이트 수를 반환
			// 읽은 내용이 없으면 -1 반환
			
//			readByte = fis.read(b); (* ★ 5바이트씩 읽어들이기)
			while ((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
			
			// 문자를 바이트 스트림으로 읽었기 때문에
			// 문제 발생
//			System.out.println(sb.toString()); (* 이렇게 호출하지 말 것 !!!)
			
		} catch (IOException e) { e.printStackTrace(); }
	}
	public static void m2() {
		System.out.println("=== 바이트 >>> 문자 입력 스트림으로 변환 InputStreamReader ===");
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
		File file = new File("C:\\storage", "b2.bin");
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
			try {
				
				fis = new FileInputStream(file);
				isr = new InputStreamReader(fis);
				
				StringBuilder sb = new StringBuilder();
				char[] cbuf = new char[5]; 	// 5글자씩 읽기 위해서
				int readCnt = 0;
				
				while ((readCnt = isr.read(cbuf)) != -1) {
					sb.append(cbuf, 0, readCnt);
				}
				
				System.out.println(sb.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try { if (isr != null) isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void rest() { 
		
		System.out.println(" 중요 X, 재미삼아 해보는 코딩 : Scanner 없이 입력해보기 ");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("입력 >>> ");
			String str = br.readLine(); //* 1줄 읽기
			
			System.out.println(str);
			
			br.close();
		} catch(IOException e) { e.printStackTrace(); }
	}
	
	public static void m3() {
		System.out.println("=== 데이터 읽어오기 ===");
		
		// 변수를 그대로 입력 받는 DateInputStream
		
		//* 바이트 타입을 문자 처리하여 읽어들이기
		//* FileInputStream > DataInputStream > readUTF()
		//* FileOutputStream > DataOutputStream > readUTF()
		
		
		
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
	public static void m4() {
		
		System.out.println("=== 오브젝트 읽어오기 ===");
		
		// 객체를 그대로 입력 받는 ObjectInputStream
		
		File file = new File ("C:\\storage", "b4.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			List<User> users = (List<User>)ois.readObject();
			User user = (User)ois.readObject(); 	//* 읽을 때는 readObject, 쓸 때는 writeObject.
			
			for (User u : users) {
				System.out.println(u);
			}
			System.out.println(user);
			
		} catch (ClassNotFoundException e) { //* readObject 는 2개의 Exception 사용
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) ois.close();
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	public static void main(String[] args) {
//		m1();
//		m2();
//		rest();
//		m3();
		m4();

		
	}

}
