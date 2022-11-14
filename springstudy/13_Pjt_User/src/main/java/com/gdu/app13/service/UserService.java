package com.gdu.app13.service;

import java.util.Map;

public interface UserService {
	// map을 반환하면 jackson이 JSON으로 잘 반환해준다 !
	public Map<String, Object> isReduceId(String id);
	public Map<String, Object> isReduceEmail(String email);
	public Map<String, Object> sendAuthCode(String email);
}
