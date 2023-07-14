package com.java.servlet.service;

import java.util.List;

import com.java.servlet.vo.CommunityVO;

public interface MypaperService {
	List<CommunityVO> getMypaper();
	List<CommunityVO> getMypaper(String nickname);
}
