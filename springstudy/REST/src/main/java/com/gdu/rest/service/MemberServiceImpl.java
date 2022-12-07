package com.gdu.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response) {
		
		try {
			Map<String, Object> result = new HashMap<>();
			result.put("insertResult", memberMapper.insertMamber(member));
			return result;
		} catch (DuplicateKeyException e) {
			System.out.println("이미 있지롱~");
		} catch (Exception e) {
			// 예외 이유 출력 (* 정확하게는 예외 클래스 이름 출력 oooException)
			System.out.println(e.getClass().getName());
		}
		
		return null;
	}
	
}
