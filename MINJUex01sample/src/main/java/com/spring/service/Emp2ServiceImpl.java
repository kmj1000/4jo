package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.domain.Emp2DTO;
import com.spring.mapper.Emp2Mapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Emp2ServiceImpl implements Emp2Service {
	private final Emp2Mapper mapper;
	@Override
	public List<Emp2DTO> read() {
		List<Emp2DTO> emp2list = mapper.selectEmp2();
		return emp2list;
	}

	@Override
	public int createEmp2(Emp2DTO dto2) {
		int result = mapper.insertEmp2(dto2);
		return result;
	}

	@Override
	public int modifyEmp2(Emp2DTO dto2) {
		int result = mapper.updateEmp2(dto2);
		return result;
	}

	@Override
	public int removeEmp2(Emp2DTO dto2) {
		int result = mapper.deleteEmp2(dto2);
		return result;
	}

}
