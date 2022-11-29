package com.gdu.app15.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gdu.app15.domain.CommentDTO;

public interface CommentService {
	
	public Map<String, Object> getCommentCount(int blogNo);
	public Map<String, Object> addComment(CommentDTO comment);
	public Map<String, Object> getCommentList(HttpServletRequest request);	// begin, end값과 blogDTO를 넘기기 위해, request에서 꺼내 쓰기 
	public Map<String, Object> removeComment(int commentNo);
	public Map<String, Object> addReply(CommentDTO reply);
}
