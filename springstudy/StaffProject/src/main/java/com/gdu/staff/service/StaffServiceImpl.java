package com.gdu.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public List<StaffDTO> getStaffList() {
		return staffMapper.selectStaffList();
	}
	
	@Override
	public ResponseEntity<String> addStaff(StaffDTO staff) {
		
		try {
			// staff에 salary 넣기 : 기획부 1000, 개발부 2000, 영업부 3000, 나머지 4000
			switch(staff.dept) {
			case "기획부" : staff.salary = 5000; break;
			case "개발부" : staff.salary = 6000; break;
			case "영업부" : staff.salary = 7000; break;
			default : staff.salary = 4000;
			}
			staffMapper.insertStaff(staff);
			return new ResponseEntity<String>("사원등록이 성공했습니다.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("사원등록이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@Override
	public StaffDTO getOneStaff(String query) {
		try {
			return staffMapper.selectStaffBySno(query);
		} catch (Exception e) {
			return null;
		}
		
	}
	
		
}
