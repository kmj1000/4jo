package com.java.servlet.dao;

import java.util.List;



import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Favorite_S_VO;

public interface Favorite_S_DAO {
	List<Favorite_S_VO> selectShelterBoard();
	int seletCountShelterBoard();
	List<Favorite_S_VO> selectShelterBoardByPage(PageMaker pageMaker);
	

}
