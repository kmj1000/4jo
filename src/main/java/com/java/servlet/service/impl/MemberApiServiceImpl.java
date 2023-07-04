package com.java.servlet.service.impl;

import com.java.servlet.dao.MemberApiDAO;
import com.java.servlet.dao.impl.MemberApiDAOImpl;
import com.java.servlet.service.MemberApiService;
import com.java.servlet.vo.MembersVO;

public class MemberApiServiceImpl implements MemberApiService {
	private final static MemberApiService instance = new MemberApiServiceImpl();
	private final MemberApiDAO dao = MemberApiDAOImpl.getInstance();
	private MemberApiServiceImpl() {
		
	}
	public static MemberApiService getInstance() {
		return instance;
	}
	
	@Override
	public int modifyPwd(MembersVO vo) {
		// TODO Auto-generated method stub
		return dao.updatePwd(vo);
	}

	@Override
	public int modifyPhone(MembersVO vo) {
		// TODO Auto-generated method stub
		return dao.updatePhone(vo);
	}

	@Override
	public int removeMember(String email) {
		// TODO Auto-generated method stub
		return dao.deleteMember(email);
	}

}
