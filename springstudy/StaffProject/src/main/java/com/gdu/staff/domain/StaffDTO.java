package com.gdu.staff.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {

	public String query;
	public String name;
	public String dept;
	public int salary;
	
	
}
