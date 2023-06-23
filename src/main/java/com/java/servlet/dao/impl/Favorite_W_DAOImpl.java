package com.java.servlet.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.Favorite_W_DAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.Favorite_W_VO;

public class Favorite_W_DAOImpl implements Favorite_W_DAO {
	private static final Favorite_W_DAO instance = new Favorite_W_DAOImpl();
	private Favorite_W_DAOImpl() {
		
	}
	public static Favorite_W_DAO getInstance() {
		return instance;
	}
	
	@Override
	public Favorite_W_VO selectFavorite_with_pet(int favorite_with_pet_no) {
		String sql="SELECT favorite_with_pet_no\r\n"
				+ ",(SELECT nickname FROM members) as nickname\r\n"
				+ ", 전화번호\r\n"
				+ ", 시설명\r\n"
				+ ", 도로명주소\r\n"
				+ "FROM Favorite_with_pet WHERE favorite_with_pet_no=?"
				;
		Favorite_W_VO vo = null;
		try(
				Connection conn = DBCP2Util.getConnection();
				//Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, favorite_with_pet_no);
				ResultSet rs = pstmt.executeQuery();		
				
				if(rs.next()) {
					vo=new Favorite_W_VO();
					vo.setFavorite_with_pet_no(rs.getInt("favorite_with_pet_no"));
					vo.setNickname(rs.getString("nickname"));
					vo.set전화번호(rs.getString("전화번호"));
					vo.set시설명(rs.getString("시설명"));
					vo.set도로명주소(rs.getString("도로명주소"));
					
				}
				rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}

}
