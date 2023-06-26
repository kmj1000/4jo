package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.impl.CommunityDAOImpl;
import com.java.servlet.service.CommunityService;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public class CommunityServiceImpl implements CommunityService {
	private static final CommunityService instance = new CommunityServiceImpl();
	private final CommunityDAO dao = CommunityDAOImpl.getInstance();

	private CommunityServiceImpl() {
	}
	public static CommunityService getInstance() {
		   return instance;
	}
	@Override
	public CommunityVO getCommunity(int c_no) {
		// TODO Auto-generated method stub
		return dao.selectCommunity(c_no);
	}
	
	@Override
	public List<CommunityVO> getAllCommunity() {
		return dao.selectAllCommunity();
	}
	
	@Override
	public int getCountAllCommunity() {
		return dao.selectCountAllCommunity();
	}
	@Override
	public List<CommunityVO> getAllCommunityByPage(PageMaker pageMaker) {
		
		return dao.selectAllCommunityByPage(pageMaker);
	}


}
