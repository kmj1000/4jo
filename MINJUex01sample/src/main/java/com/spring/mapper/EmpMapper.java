package com.spring.mapper;

import java.util.List;

import com.spring.domain.EmpDTO;

public interface EmpMapper {
	List<EmpDTO> selectEmp();
	int insertEmp(EmpDTO dto);
	int updateEmp(EmpDTO dto);
	int deleteEmp(EmpDTO dto);
}
