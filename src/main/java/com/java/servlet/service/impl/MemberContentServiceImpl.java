package com.java.servlet.service.impl;

import com.java.servlet.dao.MemberContentDAO;
import com.java.servlet.dao.impl.MemberContentDAOImpl;
import com.java.servlet.service.MemberContentService;
import com.java.servlet.vo.MembersVO;

public class MemberContentServiceImpl implements MemberContentService {
	private final static MemberContentService instance = new MemberContentServiceImpl();
	private final MemberContentDAO dao = MemberContentDAOImpl.getInstance();
	private MemberContentServiceImpl() {
		
	}
	public static MemberContentService getInstance() { 
		return instance;
	}
	
	@Override
	public MembersVO getMember(String email) {
		
		return dao.selectMember(email);
	}

	
	
	
}
