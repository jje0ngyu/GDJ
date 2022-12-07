package com.gdu.rest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.service.MemberService;

/*
	REST : Representational State Transfer
	
	1. 자원을 정의하고 자원의 주소를 지정하는 방식에 대한 하나의 형식이다.
	2. REST 방식을 따르는 시스템을 "RESTful하다"라고 표현한다.
	3. 동작의 결정을 'URL(매핑) + Method' 조합으로 결정한다.
	4. 파라미터가 URL에 경로처럼 포함된다. (?를 사용하지 않는다.)
	5. CRUD 처리 방식
					URL				Method
	 	1) 삽입		/members		POST
*/

@RestController	// 이 컨트롤러는 모든 메소드에 @ResponseBody 애너테이션을 추가한다.
public class MemberRestController {

	@Autowired
	private MemberService memberService;
	
	// 삽입
	// 파라미터로 전달받지 않는다면, 삽입한 정보는 어떻게 전달될까?
	// response 사용 이유? 에러메시지를 전달하기 위해 사용!
	// ResponseEntity를 사용하지 않은 이유? 최근에 나온 문법이기 때문에, 협업에서 사용이 어려울 수 있다. "너 혼자 개발하니?"
	@PostMapping(value="/members", produces="application/json")
	public Map<String, Object> addMember(@RequestBody MemberDTO member, HttpServletResponse response){
		return memberService.register(member, response);
	}
}
