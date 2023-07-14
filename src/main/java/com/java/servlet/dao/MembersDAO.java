package com.java.servlet.dao;

import java.util.List;

import com.java.servlet.vo.MembersVO;


public interface MembersDAO {

	List<MembersVO> selectMembersList();
	
}
