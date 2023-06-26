package com.java.servlet.dao;

import java.util.List;


import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.MembersVO;

public interface MypageDAO {
	List<MembersVO> selectAllBoard();
}
