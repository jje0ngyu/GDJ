package com.gdu.app11.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class PageUtil {
	// 페이지
	private int page;				// 현재 페이지 (파라미터로 받아오는 정보)
	private int totalRecord;		// 전체 레코드 개수 (DB에서 받아오는 정보)
	private int recordPerPage = 10;	// 페이지별 표시할 레코드 개수 (임의로 정한다)
	private int begin;				// 가져올 목록의 시작 번호 (계산한다)
	private int end;				// 가져올 목록의 끝 번호 (계산한다)
	// 블록
	private int totalPage;	  	  	// 전체 페이지 개수 (계산한다)
	private int pagePerBlock = 5; 	// 블록에 표시할 페이지 개수 (임의로 정한다)
	private int beginPage;		  	// 블록의 시작 페이지 번호 (계산한다)
	private int endPage;		  	// 블록의 끝 페이지 번호 (계산한다)
	
	
	public void setPageUtil(int page, int totalRecord) {	//
	
		// page, totalRecord 필드 저장
		this.page = page;
		this.totalRecord = totalRecord;
		
		// begin, end 계산
		begin = (page - 1) * recordPerPage + 1;
		end = begin + recordPerPage - 1;
		if(end > totalRecord) {
			end = totalRecord;
		}
		
		// totalPage 계산
		totalPage = totalRecord/recordPerPage;
		if (totalRecord % recordPerPage != 0) {
			totalPage++;
		}
		
		// beginPage, endPage 계산
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
	
	public String getPaging(String path) {
		StringBuilder sb = new StringBuilder();
		
		// 1. path에 파라미터가 없는 경우
		//		/emp/list
		//		/emp/list?page=1	(page 앞에 ?를 사용)
		
		// 2. path 에 파라미터가 있는 경우
		//		/emp/search?column=EMPLOYEE_ID&query=150
		//		/emp/search?column=EMPLOYEE_ID&query=150&page=1		(page 앞에 &를 사용)
		if(path.contains("?")) {
			path += "&";
		} else {
			path += "?";
		}
		
		
		// 이전 블록 : 1block이 아니면 이전블록이 있다.
		if (beginPage != 1) {
			sb.append("<a href=\"" + path + "page=" + (beginPage-1) + "\">◀</a>");
		}
		
		// 페이지 번호 : 현재 페이지는 링크가 없다. 
		for (int p = beginPage; p <= endPage; p++) {
			if(p != page) {
				sb.append("<a href=\"" + path + "page=" + p +  "\">" + p + "</a>");
			} else {
				sb.append(p);
			}
		}
		
		// 다음 블록 : 마지막block이 아니면 다음 블록이 있다.
		if (endPage != totalPage) {
			sb.append("<a href=\"" + path + "page=" + (endPage+1) + "\">▶</a>");
		}
		
		return sb.toString();
	}


}
