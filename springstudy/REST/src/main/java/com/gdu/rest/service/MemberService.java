package com.gdu.rest.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.gdu.rest.domain.MemberDTO;

public interface MemberService {

	public Map<String, Object> register(MemberDTO member, HttpServletResponse response);
	public Map<String, Object> getMemberList(int page);
	public Map<String, Object> getMemberByNo(int memberNo);
	
	// 프론트단에서 응답할 수 있도록 작업했기 때문에, 응답을 위해 response를 사용한다.
	public Map<String, Object> modifyMember(Map<String, Object> map, HttpServletResponse response);
	// service 단에서 배열로 변환해줄 것이기 때문에 '3,1' 자체를 하나의 String으로 보내면 된다.
	public Map<String, Object> removeMemberList (String memberNoList);
}
