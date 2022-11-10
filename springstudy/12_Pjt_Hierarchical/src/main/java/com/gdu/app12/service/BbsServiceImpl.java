package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app12.mapper.BbsMapper;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsMapper bbsMapper;
	
	@Override
	public void findAllBbsList(HttpServletRequest request, Model model) {
		
	}

	@Override
	public int addBbs(HttpServletRequest request) {
		
		return 0;
	}

	@Override
	public int addReply(HttpServletRequest request) {
		
		return 0;
	}

	@Override
	public int removeBbs(int bbsNo) {

		return 0;
	}

}
