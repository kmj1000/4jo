package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.LoginDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class LoginDAOImpl implements LoginDAO {
	private static final LoginDAO instance = new LoginDAOImpl();

	private LoginDAOImpl() {}

	public static LoginDAO getInstance() {
		return instance;
	}

	@Override
	public int selectCountMember(MembersVO vo) {

		// 여기는 selectMember 하는 자리, 나중에 적기

		int result = 0;

		String sql = "SELECT COUNT(1) FROM  members\r\n" + "    WHERE (email, pwd) IN ( (?, ?) )";

		try (Connection conn = DBCP2Util.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			System.out.println(pstmt);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPwd());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println("result - " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void selectMembersByIdAndPwd(MembersVO vo) {

		String sql = "SELECT * FROM  members\r\n" + "    WHERE (Email, pwd) IN ( (?, ?) )";

		try (Connection conn = DBCP2Util.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			System.out.println(pstmt);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPwd());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setNickname(rs.getString("nickname"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getInt("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
