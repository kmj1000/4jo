package com.java.servlet.service.impl;

import com.java.servlet.dao.CommunityCDAO;

import com.java.servlet.dao.impl.CommunityCDAOImpl;

import com.java.servlet.service.CommunityCService;

import com.java.servlet.vo.CommunityVO;

public class CommunityCServiceImpl implements CommunityCService {
	private static final CommunityCService instance = new CommunityCServiceImpl();
	private final CommunityCDAO dao = CommunityCDAOImpl.getInstance();

	private CommunityCServiceImpl() {
	}
	public static CommunityCService getInstance() {
		   return instance;
	}
	
	
	
	
	@Override
	public CommunityVO getCommunity(int c_no) {
		// TODO Auto-generated method stub
		return dao.selectCommunity(c_no);
	}
}
