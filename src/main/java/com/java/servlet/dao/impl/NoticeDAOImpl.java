package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.util.DatabaseUtil;
import com.java.servlet.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

	private final static NoticeDAO instance = new NoticeDAOImpl();
	   private NoticeDAOImpl() {
	   }
	   public static NoticeDAO getInstance() {
	      return instance;
	   }
	   
	@Override
	public NoticeVO selectNotice(String admin_name) {
		
		String sql = "SELECT notice_no\r\n"
				+ "        ,admin_name\r\n"
	            + "        ,notice_title\r\n"
	            + "        ,notice_content\r\n"
	            + "        ,notice_reg_date\r\n"
	            + "    FROM notice"
	            ;
	      NoticeVO vo = null;
	      
	      try(
	            Connection conn = DatabaseUtil.getConnection();// DBCP2Util
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ){
	            
				pstmt.setString(1, admin_name);
	         
	            ResultSet rs = pstmt.executeQuery();
	            
	            if( rs.next() ) {
	               vo = new NoticeVO();
	               vo.setNotice_no(rs.getInt("Notice_no"));
	               vo.setAdmin_name(rs.getString("admin_name"));
	               vo.setNotice_title(rs.getString("notice_title"));
	               vo.setNotice_content(rs.getString("notice_content"));
	               vo.setNotice_reg_date(rs.getDate("notice_reg_date"));
	            }
	            rs.close();
	            
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return vo;
	}
	
}
