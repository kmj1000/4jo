package com.java.servlet.dao;

import com.java.servlet.vo.MembersVO;

public interface LoginDAO {

	int selectCountMember(MembersVO vo);

	void selectMembersByIdAndPwd(MembersVO vo);

}
