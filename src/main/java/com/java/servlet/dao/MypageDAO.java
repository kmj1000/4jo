package com.java.servlet.dao;

import java.util.List;
import com.java.servlet.vo.MembersVO;

public interface MypageDAO {
	/* List<MembersVO> selectAllBoard(); */

	int updatePwd(MembersVO vo);

	List<MembersVO> selectAllBoard();

	MembersVO selectMember(String email);
	
	int deleteId(String email); 

}
