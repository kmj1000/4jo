package com.java.servlet.service;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public interface CommunityService {
	CommunityVO getCommunity(int c_no);
	List<CommunityVO> getAllCommunity();

	int getCountAllCommunity();

	List<CommunityVO> getAllCommunityByPage(PageMaker pageMaker);
	int registerBoard(CommunityVO vo);
	int modifyBoard(CommunityVO vo);
	int removeBoard(int parseInt);


}
