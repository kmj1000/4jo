package com.java.servlet.dao;

import com.java.servlet.vo.MembersVO;

public interface MemberContentDAO {
	
	MembersVO selectMember(String email);
	
}
