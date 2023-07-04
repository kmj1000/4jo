package com.java.servlet.service.impl;

import com.java.servlet.dao.NoticeApiDAO;
import com.java.servlet.dao.impl.NoticeApiDAOImpl;
import com.java.servlet.service.NoticeApiService;
import com.java.servlet.vo.NoticeVO;

public class NoticeApiServiceImpl implements NoticeApiService {
	private final static NoticeApiService instance = new NoticeApiServiceImpl();
	private final NoticeApiDAO dao = NoticeApiDAOImpl.getInstance();
	private NoticeApiServiceImpl() {
		
	}
	public static NoticeApiService getInstance() {
		return instance;
	}
	
	@Override
	public int registerNotice(NoticeVO vo) {
		
		return dao.insertNotice(vo);
	}

	@Override
	public int modifyNotice(NoticeVO vo) {
	
		return dao.updateNotice(vo);
	}

	@Override
	public int removeNotice(int notice_no) {
		
		return dao.removeNotice(notice_no);
	}

}
