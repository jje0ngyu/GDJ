package com.gdu.app11.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpService {
	public void findAllEmployees(HttpServletRequest request, Model model);
	//* request/response/session/model을 직접 선언하는 것은 Controller에서 !
	//* sevice에서는 controller에서 선언된 것을 받아오는 것이다.
}
