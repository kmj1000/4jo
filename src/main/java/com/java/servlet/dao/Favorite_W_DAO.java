package com.java.servlet.dao;

import com.java.servlet.vo.Favorite_W_VO;

public interface Favorite_W_DAO {
	Favorite_W_VO selectFavorite_with_pet(int favorite_with_pet_no);
}
