package com.java.servlet.service;

import java.util.List;


import com.java.servlet.util.PageMaker;


import com.java.servlet.vo.ShelterVO;

public interface ShelterService {


	List<ShelterVO> getShelter(int shelter_no);
	List<ShelterVO> getAllBoard();
	int getCountAllBoard();
	List<ShelterVO> getAllBoardByPage(PageMaker pageMaker);
	
}