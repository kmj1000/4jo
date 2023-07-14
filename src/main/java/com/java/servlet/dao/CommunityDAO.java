package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public interface CommunityDAO {
	
	List<CommunityVO> selectAllCommunity();

	int selectCountAllCommunity();
//
	List<CommunityVO> selectAllCommunityByPage(PageMaker pageMaker);

}
