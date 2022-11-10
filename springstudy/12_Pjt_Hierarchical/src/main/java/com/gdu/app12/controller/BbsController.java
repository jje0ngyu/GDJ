package com.gdu.app12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app12.service.BbsService;
import com.gdu.app12.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class BbsController {

	// 필드가 2개 이상일 땐 @Autowired 말고 @AllArgsConstructor 사용하는 것이 좋다. (오토와이어드는 생성자마다 붙여줘야함)
	private BbsService bbsService;
	private PageUtil pageUtil;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
}
