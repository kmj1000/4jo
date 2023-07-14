package com.java.servlet.service.impl;

import java.util.List;




import com.java.servlet.dao.Favorite_S_DAO;
import com.java.servlet.dao.impl.Favorite_S_DAOImpl;
import com.java.servlet.service.Favorite_S_Service;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Favorite_S_VO;

public class Favorite_S_ServiceImpl implements Favorite_S_Service {

	private static final Favorite_S_Service instance = new Favorite_S_ServiceImpl();
	private final Favorite_S_DAO dao = Favorite_S_DAOImpl.getInstance();
	
	private Favorite_S_ServiceImpl() { }
	
	public static Favorite_S_Service getInstance() {
		return instance;
	}

	@Override
	public List<Favorite_S_VO> getShelterBoard() {
		return dao.selectShelterBoard();
	}
	

	@Override
	public int getCountShelterBoard() {
		return dao.seletCountShelterBoard();
	}
	
	@Override
	public List<Favorite_S_VO> getShelterBoardByPage(PageMaker pageMaker) {
		return dao.selectShelterBoardByPage(pageMaker);
	}
	
	
	
	
}
