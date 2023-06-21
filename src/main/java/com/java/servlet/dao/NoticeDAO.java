package com.java.servlet.dao;

import com.java.servlet.vo.NoticeVO;

public interface NoticeDAO {
	NoticeVO selectNotice(String admin);
}
