package com.gdu.app02.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app02.domain.CommentDTO;
import com.gdu.app02.mapper.CommentMapper;
import com.gdu.app02.util.PageUtil;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private PageUtil pageUtil;
	
	@Override
	public Map<String, Object> getCommentCount(int blogNo) {
		Map<String, Object> result = new HashMap<>();	// jackson : 맵을 사용하면 json으로 반환
		result.put("commentCount", commentMapper.selectCommentCount(blogNo));
		return result;
	}
	
	@Override
	public Map<String, Object> addComment(CommentDTO comment) {
		Map<String, Object> result = new HashMap<>();
		
		// (isAdd, true)
		// (isAdd, false)
		result.put("isAdd", commentMapper.insertComment(comment) == 1);
		return result;
	}
	
	@Override
	public Map<String, Object> getCommentList(HttpServletRequest request) {
		int blogNo = Integer.parseInt(request.getParameter("blogNo"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		int commentCount = commentMapper.selectCommentCount(blogNo);
		pageUtil.setPageUtil(page, commentCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("blogNo", blogNo);
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		Map<String, Object> result = new HashMap<>();
		result.put("commentList", commentMapper.selectCommentList(map));
		result.put("pageUtil", pageUtil);
		
		return result;
	}
	
	@Override
	public Map<String, Object> removeComment(int commentNo) {
		Map<String, Object> result = new HashMap<>();
		result.put("isRemove", commentMapper.deleteComment(commentNo) == 1);
		return result;
	}
	
	@Override
	public Map<String, Object> addReply(CommentDTO reply) {
		Map<String, Object> result = new HashMap<>();
		// (isAdd, true)
		// (isAdd, false)
		result.put("isAdd", commentMapper.insertReply(reply) == 1);
		return result;
	}
}
