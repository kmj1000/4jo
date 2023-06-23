package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.java.servlet.dao.MypageDAO;

import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class MypageDAOImpl implements MypageDAO {
	
	@Override
	public List<MembersVO> selectMembers(String email) {
		
		List<MembersVO> memberList = new ArrayList<>();
		
		String sql = "SELECT nickname\r\n"
				+ "        , email\r\n"
				+ "        , name\r\n"
				+ "        , phone \r\n"
				+ "        FROM members WHERE email = ?"
				;
		
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery(sql);
		){
			
			pstmt.setString(1, email);
			
			if( rs.next()){
				MembersVO membersvo = new MembersVO();
				
				membersvo.setNickname(rs.getString("nickname"));
				membersvo.setEmail(rs.getString("email"));
				membersvo.setName(rs.getString("name"));
				membersvo.setPhone(rs.getInt("phone"));
				
				memberList.add(membersvo);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	

}
