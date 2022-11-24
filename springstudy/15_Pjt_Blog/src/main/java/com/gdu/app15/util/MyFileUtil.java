package com.gdu.app15.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;

import org.springframework.stereotype.Component;

@Component
public class MyFileUtil {

	// 파일명 : UUID값을 사용 (Universally Unique ID)
	// 경로명 : 현재 날짜를 디렉터리로 생성해서 사용
	
	
	//* uuid 참고 블로그
	//* https://mattmk.tistory.com/31
	public String getFilename(String filename) {
		// * 왜?
		// * 1. 유니크 처리를 위해서 : 디렉터리 하나에 같은 이름의 파일이 2개 이상 들어갈 수 없다.
		// *						   즉, 다양한 사용자들이 같은 이름으로 파일을 사용할 수 있기 때문에, 중복 방지를 위해서!
		// * 2. 인코딩이 필요없다.
		
		// 확장자 예외 처리 (// ex 리눅스)
		String extension = null;
		if(filename.endsWith("tar.gz")) {
			extension = "tar.gz";
		} else {
		// 파라미터로 전달된 filename의 확장자만 살려서 UUID. 확장자 방식으로 반환
		String[] arr = filename.split("\\."); 	// 정규식에서 .(마침표) 인식 : \. 또는 [.]
		
		// 확장자
		extension = arr[arr.length-1];	//* 리눅스의 확장자는 여러 개로 나타나므로, 실무에서 사용할 수 없는 코드이다.
		}
		
		// UUID.확장자
		return UUID.randomUUID().toString().replaceAll("\\-", "") + "." + extension;
	}
	
	// 오늘 경로
	public String getTodayPath() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		//* separator : 사용자 환경(Window, Linux)에 따라 \ , / 를 구분해서 넣어줌
		return "storage" + sep + year + sep + makeZero(month) + sep + makeZero(day);
	}
	// 어제 경로
	public String getYesterdayPath() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendar.DATE, -1);	// 1일전 *(단위, -1) 
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		//* separator : 사용자 환경(Window, Linux)에 따라 \ , / 를 구분해서 넣어줌
		return "storage" + sep + year + sep + makeZero(month) + sep + makeZero(day);
	}
	// 1~9 => 01~99
	public String makeZero(int n) {
		return (n<10)? "0" + n : "" + n;
	}
}
