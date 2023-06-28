package com.java.servlet.service;

import java.util.List;

import com.java.servlet.vo.MembersVO;

public interface MypageService {

	int modifyPwd(MembersVO vo);

	List<MembersVO> getAllBoard();

	MembersVO readMember(String email);

	int removeId(String email);

}
