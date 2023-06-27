package com.java.servlet.service;

import java.util.List;



import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_S_VO;

public interface Favorite_S_Service {


	List<Favorite_S_VO> getShelterBoard();
	int getCountShelterBoard();
	List<Favorite_S_VO> getShelterBoardByPage(PageMaker pageMaker);
	
	
}
