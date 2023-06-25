package com.java.servlet.service;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public interface CommunityService {
	CommunityVO getCommunity(int c_no);

	int getCountAllCommunity();

	List<CommunityVO> getAllCommunityByPage(PageMaker pageMaker);
}
