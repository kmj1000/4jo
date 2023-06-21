package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public class CommunityDAOImpl implements CommunityDAO {
    private final static CommunityDAO instance = new CommunityDAOImpl();
	private CommunityDAOImpl() {
	}
	public static CommunityDAO getInstance() {
	     return instance;
	}
	@Override
	public CommunityVO selectCommunity(int c_no) {
		
		String sql = "SELECT c_no\r\n"
					+ "        ,nickname\r\n"
		            + "        ,title\r\n"
		            + "        ,content\r\n"
		            + "        ,reg_date\r\n"
		            + "    FROM community"
		            ;
		      CommunityVO vo = null;
		      
		      try(
		            Connection conn = DataBaseUtil.getConnection();// DBCP2Util
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            ){
		            
					pstmt.setInt(1, c_no);
		         
		            ResultSet rs = pstmt.executeQuery();
		            
		            if( rs.next() ) {
		               vo = new CommunityVO();
		               vo.setC_no(rs.getInt("c_no"));
		               vo.setNickname(rs.getString("nickname"));
		               vo.setTitle(rs.getString("title"));
		               vo.setContent(rs.getString("content"));
		               vo.setReg_date(rs.getDate("reg_date"));
		            }
		            rs.close();
		            
		      }catch(Exception e) {
		         e.printStackTrace();
		      }
		      
		      return vo;
		
	}

}
