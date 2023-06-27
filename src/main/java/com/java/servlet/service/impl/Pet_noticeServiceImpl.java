package com.java.servlet.service.impl;

import java.util.List;



import com.java.servlet.dao.Pet_noticeDAO;
import com.java.servlet.dao.impl.Pet_noticeDAOImpl;
import com.java.servlet.service.Pet_noticeService;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Pet_noticeVO;


public class Pet_noticeServiceImpl implements Pet_noticeService {

	private static final Pet_noticeService instance = new Pet_noticeServiceImpl();
	private final Pet_noticeDAO dao = Pet_noticeDAOImpl.getInstance();
	
	private Pet_noticeServiceImpl() { }
	
	public static Pet_noticeService getInstance() {
		return instance;
	}

	@Override
	public List<Pet_noticeVO> getAllBoard() {
		return dao.selectAllBoard();
	}
	

	@Override
	public int getCountAllBoard() {
		return dao.seletCountAllBoard();
	}
	
	@Override
	public List<Pet_noticeVO> getAllBoardByPage(PageMaker pageMaker) {
		return dao.selectAllBoardByPage(pageMaker);
	}
	
	
	
	
}