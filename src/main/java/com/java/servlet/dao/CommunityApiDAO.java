package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public interface CommunityApiDAO {
	
	int insertCommunity(CommunityVO vo);
	int updateCommunity(CommunityVO vo);
	int deleteCommunity(int c_no);


}
