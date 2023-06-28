package com.java.servlet.service.impl;

import com.java.servlet.dao.With_petApiDAO;

import com.java.servlet.dao.impl.With_petApiDAOImpl;
import com.java.servlet.service.With_petApiService;


import com.java.servlet.vo.Favorite_W_VO;
import com.java.servlet.vo.With_petVO;

public class With_petApiServiceImpl implements With_petApiService {
	private static final With_petApiService instance = new With_petApiServiceImpl();
	private final With_petApiDAO dao = With_petApiDAOImpl.getInstance();
	private With_petApiServiceImpl() {
		
	}
	public static With_petApiService getInstance() {
		return instance;
	}
	@Override
	public int registerWith_pet(With_petVO vo) {
		
		return dao.insertWith_petData(vo);
	}

	@Override
	public int removeWith_pet(int with_pet_no) {
		
		return dao.deleteWith_petData(with_pet_no);
	}
	
	

}