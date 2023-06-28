package com.java.servlet.service.impl;

import com.java.servlet.dao.FindEmailDAO;
import com.java.servlet.dao.FindPwdDAO;
import com.java.servlet.dao.impl.FindEmailDAOImpl;
import com.java.servlet.dao.impl.FindPwdDAOImpl;
import com.java.servlet.service.FindEmailService;
import com.java.servlet.service.FindPwdService;
import com.java.servlet.vo.MembersVO;

public class FindEmailServiceImpl implements FindEmailService {

	private final FindEmailDAO dao = FindEmailDAOImpl.getInstance();
	
	private static final FindEmailService instance = new FindEmailServiceImpl();
	
	private FindEmailServiceImpl() {}
	
	public static FindEmailService getInstance() {
		return instance;
	}

	@Override
	public String getFindEmail(MembersVO vo) {
		return dao.selectFindEmail(vo);
	}
}
