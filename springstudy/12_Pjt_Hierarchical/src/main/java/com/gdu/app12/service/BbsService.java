package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BbsService {
	public void findAllBbsList(HttpServletRequest request, Model model);
	
	// 삽입 2개
	public int addBbs(HttpServletRequest request);
	public int addReply(HttpServletRequest request);
	//* ip를 알기 위해선 request가 필요.
	
	// 삭제
	public int removeBbs(int bbsNo);	
}
