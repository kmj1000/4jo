package com.java.servlet.dao;
import java.util.List;
import com.java.servlet.vo.MembersVO;

public interface MypageDAO {
	
	List<MembersVO> selectMembers(String email);
}
