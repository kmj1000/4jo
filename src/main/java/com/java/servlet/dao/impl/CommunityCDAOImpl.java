package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.CommunityCDAO;
import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.CommunityVO;

public class CommunityCDAOImpl implements CommunityCDAO {
	private final static CommunityCDAO instance = new CommunityCDAOImpl();
	private CommunityCDAOImpl() {
	}
	public static CommunityCDAO getInstance() {
	     return instance;
	}
	@Override
	public CommunityVO selectCommunity(int c_no) {
		
		String sql = "SELECT c_no\r\n"
		            + "        ,title\r\n"
		            + "        ,content\r\n"
		            + "        ,reg_date\r\n"
		            + "        ,nickname\r\n"
		            + "    FROM community WHERE c_no = ?"
		            ;
		      CommunityVO vo = null;
		      
		      try {
		            Connection conn = DataBaseUtil.getConnection();// DBCP2Util DataBaseUtil
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            
		            
					pstmt.setInt(1, c_no);
		         
		            ResultSet rs = pstmt.executeQuery();
		            
		            if( rs.next() ) {
		               vo = new CommunityVO();
		               vo.setC_no(rs.getInt("c_no"));
		               vo.setTitle(rs.getString("title"));
		               vo.setContent(rs.getString("content"));
		               vo.setReg_date(rs.getDate("reg_date"));
		               vo.setNickname(rs.getString("nickname"));
		            }
		            rs.close();
		            
		      }catch(Exception e) {
		         e.printStackTrace();
		      }
		      
		      return vo;
		
	}

}
