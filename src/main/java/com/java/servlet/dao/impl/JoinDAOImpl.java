package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.servlet.dao.JoinDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class JoinDAOImpl implements JoinDAO {
	private static final JoinDAO instance = new JoinDAOImpl();
	
	private JoinDAOImpl() {}
	
	public static JoinDAO getInstance() {
		return instance;
	}
	
	@Override
	public int insertMembers(MembersVO member)  {
		int result = 0;
		
		String sql = "INSERT INTO members(nickname, email, pwd, name, phone)\r\n"
				+ "        VALUES(\r\n"
				+ "               ?\r\n"
				+ "                ,?\r\n"
				+ "                ,?\r\n"
				+ "                ,?\r\n"
				+ "                ,?\r\n"
				+ "        )";
		
		try(
				Connection conn = DataBaseUtil.getConnection();//DataBaseUtil, DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				System.out.println(pstmt);
				pstmt.setString(1, member.getNickname());
				pstmt.setString(2, member.getEmail());
				pstmt.setString(3, member.getPwd());
				pstmt.setString(4, member.getName());
				pstmt.setInt(5, member.getPhone());
			
				result = pstmt.executeUpdate();
				System.out.println("result - "+result);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
