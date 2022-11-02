package com.gdu.app05.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app05.domain.Member;

public class MemberServiceImpl implements MemberService {

	/* ---------------------------------------------------------------------------------
	  ■ String execute1() 작성 방법 ■
	 
	  1. 파라미터를 저장할 필드값을 생성
	  		▷ .jsp파일에서 ajax로 작업할 시, data 값을 id 와 pw 를 각각 전달하도록 한다.
	  		
	  2. request를 통해 전달받은 파라미터값을 생성한 필드에 저장
	  
	  3. 아이디와 비밀번호가 공란일 경우 경고창 메시지 입력 (노출할 값만 전달)
	  
	  4. 아이디와 비밀번호 전달이 성공하였을 경우, 아이디와 비밀번호 노출
	  
	  5. catch 블록의 try블록은 경고창을 한글로 노출하기 위한 작업
	  
	  (끝)
	----------------------------------------------------------------------------------- */
	@Override
	public String execute1(HttpServletRequest request, HttpServletResponse response) {
		String id = null;
		String pw = null;
		try {
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			if(id.isEmpty() || pw.isBlank()) {
				throw new RuntimeException("아이디와 비밀번호를 모두 입력하세요.");
			}
			return "당신의 아이디는 " + id + " 이고, 패스워드는 " + pw + " 입니다.";
		} catch(Exception e) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println(e.getMessage());
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	
	
	/* ---------------------------------------------------------------------------------
	  ■ Member execute2() 작성 방법 ■
	 
	  1. 파라미터를 받을 인수 생성
	  		▷ .jsp파일에서 ajax로 작업할 시, data 값을 <form id="frm_member">로 받는다.
	  		
	  2. Member 에 모두 입력되어 전달되기 때문에 전달받은 값을 바로 반환하면 된다.
	  
	  (끝)
	----------------------------------------------------------------------------------- */
	@Override
	public Member execute2(String id, String pw) {
		
		return new Member(id, pw);
	}

	
	
	/* ---------------------------------------------------------------------------------
	  ■ Map 을 이용해 반환하는 방법 ■
	 
	  1. 
	  		
	  2. 
	  
	  (끝)
	----------------------------------------------------------------------------------- */
	@Override
	public Map<String, Object> execute3(Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", member.getId());
		map.put("pw", member.getPw());
		return map;
	}

	@Override
	public Member execute4(Member member) {
		return member;
	}
}
