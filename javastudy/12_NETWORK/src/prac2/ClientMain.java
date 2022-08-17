package prac2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		
		Socket socket = null;
		Scanner sc = null;
		BufferedWriter out = null;
		
		try {
			
			//* 서버와 소켓 연결
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 9090));
			
			//* 메세지 입력
			sc = new Scanner(System.in);
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//* Client() 메소드 동작
			Client client = new Client(socket);
			client.start();
			
			//* 대화 종료할 때까지 반복
			while(true) {
				System.out.println(">>> ");
				String message = sc.nextLine();
				if(message.equalsIgnoreCase("exit")) {
					break;
				}
				out.write(message);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();
				if (socket.isClosed() == false) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
