package com.java.servlet.dao;

import com.java.servlet.vo.MembersVO;

public interface MemberApiDAO {
	int updatePwd(MembersVO vo);
	int updatePhone(MembersVO vo);
	int deleteMember(String email);
}
