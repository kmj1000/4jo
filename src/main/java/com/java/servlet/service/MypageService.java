package com.java.servlet.service;

import java.util.List;

import com.java.servlet.vo.MembersVO;

public interface MypageService {

	List<MembersVO> getAllBoard();	
	
	int modifyPwd(MembersVO vo);
}
