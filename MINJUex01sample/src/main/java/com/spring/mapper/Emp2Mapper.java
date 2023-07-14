package com.spring.mapper;

import java.util.List;

import com.spring.domain.Emp2DTO;

public interface Emp2Mapper {
	List<Emp2DTO> selectEmp2();
	int insertEmp2(Emp2DTO dto2);
	int updateEmp2(Emp2DTO dto2);
	int deleteEmp2(Emp2DTO dto2);
}
