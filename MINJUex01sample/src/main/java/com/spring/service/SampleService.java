package com.spring.service;

import java.util.List;

import com.spring.domain.sDTO;

public interface SampleService {
	List<sDTO> read();
	int modifySample(sDTO sdto);
	int removeSample(sDTO sdto);
	int createSample(sDTO sdto);
	
}
