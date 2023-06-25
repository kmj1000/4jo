package com.java.servlet.service;

import com.java.servlet.vo.MembersVO;

public interface LoginService {

	int getCountMember(MembersVO vo);

	void getMemberByIdAndPwd(MembersVO vo);

}
