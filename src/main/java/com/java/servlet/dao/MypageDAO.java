package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.vo.MembersVO;

public interface MypageDAO {



//	MembersVO selectAllBoard(String email);

	List<MembersVO> selectMypage(int m_no);

}
