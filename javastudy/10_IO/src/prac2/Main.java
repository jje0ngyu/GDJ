package prac2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void q1() {
		System.out.println("=== 다른 이름으로 파일 복사하기 ===");
		
		// eclipse~.zip 복사하기
		// 복사할 파일명은 eclipse.zip
		
		File src = new File ("C:\\GDJ\\installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File cpy = new File ("C:\\GDJ\\installer", "eclipse.zip");
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(cpy));
			
			byte[] b = new byte[1024]; 	// 1KB
			int readByte = 0;
			
			while ((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) bos.close();
				if (bis != null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void q2() {
		System.out.println("=== 다른 위치로 파일 이동하기 (복사 & 삭제) ===");
		
		File src = new File ("C:\\GDJ\\installer", "eclipse.zip");

		File dir = new File ("C:\\storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		File dst = new File ("C:\\storage", src.getName()); //* dst : destination / src.getName() : 같은 이름을 쓰겠다.
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
			
		try {
			
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dst));
		
			byte[] b = new byte[1024]; 	// 1KB
			int readByte = 0;
			
			while ((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			bos.close();
			bis.close();
			
			// 원본과 복사본의 크기가 동일하다면 원본 제거
			if (src.length() == dst.length()) {
				src.deleteOnExit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
	}
	
	public static void main(String[] args) {
		q2();
	}

}
