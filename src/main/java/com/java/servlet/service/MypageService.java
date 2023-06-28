package com.java.servlet.service;

import java.util.List;

import com.java.servlet.vo.MembersVO;

public interface MypageService {

	List<MembersVO> getAllBoard(String nickname);	
	
	int modifyPwd(MembersVO vo);

	/* List<MembersVO> getAllBoard(); */

	/* List<MembersVO> getAllBoard(); */
}
