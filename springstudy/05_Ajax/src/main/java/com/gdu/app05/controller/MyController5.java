package com.gdu.app05.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.GalleryService;

@Controller
public class MyController5 {
	
	/*---------------------------------------------------------------
	  반환값이 없는 void의 경우~!
	  getMapping("value")를 반환값으로 인식한다. > gallery.jsp
	----------------------------------------------------------------- */
	@GetMapping("gallery")
	public void gallery() {
		
	}
	
	
	
	@Autowired
	private GalleryService galleryService;
	
	
	/* -------------------------------------------------------------------------------------
	  ■ 이미지 파일을 절대경로로 불어오는 기초 작업 ■
	  
	  1. .jsp 파일에서 스크립트를 작성한다.
	  	: 파라미터 변수들을 작업해준다.
	  	(이 경우, path=?&filename=? 을 가지므로, String path 와 String filename 을 준비!)
	  
	  2. 인터페이스를 생성한다.
	  	: 이미지를 받을 정보를 어떤 형식으로 받을지 타입을 정한다.
	  	(이 경우, ResponseEntity를 이용해 byte[] 배열로 이미지를 받음!
	  	          ▷ 반환값을 받기 위해 @ResponseBody 를 반드시 작성한다!)
	  
	  3. 임플리먼트를 생성한다.
	  	: 따로 작성할 필요없이 생성만 해놓는다!
	  	
	  4. SpringBeanCongfig 에 @Bean 작성
	  
	  5. Controller에 field 생성. (@Autowired)
	
	  6. Controller에 코드 작업 시작 (끝)
	---------------------------------------------------------------------------------------- */
	@ResponseBody
	@GetMapping("image/display")
	public ResponseEntity<byte[]> display(@RequestParam String path, @RequestParam String filename) {
		
		File file = new File(path, filename);
		
		ResponseEntity<byte[]> entity = null;
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			//* contentType을 확인하는 코드 : Files.probeContentType(file.toPath())
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", contentType);
			//* 이미지 타입임을 MIME-TYPE으로 알려준다. (image/jpeg)
			//* 여기서는 알아서 콘텐트타입을 불러오는 코드로 작성되었다.
			
			entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			//* 이미지 파일을 byte[]로 변환 : FileCopyUtils.copyToByteArray(file)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
