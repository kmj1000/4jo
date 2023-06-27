package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.FindPwdDAO;
import com.java.servlet.dao.JoinDAO;
import com.java.servlet.dao.LoginDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.MembersVO;

public class FindPwdDAOImpl implements FindPwdDAO {
	private static final FindPwdDAO instance = new FindPwdDAOImpl();

	private FindPwdDAOImpl() {}
	
	public static FindPwdDAO getInstance() {
		return instance;
	}
	
	public String selectFindPwd(MembersVO vo){
		String pwd = null;

		String sql = "SELECT pwd FROM  members\r\n" 
					 + "    WHERE name=?, phone=?, email=?"
					 ;

		try (Connection conn = DataBaseUtil.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			System.out.println(pstmt);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());

			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pwd = rs.getString("member_pwd");
			}
//			else {
//				pwd = null;
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}

	@Override
	public String findPwd(FindPwdDAO fpdao) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
