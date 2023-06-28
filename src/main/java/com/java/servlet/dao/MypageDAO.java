package com.java.servlet.dao;

import java.util.List;


import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.MembersVO;

public interface MypageDAO {
	

	int updatePwd(MembersVO vo);

	

	List<MembersVO> selectAllBoard();
	
	int getOutD(int m_no);  //나가
}
