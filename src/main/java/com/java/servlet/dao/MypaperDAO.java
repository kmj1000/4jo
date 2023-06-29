package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.vo.CommunityVO;

public interface MypaperDAO {

	List<CommunityVO> selectMypaper();

	List<CommunityVO> selectMypaper(String nickname);
	
}
