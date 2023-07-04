package com.java.servlet.service;

import com.java.servlet.vo.MembersVO;

public interface MemberApiService {
	int modifyPwd(MembersVO vo);
	int modifyPhone(MembersVO vo);
	int removeMember(String email);
}
