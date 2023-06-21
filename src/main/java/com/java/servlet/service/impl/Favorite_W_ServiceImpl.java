package com.java.servlet.service.impl;

import com.java.servlet.dao.Favorite_W_DAO;
import com.java.servlet.dao.impl.Favorite_W_DAOImpl;
import com.java.servlet.service.Favorite_W_Service;
import com.java.servlet.vo.Favorite_W_VO;

public class Favorite_W_ServiceImpl implements Favorite_W_Service {
	
	private static final Favorite_W_Service instance = new Favorite_W_ServiceImpl();
	private final Favorite_W_DAO dao = Favorite_W_DAOImpl.getInstance();
	private Favorite_W_ServiceImpl() {
		
	}
	public static Favorite_W_Service getInstance() {
		return instance;
	}
	@Override
	public Favorite_W_VO getFavorite_with_pet(int favortite_with_pet_no) {
		
		return dao.selectedFavorite_W(favortite_with_pet_no);
	}

}
