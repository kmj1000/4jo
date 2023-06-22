package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.Favorite_S_DAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.Favorite_S_VO;

public class Favorite_S_DAOImpl implements Favorite_S_DAO {
	private static final Favorite_S_DAO instance = new Favorite_S_DAOImpl();
	private Favorite_S_DAOImpl() {
		
	}
	public static Favorite_S_DAO getInstance() {
		return instance;
	}
	
	@Override
	public Favorite_S_VO selectedFavorite_S(int favorite_shelter_no) {
		String sql = "SELECT favorite_shelter_no\r\n"
				+ ", shelter_no\r\n"
				+ ", careNmShelter\r\n"
				+ ", careAddrShelter\r\n"
				+ ", careTelShelter\r\n"
				+ ",(SELECT nickname FROM members) as nickname\r\n"
				+ "FROM Favorite_shelter WHERE favorite_shelter_no=?"
				;
		Favorite_S_VO vo = null;
		
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, favorite_shelter_no);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new Favorite_S_VO();
					vo.setFavorite_shelter_no(rs.getInt("favorite_shelter_no"));
					vo.setShelter_no(rs.getInt("shelter_no"));
					vo.setNickname(rs.getString("nickname"));
					vo.setCareNmShelter(rs.getString("careNmShelter"));
					vo.setCareAddrShelter(rs.getString("careAddrShelter"));
					vo.setCareTelShelter(rs.getString("careTelShelter"));
				
				}
				rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

}
