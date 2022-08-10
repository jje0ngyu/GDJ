package ex01_file;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Main {

	public static void m1() {
		
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉터리 관리
		// 3. 생성 방법
		// 		1) new File (경로, 파일)
		//		2) new File (파일)
		// 4. 윈도우의 경로 구분 방법 : 백슬래시(\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시(/)
		
		// 폴더 (디렉터리) 만들기
		File dir = new File("C:\\storage");	//* 백슬래시 2개를 써야 1개로 인식
//		File dir = new File("C:", "storage");
		
		
		// 존재하지 않으면 만들겠다.
		if(dir.exists() == false) {	// if (!dir.exists())
			dir.mkdirs();
			System.out.println("폴더 생성 성공");
		}
		
		// 존재하면 삭제하겠다.
		else {
//			dir.delete();	// 지금 지운다.
			dir.deleteOnExit();    // JVM이 종료되면 지운다.
			System.out.println("폴더 삭제 성공");
		}
	}
	
	public static void m2() {
		File file = new File("C:\\storage","my.txt");
		
		try {
			if (file.exists() == false) {
				file.createNewFile();	// IOException - checked Exception 이므로 try-catch
			} else {
				file.delete();
				file.deleteOnExit();
			}
		} catch (IOException e) {
			// 개발할 때 넣는 catch 블록 코드
			e.printStackTrace();    // 에러를 콘솔에 찍어라.
		}
	}
	
	public static void m3() {
		File file = new File ("C:\\storage","my.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로 : " + file.getParent());
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " +  file.isFile());
		
		long lastModifiedDate = file.lastModified(); 	//* 반환 타입 : long
		System.out.println("수정한 날짜 : " + lastModifiedDate);
		
		
		
		// 오전 09:50 2022-08-10 수정하기
//		Date date = new Date(lastModifiedDate);
//		SimpleDateFormat sdf = new SimpleDateFormat("a HH:mm yyyy-MM-dd");
//		String lastModified = sdf.format(date);
//		System.out.println("수정한 날짜 : " + lastModified);
		
		String lastModified = new SimpleDateFormat("a HH:mm yyyy-MM-dd").format(lastModifiedDate);
		System.out.println("수정한 날짜 : " + lastModified);
		
		
		System.out.println();
		System.out.println("=== 파일의 크기 확인하기 ===");
		long size = file.length();	// 바이트 단위
		System.out.println(size + "byte");
	}
	
	
	public static void m4() {
		
		File dir = new File("C:\\GDJ");
		
		File[] list = dir.listFiles();	// 디렉터리 내부의 모든 파일/디렉터리를 File 객체로 가져옴
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
		
	}
	
	public static void m5() {
		
		// 플랫폼마다 다른 경로 구분자 지원
		File file = new File("C:" + File.separator + "storage" + File.separator +  "my.txt");
		System.out.println(file.getName());
		
	}
	
	
	public static void q1() {
		File dir = new File ("C:\\GDJ");
		File[] list = dir.listFiles();
		int dirCnt = 0;
		int fileCnt = 0;
		long totalSize = 0;
		
		for (File file : list) {
			if(file.isHidden()) {
				continue;
			}
			String lastModified = new SimpleDateFormat("yyyy-MM-dd  a HH:mm  ").format(file.lastModified());
			String directory ="";
			String size = "";
			
			if(file.isDirectory()) {
				directory = "<DIR>";
				size = "     ";
				dirCnt++;
				
			} else {
				directory = "     ";
				size = new DecimalFormat("#,##0").format(file.length()) + "";
				fileCnt++;
				totalSize += Long.parseLong(size.replace(",", ""));
			}
			
			String name = file.getName();
			System.out.println(lastModified + " " + directory + " " + size + " " + name);
		}
		System.out.println(dirCnt + "개 디렉터리");
		System.out.println(fileCnt + "개 파일 " + new DecimalFormat("#,##0").format(totalSize) + "바이트");
		
		
//		File dir = new File ("C:\\GDJ");
//		File[] list = dir.listFiles();
//		int fileNo = 0;
//		int dirNo = 0;
//		long size = 0;
		
//		for (int i = 0; i < list.length; i++) {
//			if (!list[i].isHidden()) {
//				long lastModifiedDate = list[i].lastModified();
//				String lastModified = new SimpleDateFormat("yyyy-MM-dd  a HH:mm  ").format(lastModifiedDate);
//				System.out.print(lastModified);
		
//				if (list[i].isDirectory()) {
//					dirNo++;
//					System.out.print("<DIR>   ");
//				} else {
//					fileNo++;
//					long fileSize = list[i].length();
//					size += fileSize;
//					System.out.print("     " + fileSize);
//				}
		
//				System.out.println(list[i].getName());
//			} 			
//		}
//		
//		System.out.println("\t    " + fileNo + "개 파일 \t\t" + size + "바이트" );
//		System.out.println("\t    " + dirNo + "개 폴더");
//		
	}
	
	
	public static void q2() {
		// C:\storage 디렉터리 삭제하기
		String sep = File.separator;
		File file = new File("C:" + sep + "storage" + sep + "my.txt");
		if (file.exists() ) {
			file.delete();
			System.out.println("파일 삭제 성공");
		} else {
			System.out.println("파일 삭제 실패");
		}
		
		File dir = new File("C:" + sep + "storage");
		if (dir.exists()) {
			dir.delete();
			System.out.println("폴더 삭제 성공");
		} else {
			System.out.println("폴더 삭제 실패");
		}
	}
	
	public static void main(String[] args) {
		q2();		
	}

}





































