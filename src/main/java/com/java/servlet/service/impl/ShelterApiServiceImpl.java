package com.java.servlet.service.impl;

import com.java.servlet.dao.ShelterApiDAO;

import com.java.servlet.dao.impl.ShelterApiDAOImpl;
import com.java.servlet.service.ShelterApiService;

import com.java.servlet.vo.ShelterVO;

public class ShelterApiServiceImpl implements ShelterApiService {
	
	private static final ShelterApiService instance = new ShelterApiServiceImpl();
	private final ShelterApiDAO dao = ShelterApiDAOImpl.getInstance();
	private ShelterApiServiceImpl() {
		
	}
	public static ShelterApiService getInstance() {
		return instance;
	}
	@Override
	public int registerShelter(ShelterVO vo) {
		
		return dao.insertShelterData(vo);
	}

	@Override
	public int removeShelter(int shelter_no) {
		
		return dao.deleteShelterData(shelter_no);
	}

}
