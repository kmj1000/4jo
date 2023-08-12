package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.domain.EmpDTO;
import com.spring.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpMapper mapper;
	@Override
	public List<EmpDTO> read() {
		List<EmpDTO> emplist = mapper.selectEmp(); 
		return emplist;
	}

	@Override
	public int createEmp(EmpDTO dto) {
		int result = mapper.insertEmp(dto);
		return result;
	}

	@Override
	public int modifyEmp(EmpDTO dto) {
		int result = mapper.updateEmp(dto);
		return result;
	}

	@Override
	public int removeEmp(EmpDTO dto) {
		int result = mapper.deleteEmp(dto);
		return result;
	}

}
