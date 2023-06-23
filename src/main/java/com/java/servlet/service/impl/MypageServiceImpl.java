package com.java.servlet.service.impl;

import com.java.servlet.dao.MypageDAO;
import com.java.servlet.dao.impl.MypageDAOImpl;
import com.java.servlet.service.MypageService;
import com.java.servlet.vo.MembersVO;

public class MypageServiceImpl implements MypageService {
	
	private static final MypageService instance = new MypageServiceImpl();
	private final MypageDAO dao = MypageDAOImpl.getInstance();
	
	private MypageServiceImpl() {}
	
	public static MypageService getInstance() {
		return instance;
	}
	
	@Override
	public MembersVO getMypage(String nickname) {
		return dao.selectMypage(nickname);
	}
}
