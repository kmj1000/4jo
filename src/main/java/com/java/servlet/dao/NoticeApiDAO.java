package com.java.servlet.dao;

import com.java.servlet.vo.NoticeVO;

public interface NoticeApiDAO {
	int insertNotice(NoticeVO vo);
	int updateNotice(NoticeVO vo);
	int removeNotice(int notice_no);
}
