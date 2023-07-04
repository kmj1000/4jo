package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.servlet.dao.MemberContentDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;


public class MemberContentDAOImpl implements MemberContentDAO{
	private final static MemberContentDAO instance = new MemberContentDAOImpl();
	private MemberContentDAOImpl() {
		
	}
	public static MemberContentDAO getInstance() {
		return instance;
	}
	
	@Override
	   public MembersVO selectMember(String email) {
	      
		   Connection conn = null;
	       PreparedStatement pstmt = null;
	       ResultSet rs = null;
	       MembersVO vo = null;
	       
		   try {  
			   String sql = "SELECT email\r\n"
	               + "        ,pwd\r\n"
	               + "        ,phone\r\n"
	               + "        ,name\r\n"      
	               + "        ,nickname\r\n"
	               + "    FROM members WHERE email = ?"
	               ;

	            conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
	            pstmt = conn.prepareStatement(sql.toString());   
	            pstmt.setString(1, email);
	            rs = pstmt.executeQuery();
	 
	            
	            if( rs.next() ) {
	            	 vo = new MembersVO();
	            	 vo.setName(rs.getString("name"));
	                 vo.setEmail(rs.getString("email"));
	                 vo.setPwd(rs.getString("pwd"));
	                 vo.setPhone(rs.getInt("phone"));
	                 vo.setNickname(rs.getString("nickname"));         

	            }
	                rs.close();
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	  
	      return vo;
	   }
	

 }


