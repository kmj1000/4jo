package com.java.servlet.service.impl;

import java.util.List;

import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.dao.impl.NoticeDAOImpl;
import com.java.servlet.service.NoticeService;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private static final NoticeService instance = new NoticeServiceImpl();
	private final NoticeDAO dao = NoticeDAOImpl.getInstance();

	private NoticeServiceImpl() {
	}
	public static NoticeService getInstance() {
		   return instance;
	}
	@Override
	public NoticeVO getNotice(String admin_name) {
		// TODO Auto-generated method stub
		return dao.selectNotice(admin_name);
	}
	public List<NoticeVO> getAllNotice() {
		return dao.selectAllNotice();
	}
	
	@Override
	public int getCountAllNotice() {
		return dao.selectCountAllNotice();
	}
	@Override
	public List<NoticeVO> getAllNoticeByPage(PageMaker pageMaker) {
		return dao.selectAllNoticeByPage(pageMaker);
	}

}



