package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.vo.MembersVO;
import com.java.servlet.dao.MembersDAO;
import com.java.servlet.dao.impl.MembersDAOImpl;
import com.java.servlet.service.MembersService;



public class MembersServiceImpl implements MembersService {

	private MembersDAO dao = new MembersDAOImpl();
	
	@Override
	public List<MembersVO> getMembersList() {
		return dao.selectMembersList();
	}

}
