package com.java.servlet.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;

import com.java.servlet.dao.ShelterApiDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.Favorite_S_VO;
import com.java.servlet.vo.ShelterVO;

public class ShelterApiDAOImpl implements ShelterApiDAO {

	private static final ShelterApiDAO instance = new ShelterApiDAOImpl();
	private ShelterApiDAOImpl() {
		
	}
	public static ShelterApiDAO getInstance() {
		return instance;
	}
	
	
	
	@Override
	public int insertShelterData(ShelterVO vo) {
		int result=0;
		String sql = " INSERT INTO favorites( "
						+"favorites_no\r\n"
						+",favorites_reg_date\r\n"
						+ "				,shelter_no  \r\n"
						+ "				,careNm  \r\n"
						+ "				,divisionNm \r\n"
						+ "				,saveTrgtAnimal \r\n"
						+ "				,careAddr \r\n"
						+ "				,weekOprStime \r\n"
						+ "				,weekOprEtime\r\n"
						+ "				,weekCellStime \r\n"
						+ "				,weekCellEtime  \r\n"
						+ "				,weekendOprStime  \r\n"
						+ "				,weekendOprEtime  \r\n"
						+ "				,weekendCellStime \r\n"
						+ "				,weekendCellEtime \r\n"
						+ "				,closeDay \r\n"
						+ "				,careTel\r\n"
						
						+")\r\n"
						+"values(\r\n"
						+"seq_favorites_no.nextval\r\n"
						+",sysdate\r\n"
						+",(SELECT shelter_no from shelter where shelter_no=?)\r\n"
						+",(SELECT careNm FROM shelter WHERE careNm = ?)\r\n"
						+",(SELECT divisionNm FROM shelter WHERE divisionNm = ?)\r\n"
						+",(SELECT saveTrgtAnimal FROM shelter WHERE saveTrgtAnimal = ?)\r\n"
						+",(SELECT careAddr FROM shelter WHERE careAddr = ?)\r\n"
						+",(SELECT weekOprStime FROM shelter WHERE weekOprStime = ?)\r\n"
						+",(SELECT weekOprEtime FROM shelter WHERE weekOprEtime = ?)\r\n"
						+",(SELECT weekCellStime FROM shelter WHERE weekCellStime = ?)\r\n"
						+",(SELECT weekCellEtime FROM shelter WHERE weekCellEtime = ?)\r\n"
						+",(SELECT weekendOprStime FROM shelter WHERE weekendOprStime = ?)\r\n"
						+",(SELECT weekendOprEtime FROM shelter WHERE weekendOprEtime = ?)\r\n"
						+",(SELECT weekendCellStime FROM shelter WHERE weekendCellStime = ?)\r\n"
						+",(SELECT weekendCellEtime FROM shelter WHERE weekendCellEtime = ?)\r\n"
						+",(SELECT closeDay FROM shelter WHERE closeDay = ?)\r\n"
						+",(SELECT careTel FROM shelter WHERE careTel = ?)\r\n"
						+"\r\n"
						+ ")";
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, vo.getShelter_no());
			pstmt.setString(2, vo.getCareNm());
			pstmt.setString(3, vo.getDivisionNm());
			pstmt.setString(4, vo.getSaveTrgtAnimal());
			pstmt.setString(5, vo.getCareAddr());
			pstmt.setString(6, vo.getWeekOprStime());
			pstmt.setString(7, vo.getWeekOprEtime());
			pstmt.setString(8, vo.getWeekCellStime());
			pstmt.setString(9, vo.getWeekCellEtime());
			pstmt.setString(10, vo.getWeekendOprStime());
			pstmt.setString(11, vo.getWeekendOprEtime());
			pstmt.setString(12, vo.getWeekendCellStime());
			pstmt.setString(13, vo.getWeekendCellEtime());
			pstmt.setString(14, vo.getCloseDay());
			pstmt.setString(15, vo.getCareTel());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteShelterData(int favorites_no) {
		int result=0;
		String sql = "DELETE FROM favorites WHERE shelter_no=? ";
		
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
				pstmt.setInt(1, favorites_no);
				result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
