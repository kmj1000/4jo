package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.servlet.dao.UpdateMemberDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class UpdateMemberDAOImpl implements UpdateMemberDAO{
	
	private static final UpdateMemberDAO instance = new UpdateMemberDAOImpl();

	private UpdateMemberDAOImpl() {
	}
	
	public static UpdateMemberDAO getInstance() {
		return instance;
	}

	
	 public void updateMember(MembersVO vo){
	        
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	 
	        try {

	        	String sql = "UPDATE members SET pwd=?\r\n "
	        			 					+ ", phone=?\r\n"
	        			 					+ "WHERE email = ?"
	        			 					;
	            
	            conn = DataBaseUtil.getConnection();// DBCP2Util
				pstmt = conn.prepareStatement(sql);
	           
				// 자동 커밋을 false로 한다.
	            conn.setAutoCommit(false);
				
	           // pstmt = conn.prepareStatement(sql.toString());	 	            
	            MembersVO member = new MembersVO();
	            pstmt.setString(1, member.getPwd());
	            pstmt.setInt(2, member.getPhone());
	 
	            pstmt.executeUpdate();
	            conn.commit(); 
	                        
	        } catch (Exception e) {
	            conn.rollback(); // 오류시 롤백
	            throw new RuntimeException(e.getMessage());
	        } finally {
	            try{
	                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
	                if ( conn != null ){ conn.close(); conn=null;    }
	            }catch(Exception e){
	                throw new RuntimeException(e.getMessage());
	            }
	        }
	    } // end updateMember

	
}
