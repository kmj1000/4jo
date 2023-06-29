package com.java.servlet.dao;

import java.sql.SQLException;

import com.java.servlet.vo.MembersVO;

public interface UpdateMemberDAO {
	void updateMember(MembersVO vo) throws SQLException;
	
	
}
