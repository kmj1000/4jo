package com.spring.mapper;

import java.util.List;

import com.spring.domain.sDTO;

public interface SampleMapper {
	List<sDTO> selectSample(); 
	int updateSample(sDTO sdto);
	int	deleteSample(sDTO sdto);
	int insertSample(sDTO sdto);
}
