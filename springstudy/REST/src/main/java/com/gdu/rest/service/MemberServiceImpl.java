package com.gdu.rest.service;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.mapper.MemberMapper;
import com.gdu.rest.util.PageUtil;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response) {
		
		try {
			Map<String, Object> result = new HashMap<>();
			result.put("insertResult", memberMapper.insertMamber(member));
			return result;
		} catch (DuplicateKeyException e) {	// 아이디 중복
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(501);	// 응답 코드 501
				out.println("이미 사용 중인 아이디입니다.");	// 응답 메시지
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (DataIntegrityViolationException e) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(502);	// 응답 코드 502
				out.println("필수 정보가 누락되었습니다.");	// 응답 메시지
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setStatus(503);	// 응답 코드 503
				out.println("입력정보를 확인하세요.");	// 응답 메시지
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// 예외 이유 출력 (* 정확하게는 예외 클래스 이름 출력 oooException)
		//System.out.println(e.getClass().getName());
		
		return null;
	}
	
	@Override
	public Map<String, Object> getMemberList(int page) {
		
		int totalRecord = memberMapper.selectMemberCount();
		pageUtil.setPageUtil(page, totalRecord);
		
		// 조회할 때 사용할 Map
		Map<String, Object> map = new HashMap<>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		Map<String, Object> result = new HashMap<>();
		result.put("memberList", memberMapper.selectMemberListByMap(map));
		result.put("pageUtil", pageUtil);
		
		return result;
	}
	
	@Override
	public Map<String, Object> getMemberByNo(int memberNo) {
		Map<String, Object> result = new HashMap<>();
		result.put("member", memberMapper.selectMemberByNo(memberNo));
		return result;
	}
	
	@Override
	public Map<String, Object> modifyMember(Map<String, Object> map, HttpServletResponse response) {
		
		try {
			Map<String, Object> result = new HashMap<>();
			result.put("updateResult", memberMapper.updateMember(map));
			return result;
		} catch (DataIntegrityViolationException e) {
			try {
				// plain = 순수 텍스트
				response.setContentType("text/plain; charset=UTF-8");
				// PrintWriter를 쓰는 이유? response 가 getWriter()를 반환하기 때문에.
				PrintWriter out = response.getWriter();
				response.setStatus(501);	// 응답코드 501 -> 임의로 지정한 숫자이다.
				out.println("필수 정보가 누락되었습니다.");	// DataIntegrityViolationException 발생 이유
				out.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Map<String, Object> removeMemberList(String memberNoList) {
		// arrats.asList : ArrayList 초기화 할 때 사용
		// split 에서는 Regex 는 정규식을 의미한다.
		List<String> list = Arrays.asList(memberNoList.split("\\,"));
		Map<String, Object> result = new HashMap<>();
		// 3,1 이 전달되었을 때 , 2개의 정보가 삭제되므로 deleteResult의 값은 2가 된다.
		result.put("deleteResult", memberMapper.deleteMemberList(list));
		return result;
	}
}
