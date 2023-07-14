package com.java.servlet.dao;

import java.util.List;



import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.ShelterVO;

public interface ShelterDAO {
	List<ShelterVO> selectShelter(int shelter_no);
	List<ShelterVO> selectAllBoard();
	int seletCountAllBoard();
	List<ShelterVO> selectAllBoardByPage(PageMaker pageMaker);
}
