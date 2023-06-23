//package com.java.servlet.dao.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import com.java.servlet.dao.MypageDAO;
//
//import com.java.servlet.util.DataBaseUtil;
//import com.java.servlet.vo.MembersVO;
//
//public class MypageDAOImpl implements MypageDAO {
//	
//	private static final MypageDAO Instance = new MypageDAOImpl();
//	public MypageDAOImpl(){}
//	
//	public static MypageDAO getInstance() {
//		return Instance;
//	}
//	
//	
//	@Override
//	public MembersVO selectMypageMB(String email) {
//		PreparedStatement pstmt = null;
//		Connection conn = null;
//		ResultSet rs = null;
//		MembersVO membervo = null;
//		
//	//	List<MembersVO> memberList = new ArrayList<>();
//		
//		String sql = "SELECT * FROM mypage WHERE email = ?"
//				;
//		
////		String sql = "SELECT nickname\r\n"
////				+ "        , email\r\n"
////				+ "        , name\r\n"
////				+ "        , phone \r\n"
////				+ "        FROM members WHERE email = ?"
////				;
//		
//		try {
//				conn = DataBaseUtil.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, email);
//				
//				rs = pstmt.executeQuery();
//		
//		
//			if( rs.next()){
//				
//				membervo = new MembersVO();
//				membervo.setNickname(rs.getString("nickname"));
//				membervo.setEmail(rs.getString("email"));
//				membervo.setName(rs.getString("name"));
//				membervo.setPhone(rs.getInt("phone"));
//				
//		//		memberList.add(membersvo);
//			}
//					
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return membervo;
//	}
//
//
//
//
//
//
//}




package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.MypageDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;


public class MypageDAOImpl implements MypageDAO {
	private static final MypageDAO instance = new MypageDAOImpl();
	public MypageDAOImpl() {
	}
	public static MypageDAO getInstance() {
		return instance;
	}
	
	@Override
	public MembersVO selectMypage(String nickname) {
		String sql = "SELECT email\r\n"
				+ "        ,name\r\n"
				+ "        ,pwd\r\n"
				+ "        ,phone\r\n"
				+ "        ,(SELECT nickname FROM members) as nickname\r\n"
				+ "    FROM mypage WHERE nickname= ?"
				;
		MembersVO vo = null;
		
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				
				pstmt.setString(1, nickname);
			
				ResultSet rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					vo = new MembersVO();
					vo.setNickname(rs.getString("nickname"));
					vo.setEmail(rs.getString("email"));
					vo.setPwd(rs.getString("pwd"));
					vo.setName(rs.getString("name"));
					vo.setPhone(rs.getInt("phone"));
				}
				rs.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
