package com.java.servlet.service;

import java.util.List;





import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Favorite_W_VO;

public interface Favorite_W_Service {


	
	List<Favorite_W_VO> getWithPetBoard();
	int getCountWithPetBoard();
	List<Favorite_W_VO> getWithPetBoardByPage(PageMaker pageMaker);
	
}
