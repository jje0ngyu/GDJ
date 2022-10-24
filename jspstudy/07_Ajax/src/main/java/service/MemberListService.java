package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.MemberDao;

public class MemberListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//* 모든 서비스를 JSON으로 만들어서 response하기
		
		// 응답 데이터 형식 (JSON)
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 만들기
		/*
		 	{
		 		"count"   : 3,
		 		"members" : [
		 			{
		 				"memberNo" : 1,
		 				"id"       : "user1",
		 				"name"	   : "회원1",
		 				"gender"   : "F",
		 				"grade"    : "gold",
		 				"address"  : "jeju"
		 			},
		 			{
		 				"memberNo" : 2,
		 				"id"       : "user2",
		 				"name"	   : "회원2",
		 				"gender"   : "M",
		 				"grade"    : "silver",
		 				"address"  : "seoul"
		 			},
		 			{
		 				"memberNo" : 3,
		 				"id"       : "user3",
		 				"name"	   : "회원3",
		 				"gender"   : "F",
		 				"grade"    : "bronze",
		 				"address"  : "yeosu"
		 			}
		 		]
		 	}
		*/
		JSONObject obj = new JSONObject();
		obj.put("count", MemberDao.getInstance().selectAllMembersCount());
		obj.put("members", MemberDao.getInstance().selectAllMembers());	//* 라이브러리를 사용하요 손쉽게 해결. (List타입을 자동으로 JSONArray로 변환)
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());	// JSON 문자열 응답
		out.close();
	}

}
