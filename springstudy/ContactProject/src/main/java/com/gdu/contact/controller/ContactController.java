package com.gdu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	
	// 목록보기
	@GetMapping({"/", "contact/list"})
	public String list(Model model) {
		contactService.findAllContacts(model);
		return "contact/list";
	}
	
	// 연락처 추가하기
	@GetMapping("contact/write")
	public String write() {
		return "contact/write";
	}
	
	// 연락처 등록하기
	@PostMapping("contact/add")
	public String add(ContactDTO contact) {
		return "redirect:/contact/list";
	}
	
	// 연락처 삭제하기
	
}
