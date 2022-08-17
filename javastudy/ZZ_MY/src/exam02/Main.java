package exam02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void ClientMain() {

		Socket clientSocket = null;
		
		try {
			
			clientSocket = new Socket();
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			clientSocket.connect(address);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (clientSocket.isClosed() == false) clientSocket.close(); 		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ServerMain() {
	
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			serverSocket.bind(address);
			
			while(true) {
				Socket client = serverSocket.accept();
				InetSocketAddress clientAddress = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("접속이 허용된 클라이언트 : " + clientAddress.getHostName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket.isClosed() == false) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ClientMain();
		ServerMain();
		
	}		
}