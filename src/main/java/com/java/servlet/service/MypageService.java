package com.java.servlet.service;

import java.util.List;

import com.java.servlet.vo.MembersVO;

public interface MypageService {

//	int modifyPwd(MembersVO vo);


	List<MembersVO> selectMypage(int m_no);

//MembersVO selectAllBoard(String email);
//
//	int removeId(String email);//탈퇴 로그아웃

//MembersVO selectMypage(int m_no);

}
