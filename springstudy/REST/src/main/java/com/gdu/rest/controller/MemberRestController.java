package com.gdu.rest.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 	2) 목록		/members		GET
	 	3) 상세		/members/1		GET
	 	4) 수정		/members		PUT
	 	5) 삭제		/members/1		DELETE
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
	
	// 경로에 저장된 값을 불러오려면, @PathVariable 사용
	// @PathVariable은 프로젝트에서 적용하지 말고, 따로 공부용으로 사용할 것
	// 페이지의 경우 null을 받았을 때를 대비하여, Optional을 사용하였다.
	@GetMapping(value="/members/page/{page}", produces="application/json")
	public Map<String, Object> getMemberList (@PathVariable (value="page", required=false) Optional<String> opt) {
		int page = Integer.parseInt(opt.orElse("1"));
		return memberService.getMemberList(page);
	}
	
	// 상세
	@GetMapping(value="/members/{memberNo}", produces="application/json")
	public Map<String, Object> getMember (@PathVariable (value="memberNo", required=false) Optional<String> opt) {
		int memberNo = Integer.parseInt(opt.orElse("0"));
		return memberService.getMemberByNo(memberNo);
	}
	
	// 수정
	@PutMapping(value="/members", produces="application/json")
	public Map<String, Object> modifyMember(@RequestBody Map<String, Object> map, HttpServletResponse response) {
		return memberService.modifyMember(map, response);
	}
	
	// 삭제
	@DeleteMapping(value="/members/{memberNoList}", produces="application/json")
	public Map<String, Object> removeMember (@PathVariable String memberNoList) {
		return memberService.removeMemberList(memberNoList);
	}
}
