package com.java.servlet.dao;

import java.util.List;


import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.With_petVO;

public interface With_petDAO {
	List<With_petVO> selectWith_pet(int with_pet_no);
	List<With_petVO> selectAllBoard();
	int seletCountAllBoard();
	List<With_petVO> selectAllBoardByPage(PageMaker pageMaker);
}
