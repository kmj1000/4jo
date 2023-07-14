package com.java.servlet.service;

import java.util.List;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public interface NoticeService {
	
	List<NoticeVO> getAllNotice();
	int getCountAllNotice();

	List<NoticeVO> getAllNoticeByPage(PageMaker pageMaker);
	
}
