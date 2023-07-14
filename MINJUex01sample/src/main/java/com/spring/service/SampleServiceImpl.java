package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.domain.sDTO;
import com.spring.mapper.SampleMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	private final SampleMapper mapper;
	@Override
	public List<sDTO> read() {
		List<sDTO> list=mapper.selectSample();
		return list;
	}

	@Override
	public int modifySample(sDTO sdto) {
		int result= mapper.updateSample(sdto);
		return result;
	}

	@Override
	public int removeSample(sDTO sdto) {
		int result = mapper.deleteSample(sdto);
		return result;
	}

	@Override
	public int createSample(sDTO sdto) {
		int result=mapper.insertSample(sdto);
		return result;
	}

}
