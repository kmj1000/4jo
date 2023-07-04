package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.java.servlet.dao.MemberApiDAO;
import com.java.servlet.util.DataBaseUtil;

import com.java.servlet.vo.MembersVO;

public class MemberApiDAOImpl implements MemberApiDAO {

	private final static MemberApiDAO instance = new MemberApiDAOImpl();
	private MemberApiDAOImpl() {
	}
	public static MemberApiDAO getInstance() {
	     return instance;
	}

	
	
	@Override
	public int updatePwd(MembersVO vo) {
		int result = 0;
		String sql = "UPDATE members\r\n"
				+ "    SET pwd = ?\r\n"
				+ "    WHERE email= ?"
				;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setString(1, vo.getPwd());
				pstmt.setString(2, vo.getEmail());
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public int updatePhone(MembersVO vo) {
		int result = 0;
		String sql = "UPDATE members\r\n"
				+ "    SET\r\n"
				+ "    phone = ?\r\n"
				+ "    WHERE email= ?"
				;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				
				pstmt.setInt(1, vo.getPhone());
				pstmt.setString(2, vo.getEmail());
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	@Override
	public int deleteMember(String email) {
		int result = 0;
		String sql = "DELETE FROM members WHERE email = ?";
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setString(1, email);
				
				result = pstmt.executeUpdate();
				System.out.println("result - " + result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
