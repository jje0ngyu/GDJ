package ex04_socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		Socket clientSocket = null;
		
		try {
			
			// Socket 생성 및 바인딩 
			clientSocket = new Socket();
			
			// 서버 접속
			clientSocket.connect(new InetSocketAddress("localhost", 9099));
			
			// 서버에 접속되면 Welcome 메시지가 넘어옴
			// 서버가 DataInputStream의 WriteUTF() 로 메시지를 전송하므로
			// 클라이언트는 DataInputStream의 readUTF() 로 메시지를 받음
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			String message = in.readUTF();
			System.out.println("[클라이언트] " + message);
			
			// Scanner 클래스를 이용해 입력 받은 데이터를 서버로 보내기
			Scanner sc = new Scanner(System.in);
			System.out.println("서버로 전송할 메시지 >>> ");
			String send = sc.nextLine();
			OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
			out.write(send);  //* 문자를 보낸 것이기 때문에 byte[]  사용하지 않아도 된다.
			
			// 입출력 스트림 종료
			out.close();
			in.close();
			sc.close();
			
		} catch (UnknownHostException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace();
		} finally {
			try {
				if (!clientSocket.isClosed()) {
					System.out.println("[클라이언트] 클라이언트 종료");
					clientSocket.close();
				}
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
}
