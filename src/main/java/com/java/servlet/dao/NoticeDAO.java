package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.NoticeVO;

public interface NoticeDAO {
	

	
	List<NoticeVO> selectAllNotice();

	int selectCountAllNotice();

	List<NoticeVO> selectAllNoticeByPage(PageMaker pageMaker);
	
}
