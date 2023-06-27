package com.java.servlet.service.impl;

import java.util.List;




import com.java.servlet.dao.With_petDAO;
import com.java.servlet.dao.impl.With_petDAOImpl;
import com.java.servlet.service.With_petService;
import com.java.servlet.util.PageMaker;



import com.java.servlet.vo.With_petVO;

public class With_petServiceImpl implements With_petService {

	private static final With_petService instance = new With_petServiceImpl();
	private final With_petDAO dao = With_petDAOImpl.getInstance();
	
	private With_petServiceImpl() { }
	
	public static With_petService getInstance() {
		return instance;
	}

	@Override
	public List<With_petVO> getAllBoard() {
		return dao.selectAllBoard();
	}
	

	@Override
	public int getCountAllBoard() {
		return dao.seletCountAllBoard();
	}
	
	@Override
	public List<With_petVO> getAllBoardByPage(PageMaker pageMaker) {
		return dao.selectAllBoardByPage(pageMaker);
	}
	
	
	
	
}