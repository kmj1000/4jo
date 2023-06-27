package com.java.servlet.service.impl;

import com.java.servlet.dao.FindPwdDAO;
import com.java.servlet.dao.LoginDAO;
import com.java.servlet.dao.impl.FindPwdDAOImpl;
import com.java.servlet.dao.impl.LoginDAOImpl;
import com.java.servlet.service.FindService;
import com.java.servlet.service.JoinService;
import com.java.servlet.service.LoginService;
import com.java.servlet.vo.MembersVO;

public class FindPwdServiceImpl implements FindService {

	private final FindPwdDAO dao = FindPwdDAOImpl.getInstance();
	
	private static final FindService instance = new FindPwdServiceImpl();
	
	private FindPwdServiceImpl() {}
	
	public static FindService getInstance() {
		return instance;
	}

	@Override
	public String getFindPwd(MembersVO vo) {
		// TODO Auto-generated method stub
		return dao.selectFindPwd(vo);
	}
	
}
