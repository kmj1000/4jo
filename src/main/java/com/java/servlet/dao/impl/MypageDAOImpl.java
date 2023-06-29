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

//   @Override
//	public int updatePwd(MembersVO vo) {
//		int result = 0;
//		String sql = "UPDATE members\r\n"
//				+ "    SET pwd = ?\r\n"
//				+ "    WHERE email = ?"
//				;
//		try(
//				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
//				PreparedStatement ps = conn.prepareStatement(sql);
//				){
//				
//				ps.setString(1, vo.getPwd());
//				ps.setString(2, vo.getEmail());
//				System.out.println(result);
//				result = ps.executeUpdate();
//				
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//		
//	}
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






