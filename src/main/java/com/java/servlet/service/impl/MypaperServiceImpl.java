package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.MypaperDAO;
import com.java.servlet.dao.impl.CommunityDAOImpl;
import com.java.servlet.dao.impl.MypaperDAOImpl;
import com.java.servlet.service.CommunityService;
import com.java.servlet.service.MypaperService;
import com.java.servlet.vo.CommunityVO;

public class MypaperServiceImpl implements MypaperService {
	private static final MypaperService instance = new MypaperServiceImpl();
	private final MypaperDAO dao = MypaperDAOImpl.getInstance();

	private MypaperServiceImpl() {
	}
	public static MypaperService getInstance() {
		   return instance;
	}
	@Override
	public List<CommunityVO> getMypaper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommunityVO> getMypaper(String nickname) {
		
		return dao.selectMypaper(nickname);
	}

}
