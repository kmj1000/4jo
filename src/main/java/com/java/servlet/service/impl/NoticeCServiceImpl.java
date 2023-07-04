package com.java.servlet.service.impl;

import com.java.servlet.dao.NoticeCDAO;
import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.dao.impl.NoticeCDAOImpl;
import com.java.servlet.service.NoticeCService;
import com.java.servlet.vo.NoticeVO;

public class NoticeCServiceImpl implements NoticeCService {

	private static final NoticeCService instance = new NoticeCServiceImpl();
	private final NoticeCDAO dao = NoticeCDAOImpl.getInstance();

	private NoticeCServiceImpl() {
	}
	public static NoticeCService getInstance() {
		   return instance;
	}
	@Override
	public NoticeVO getNotice(int notice_no) {
		// TODO Auto-generated method stub
		return dao.selectNotice(notice_no);
	}
}
