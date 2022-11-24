package com.gdu.app15.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app15.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/blog/list")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);	// model에 request를 저장하기
		blogService.getBlogList(model);			// model만 넘겼지만, 이미 model에는 request가 들어있다.
		//* 이렇게하면 model에 필요한 매개변수를 전부 전달할 수 있다.
		//* 서비스 1개당 메소드 1개로 인터페이스를 통일할 때, 이 방법을 사용한다.
		return "blog/list";
	}
	
	@GetMapping("/blog/write")
	public String write() {
		return "blog/write";
	}
	
	@PostMapping("/blog/add")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		blogService.saveBlog(request, response);
	}
	
	@ResponseBody
	@PostMapping(value="/blog/uploadImage", produces="application/json")
	public Map<String, Object> uploadImage(MultipartHttpServletRequest multipartRequest) {
		return blogService.saveSummernoteImage(multipartRequest);
	}
	
	@GetMapping("/blog/increse/hit")
	public String increseHit(@RequestParam (value="blogNo", required=false, defaultValue="0") int blogNo) {
		int result = blogService.increseBlogHit(blogNo);
		if (result > 0) {	// 조회수 증가에 성공하면 상세보기로 이동
			return "redirect:/blog/detail?blogNo=" + blogNo;
		} else {
			return "redirect:/blog/list";
		}
	}
	
	@GetMapping("/blog/detail")
	public String detail(@RequestParam (value="blogNo", required=false, defaultValue="0") int blogNo, Model model) {
		model.addAttribute("blog", blogService.getBlogByNo(blogNo));
		return "blog/detail";
	}
	
	@PostMapping("/blog/edit")
	public String edit(int blogNo, Model model) {
		model.addAttribute("blog", blogService.getBlogByNo(blogNo));
		return "blog/edit";
	}
	
	@PostMapping("/blog/modify")
	public String modify(HttpServletRequest request, HttpServletResponse response) {
		blogService.modifyBlog(request, response);	// 수정 후 상세보기로
		return "redirect:/blog/detail?blogNo=" + request.getParameter("blogNo");
	}
	
	@PostMapping("/blog/remove")
	public String remove(HttpServletRequest request, HttpServletResponse response) {
		blogService.removeBlog(request, response);	// 수정 후 상세보기로
		return "redirect:/blog/list";
	}
}
