package com.java.servlet.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.Favorite_W_DAO;
import com.java.servlet.util.DatabaseUtil;
import com.java.servlet.vo.Favorite_W_VO;

public class Favorite_W_DAOImpl implements Favorite_W_DAO {
	private static final Favorite_W_DAO instance = new Favorite_W_DAOImpl();
	private Favorite_W_DAOImpl() {
		
	}
	public static Favorite_W_DAO getInstance() {
		return instance;
	}
	
	@Override
	public Favorite_W_VO selectedFavorite_W(int favorite_with_pet_no) {
		String sql="SELECT favorite_with_pet_no\r\n"
				+ ", with_pet_no\r\n"
				+ ", w_name\r\n"
				+ ", tel\r\n"
				+ ", road\r\n"
				+ ",(SELECT nickname FROM members) as nickname\r\n"
				+ "FROM Favorite_with_pet WHERE favorite_with_pet_no=?;";
		Favorite_W_VO vo = null;
		try(
				Connection conn = DatabaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, favorite_with_pet_no);
				ResultSet rs = pstmt.executeQuery();		
				
				if(rs.next()) {
					vo=new Favorite_W_VO();
					vo.setFavorite_with_pet_no(rs.getInt("favorite_with_pet_no"));
					vo.setWith_pet_no(rs.getInt("with_pet_no"));
					vo.setW_name(rs.getString("w_name"));
					vo.setTel(rs.getString("tes"));
					vo.setRoad(rs.getString("road"));
				}
				rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}

}
