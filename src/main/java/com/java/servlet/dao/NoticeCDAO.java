package com.java.servlet.dao;

import com.java.servlet.vo.NoticeVO;

public interface NoticeCDAO {
	NoticeVO selectNotice(int notice_no);
}
