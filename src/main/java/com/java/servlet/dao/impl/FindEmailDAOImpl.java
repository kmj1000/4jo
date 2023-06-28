package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.FindEmailDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class FindEmailDAOImpl implements FindEmailDAO {
	private static final FindEmailDAO instance = new FindEmailDAOImpl();

	private FindEmailDAOImpl() {	}

	public static FindEmailDAO getInstance() {
		return instance;
	}

	public String selectFindEmail(MembersVO vo) {
		String email = null;

		String sql = "SELECT email FROM members WHERE (name, phone) IN ( (?, ?) )";

		try (Connection conn = DataBaseUtil.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			System.out.println(pstmt);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPhone());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				email = rs.getString("email");
			}
//			else {
//				pwd = null;
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}

}
