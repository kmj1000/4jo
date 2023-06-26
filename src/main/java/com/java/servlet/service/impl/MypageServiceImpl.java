package com.java.servlet.service.impl;

import java.util.List;



import com.java.servlet.dao.MypageDAO;
import com.java.servlet.dao.impl.MypageDAOImpl;
import com.java.servlet.service.MypageService;
import com.java.servlet.util.PageMaker;


import com.java.servlet.vo.MembersVO;

public class MypageServiceImpl implements MypageService {

	private static final MypageService instance = new MypageServiceImpl();
	private final MypageDAO dao = MypageDAOImpl.getInstance();
	
	private MypageServiceImpl() { }
	
	public static MypageService getInstance() {
		return instance;
	}

	@Override
	public List<MembersVO> getAllBoard() {
		return dao.selectAllBoard();
	}
	

	@Override
	public int getCountAllBoard() {
		return dao.seletCountAllBoard();
	}
	
	@Override
	public List<MembersVO> getAllBoardByPage(PageMaker pageMaker) {
		return dao.selectAllBoardByPage(pageMaker);
	}
	
	
	
	
}