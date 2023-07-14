package com.java.servlet.service;

import com.java.servlet.vo.NoticeVO;

public interface NoticeApiService {
	int registerNotice(NoticeVO vo);
	int modifyNotice(NoticeVO vo);
	int removeNotice(int notice_no);
}
