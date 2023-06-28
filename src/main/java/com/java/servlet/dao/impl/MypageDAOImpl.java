package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
   
   private static final MypageDAO instance = new MypageDAOImpl();
   
   private MypageDAOImpl() {
   }
   
   public static MypageDAO getInstance() {
      return instance;
   }
   
   @Override
	public MembersVO selectMypage(String email) {
		
	   String sql = "SELECT m_no\r\n"
               + "        ,pwd\r\n"
               + "        ,phone\r\n"
               + "        ,name\r\n"      
               + "        ,nickname\r\n"
               + "    FROM members where email = ?"
               ;
	   
	   MembersVO vo = null;
		      
	   try {
           Connection conn = DataBaseUtil.getConnection();// DBCP2Util
           PreparedStatement pstmt = conn.prepareStatement(sql);
           
           
			pstmt.setString(1, email);
        
           ResultSet rs = pstmt.executeQuery();
		            
		            if( rs.next() ) {
		            	vo = new MembersVO();
		            	 vo.setM_no(rs.getInt("m_no"));
		            	 vo.setEmail(rs.getString("email"));
		            	 vo.setName(rs.getString("name"));
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
//원본
//   @Override
//   public MembersVO selectAllBoard(String email) {
//	   Connection conn = null;
//       PreparedStatement pstmt = null;
//       ResultSet rs = null;   
//       MembersVO vo = null;
//	   String sql = "SELECT name\r\n"
//               + "        ,email\r\n"
//               + "        ,pwd\r\n"
//               + "        ,phone\r\n"
//               + "        ,nickname\r\n"
//               + "    FROM members where email =?"
//               ;
//
//      
//	      try {		conn = DataBaseUtil.getConnection();
//	      			pstmt = conn.prepareStatement(sql.toString());
//	      			pstmt.setString(1, email);
//	      			rs = pstmt.executeQuery();        	      		
//	      	
//            //회원정보 vo에 담아!!!!!!!!!!!!!
//            if( rs.next() ) {
//            	vo = new MembersVO();
//            	 vo.setName(rs.getString("name"));
//                 vo.setEmail(rs.getString("email"));
//                 vo.setPwd(rs.getString("pwd"));
//                 vo.setPhone(rs.getInt("phone"));
//                 vo.setNickname(rs.getString("nickname"));
//
//            	}
//               return vo;
//	      	}
//	      
//	      catch (Exception sqle) {
//	    	  throw new RuntimeException(sqle.getMessage());}
//     
//          finally {
//          // Connection, PreparedStatement를 닫는다.
//          try{
//              if ( pstmt != null ){ pstmt.close(); pstmt=null; }
//              if ( conn != null ){ conn.close(); conn=null;    }
//              } catch(Exception e) {
//                  e.printStackTrace();
//               }
//  
//   }


//@Override
//public int deleteId(String email) {
//	int result = 0;
//
//	String sql = "DELETE from members\r\n"
//			+ "    WHERE email = ?"
//			;
//	try(
//			Connection conn = DataBaseUtil.getConnection();// DBCP2Util
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			){
//			pstmt.setString(1, email);
//			System.out.println(result);
//			result = pstmt.executeUpdate();
//			
//	}catch(Exception e) {
//		e.printStackTrace();
//	}
//	return result;
//	
//}



   }
   

