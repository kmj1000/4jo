package com.java.servlet.service;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public interface CommunityApiService {
	int registerCommunity(CommunityVO vo);
	int modifyCommunity(CommunityVO vo);
	int removeCommunity(int parseInt);


}
