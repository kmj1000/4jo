package com.java.servlet.service;

import java.util.List;


import com.java.servlet.util.PageMaker;


import com.java.servlet.vo.With_petVO;

public interface With_petService {


	
	List<With_petVO> getAllBoard();
	int getCountAllBoard();
	List<With_petVO> getAllBoardByPage(PageMaker pageMaker);
	
}