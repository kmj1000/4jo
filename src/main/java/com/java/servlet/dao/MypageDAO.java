package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.vo.MembersVO;

public interface MypageDAO {

	MembersVO selectMypage(String email);
	void SendUpdateMember(MembersVO vo);
}
