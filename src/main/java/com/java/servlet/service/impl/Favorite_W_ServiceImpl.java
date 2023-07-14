package com.java.servlet.service.impl;

import java.util.List;



import com.java.servlet.dao.Favorite_W_DAO;
import com.java.servlet.dao.impl.Favorite_W_DAOImpl;
import com.java.servlet.service.Favorite_W_Service;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_W_VO;

public class Favorite_W_ServiceImpl implements Favorite_W_Service {

	private static final Favorite_W_Service instance = new Favorite_W_ServiceImpl();
	private final Favorite_W_DAO dao = Favorite_W_DAOImpl.getInstance();
	
	private Favorite_W_ServiceImpl() { }
	
	public static Favorite_W_Service getInstance() {
		return instance;
	}

	
	
	@Override
	public List<Favorite_W_VO> getWithPetBoard() {
		return dao.selectWithPetBoard();
	}
	@Override
	public int getCountWithPetBoard() {
		return dao.seletCountWithPetBoard();
	}
	
	@Override
	public List<Favorite_W_VO> getWithPetBoardByPage(PageMaker pageMaker) {
		return dao.selectWithPetBoardByPage(pageMaker);
	}
	
}
