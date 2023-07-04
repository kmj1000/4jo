package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.CommunityApiDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;

public class CommunityApiDAOImpl implements CommunityApiDAO {
    private final static CommunityApiDAO instance = new CommunityApiDAOImpl();
	private CommunityApiDAOImpl() {
	}
	public static CommunityApiDAO getInstance() {
	     return instance;
	}

	@Override
	public int insertCommunity(CommunityVO vo) {
		int result = 0;
		String sql = "INSERT INTO community( c_no\r\n"
					+ "                    ,title\r\n"
					+ "                    ,content\r\n"
					+ "                    ,reg_date\r\n"
					+ "            			,nickname\r\n"
					+ "                    )    \r\n"
					+ "    values(\r\n"
					+ "            seq_c_no.NEXTVAL\r\n"
					+ "            ,?\r\n"
					+ "            ,?\r\n"
					+ "            ,sysdate\r\n"
					+ "            ,(SELECT nickname FROM members WHERE nickname=?)\r\n"
					+ "    )";
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getNickname());
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int updateCommunity(CommunityVO vo) {
		int result = 0;
		String sql = "UPDATE community\r\n"
				+ "    SET title = ?\r\n"
				+ "    , content = ?\r\n"
				+ "    WHERE c_no= ?"
				;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getC_no());
				
				result = pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int deleteCommunity(int c_no) {
		int result = 0;
		String sql = "DELETE FROM community WHERE c_no = ?";
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setInt(1, c_no);
				
				result = pstmt.executeUpdate();
				System.out.println("result - " + result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
}
