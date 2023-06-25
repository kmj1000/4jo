package com.java.servlet.service.impl;

import com.java.servlet.dao.Favorite_S_DAO;


import com.java.servlet.dao.impl.Favorite_S_DAOImpl;
import com.java.servlet.service.Favorite_S_Service;
import com.java.servlet.vo.Favorite_S_VO;

public class Favorite_S_ServiceImpl implements Favorite_S_Service {
	private static final Favorite_S_Service instance = new Favorite_S_ServiceImpl();
	private final Favorite_S_DAO dao = Favorite_S_DAOImpl.getInstance();
	private Favorite_S_ServiceImpl() {
		
	}
	public static Favorite_S_Service getInstance() {
		return instance;
	}
	@Override
	public Favorite_S_VO getFavorite_shelter(int favortite_shelter_no) {
		return dao.selectFavorite_shelter(favortite_shelter_no);
	}

}
