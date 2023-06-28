package com.java.servlet.service;

import java.util.List;


import com.java.servlet.util.PageMaker;


import com.java.servlet.vo.Pet_noticeVO;

public interface Pet_noticeService {


	List<Pet_noticeVO> getPet_notice(int pet_notice_no);
	List<Pet_noticeVO> getAllBoard();
	int getCountAllBoard();
	List<Pet_noticeVO> getAllBoardByPage(PageMaker pageMaker);
	
}