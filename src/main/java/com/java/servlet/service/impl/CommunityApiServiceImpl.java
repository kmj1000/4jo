package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.dao.CommunityApiDAO;
import com.java.servlet.dao.impl.CommunityApiDAOImpl;
import com.java.servlet.service.CommunityApiService;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public class CommunityApiServiceImpl implements CommunityApiService {
	private static final CommunityApiService instance = new CommunityApiServiceImpl();
	private final CommunityApiDAO dao = CommunityApiDAOImpl.getInstance();

	private CommunityApiServiceImpl() {
	}
	public static CommunityApiService getInstance() {
		   return instance;
	}
	
	@Override
	public int registerCommunity(CommunityVO vo) {
		return dao.insertCommunity(vo);
	}
	@Override
	public int modifyCommunity(CommunityVO vo) {
		return dao.updateCommunity(vo);
	}
	@Override
	public int removeCommunity(int c_no) {
		return dao.deleteCommunity(c_no);
	}

	


}
