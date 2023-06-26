package com.java.servlet.service;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.MembersVO;

public interface MypageService {


	List<MembersVO> getAllBoard();
	int getCountAllBoard();
	List<MembersVO> getAllBoardByPage(PageMaker pageMaker);
	
	
}
