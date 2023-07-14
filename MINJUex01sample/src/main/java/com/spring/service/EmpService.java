package com.spring.service;

import java.util.List;

import com.spring.domain.EmpDTO;

public interface EmpService {
	List<EmpDTO> read();
	int createEmp(EmpDTO dto);
	int modifyEmp(EmpDTO dto);
	int removeEmp(EmpDTO dto);
}
