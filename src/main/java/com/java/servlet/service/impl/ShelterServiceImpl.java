package com.java.servlet.service.impl;

import java.util.List;




import com.java.servlet.dao.ShelterDAO;
import com.java.servlet.dao.impl.ShelterDAOImpl;
import com.java.servlet.service.ShelterService;
import com.java.servlet.util.PageMaker;


import com.java.servlet.vo.ShelterVO;

public class ShelterServiceImpl implements ShelterService {

	private static final ShelterService instance = new ShelterServiceImpl();
	private final ShelterDAO dao = ShelterDAOImpl.getInstance();
	
	private ShelterServiceImpl() { }
	
	public static ShelterService getInstance() {
		return instance;
	}

	@Override
	public List<ShelterVO> getAllBoard() {
		return dao.selectAllBoard();
	}
	

	@Override
	public int getCountAllBoard() {
		return dao.seletCountAllBoard();
	}
	
	@Override
	public List<ShelterVO> getAllBoardByPage(PageMaker pageMaker) {
		return dao.selectAllBoardByPage(pageMaker);
	}
	
	
	
	
}