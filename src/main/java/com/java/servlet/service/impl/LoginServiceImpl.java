package com.java.servlet.service.impl;

import com.java.servlet.dao.LoginDAO;
import com.java.servlet.dao.impl.LoginDAOImpl;
import com.java.servlet.service.LoginService;
import com.java.servlet.vo.MembersVO;

public class LoginServiceImpl implements LoginService {
	
	private final LoginDAO dao = LoginDAOImpl.getInstance();
	
	private static final LoginService instance = new LoginServiceImpl();
	
	private LoginServiceImpl() {}
	
	public static LoginService getInstance() {
		return instance;
	}
	
	@Override
	public int getCountMember(MembersVO vo) {
		return dao.selectCountMember(vo);
		
	}

	@Override
	public void getMembersByIdAndPwd(MembersVO vo) {
		dao.selectMembersByIdAndPwd(vo);
	}

	
}
