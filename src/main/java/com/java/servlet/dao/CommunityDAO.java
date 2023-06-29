package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public interface CommunityDAO {
	CommunityVO selectCommunity(int c_no);
	List<CommunityVO> selectAllCommunity();

	int selectCountAllCommunity();
//
	List<CommunityVO> selectAllCommunityByPage(PageMaker pageMaker);
	
	int insertCommunity(CommunityVO vo);
	int updateCommunity(CommunityVO vo);
	int deleteCommunity(int c_no);


}
