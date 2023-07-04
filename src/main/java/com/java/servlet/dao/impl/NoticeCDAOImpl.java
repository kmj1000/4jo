package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.NoticeCDAO;
import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public class NoticeCDAOImpl implements NoticeCDAO {
	 private final static NoticeCDAO instance = new NoticeCDAOImpl();
	   private NoticeCDAOImpl() {
	   }
	   public static NoticeCDAO getInstance() {
	      return instance;
	   }
	   @Override
		public NoticeVO selectNotice(int notice_no) {
			
			String sql = "SELECT notice_no\r\n"
			            + "        ,notice_title\r\n"
			            + "        ,notice_content\r\n"
			            + "        ,notice_reg_date\r\n"
			            + "        ,nickname\r\n"
			            + "    FROM notice WHERE notice_no = ?"
			            ;
			      NoticeVO vo = null;
			      
			      try {
			            Connection conn = DataBaseUtil.getConnection();// DBCP2Util DataBaseUtil
			            PreparedStatement pstmt = conn.prepareStatement(sql);
			            
			            
						pstmt.setInt(1, notice_no);
			         
			            ResultSet rs = pstmt.executeQuery();
			            
			            if( rs.next() ) {
			               vo = new NoticeVO();
			               vo.setNotice_no(rs.getInt("notice_no"));
			               vo.setNotice_title(rs.getString("notice_title"));
			               vo.setNotice_content(rs.getString("notice_content"));
			               vo.setNotice_reg_date(rs.getDate("notice_reg_date"));
			               vo.setNickname(rs.getString("nickname"));
			            }
			            rs.close();
			            
			      }catch(Exception e) {
			         e.printStackTrace();
			      }
			      
			      return vo;
			
		}
		
	}


