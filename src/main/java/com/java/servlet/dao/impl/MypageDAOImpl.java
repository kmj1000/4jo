package com.java.servlet.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.MembersDAO;
import com.java.servlet.dao.MypageDAO;

import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.MembersVO;

public class MypageDAOImpl implements MypageDAO {
   
   private static MypageDAO instance = new MypageDAOImpl();
   
   private MypageDAOImpl() {
   }
   
   public static MypageDAO getInstance() {
	   if(instance==null)
           instance=new MypageDAOImpl();
      return instance;
   }
   
   
   @Override
   public MembersVO selectMypage(String email) {
      
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

            conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
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
   
   public void SendUpdateMember(MembersVO vo){
        
        Connection conn = null;
        PreparedStatement pstmt = null;

 
        try {
        	conn = DBCP2Util.getConnection();// DBCP2Util
        	String sql = "UPDATE members SET name =?, pwd=? , phone=? , nickname=?" 
        			 		+ "WHERE email = ?"
        			 		;
            
            
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getPwd());
			pstmt.setInt(3,vo.getPhone());
			pstmt.setString(4,vo.getNickname());
			pstmt.setString(5,vo.getEmail());
		
	
			 pstmt.executeUpdate();

                        
        } catch (Exception e) {
           e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            try{
                if ( pstmt != null )try{ pstmt.close();}catch(SQLException ss) {}
                if ( conn != null )try{ conn.close();}catch(SQLException ss)    {}
            }catch(Exception e)   {
            }
        }

    }


}
