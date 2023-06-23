package com.java.servlet.dao;

import com.java.servlet.vo.MembersVO;

public interface MypageDAO {

	MembersVO selectMypage(String nickname);

}
