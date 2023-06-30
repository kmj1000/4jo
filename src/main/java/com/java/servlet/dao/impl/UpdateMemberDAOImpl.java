package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.servlet.dao.UpdateMemberDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;


public class UpdateMemberDAOImpl implements UpdateMemberDAO{

	
	 public MembersVO getMember(String email){
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        MembersVO vo = null;
	 
	        try {

	        	String sql = "SELECT name"
	        			+ "FROM members" 
	        			 		+ "WHERE email = ?"
	        			 		;
	            
	            conn = DBCP2Util.getConnection();// DBCP2Util
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,email);
				rs = pstmt.executeQuery();
				//아이디 존재 확인 
				 pstmt.executeUpdate();
				 
	           if(rs.next()) {
	        	 
	        	   vo = new MembersVO();
	            	 vo.setName(rs.getString("name"));
	                 vo.setEmail(rs.getString("email"));
	                 vo.setPwd(rs.getString("pwd"));
	                 vo.setPhone(rs.getInt("phone"));
	                 vo.setNickname(rs.getString("nickname"));  
	        	   
	           }
	         
	                        
	        } catch (Exception e) {
	           e.printStackTrace();
	            throw new RuntimeException(e.getMessage());
	        }finally {
 	            try{
 	                if ( pstmt != null )try{ pstmt.close();}catch(SQLException ss) {}
 	                if ( conn != null )try{ conn.close();}catch(SQLException ss)    {}
 	            }catch(Exception e)   {
 	            }
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


