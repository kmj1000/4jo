package com.spring.service;

import java.util.List;

import com.spring.domain.Emp2DTO;

public interface Emp2Service {
	List<Emp2DTO> read();
	int createEmp2(Emp2DTO dto2);
	int modifyEmp2(Emp2DTO dto2);
	int removeEmp2(Emp2DTO dto2);
	
}
