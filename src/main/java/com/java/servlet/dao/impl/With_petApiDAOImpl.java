package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.servlet.dao.With_petApiDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.Favorite_W_VO;
import com.java.servlet.vo.With_petVO;

public class With_petApiDAOImpl implements With_petApiDAO {

	private static final With_petApiDAO instance = new With_petApiDAOImpl();
	private With_petApiDAOImpl() {
		
	}
	public static With_petApiDAO getInstance() {
		return instance;
	}
	
	
	
	@Override
	public int insertWith_petData(With_petVO vo) {
		int result=0;
		String sql = " INSERT INTO favoritew (\r\n"
				+ "    favoritew_no,\r\n"
				+ "    favoritew_reg_date,\r\n"
				+ "    with_pet_no,\r\n"
				+ "    building,\r\n"
				+ "    category3,\r\n"
				+ "    road,\r\n"
				+ "    tel,\r\n"
				+ "    homepage,\r\n"
				+ "    day_off,\r\n"
				+ "    hour,\r\n"
				+ "    parking,\r\n"
				+ "    with_pet_info,\r\n"
				+ "    only_pet_info,\r\n"
				+ "    pet_size,\r\n"
				+ "    pet_limit,\r\n"
				+ "    inside,\r\n"
				+ "    outside,\r\n"
				+ "    extra\r\n"
				+ ")\r\n"
				+ "VALUES (\r\n"
				+ "    seq_favoritew_no.nextval,\r\n"
				+ "    sysdate,\r\n"
				+ "    (SELECT with_pet_no FROM with_pet WHERE with_pet_no = ?),\r\n"
				+ "    (SELECT building FROM with_pet WHERE building = ?),\r\n"
				+ "    (SELECT category3 FROM with_pet WHERE category3 = ?),\r\n"
				+ "    (SELECT road FROM with_pet WHERE road = ?),\r\n"
				+ "    (SELECT tel FROM with_pet WHERE tel = ?),\r\n"
				+ "    (SELECT homepage FROM with_pet WHERE homepage = ?),\r\n"
				+ "    (SELECT day_off FROM with_pet WHERE day_off = ?),\r\n"
				+ "    (SELECT hour FROM with_pet WHERE hour = ?),\r\n"
				+ "    (SELECT parking FROM with_pet WHERE parking = ?),\r\n"
				+ "    (SELECT with_pet_info FROM with_pet WHERE with_pet_info = ?),\r\n"
				+ "    (SELECT only_pet_info FROM with_pet WHERE only_pet_info = ?),\r\n"
				+ "    (SELECT pet_size FROM with_pet WHERE pet_size = ?),\r\n"
				+ "    (SELECT pet_limit FROM with_pet WHERE pet_limit = ?),\r\n"
				+ "    (SELECT inside FROM with_pet WHERE inside = ?),\r\n"
				+ "    (SELECT outside FROM with_pet WHERE outside = ?),\r\n"
				+ "    (SELECT extra FROM with_pet WHERE extra = ?)\r\n"
				+ ")";
		try(
			Connection conn = DBCP2Util.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setInt(1, vo.getWith_pet_no());
			pstmt.setString(2, vo.getBuilding());
			pstmt.setString(3, vo.getCategory3());
			pstmt.setString(4, vo.getRoad());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getHomepage());
			pstmt.setString(7, vo.getDay_off());
			pstmt.setString(8, vo.getHour());
			pstmt.setString(9, vo.getParking());
			pstmt.setString(10, vo.getWith_pet_info());
			pstmt.setString(11, vo.getOnly_pet_info());
			pstmt.setString(12, vo.getPet_size());
			pstmt.setString(13, vo.getPet_limit());
			pstmt.setString(14, vo.getInside());
			pstmt.setString(15, vo.getOutside());
			pstmt.setString(16, vo.getExtra());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteWith_petData(int favoritew_no) {
		int result=0;
		String sql = "DELETE FROM favoritew WHERE with_pet_no=? ";
		
		try(
				Connection conn = DBCP2Util.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, favoritew_no);
				result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}