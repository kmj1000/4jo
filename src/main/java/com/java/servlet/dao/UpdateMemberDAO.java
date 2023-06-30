package com.java.servlet.dao;

import com.java.servlet.vo.MembersVO;

public interface UpdateMemberDAO {
	
	MembersVO getMember(String email);
	void SendUpdateMember(MembersVO vo);
}
