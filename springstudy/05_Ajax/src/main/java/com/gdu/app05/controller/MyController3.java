package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.MovieService;

@Controller
public class MyController3 {
	
	// * ★ 컨트롤러는 자주 호출되므로, 최대한 Simple하게 작성!!!
	
	@GetMapping("movie")
	public String movie() {
		return "movie";
	}
	
	// field
	@Autowired	// Container(root-context.xml)에 저장된 bean을 가져오시오.
	private MovieService movieService;
	
	
	@ResponseBody
	@GetMapping(value = "/movie/boxOfficeList"
			  , produces = MediaType.APPLICATION_JSON_VALUE)
	public String boxOfficeList(@RequestParam(value="targetDt") String targetDt) {
		return movieService.getBoxOffice(targetDt);
	}
	
}
