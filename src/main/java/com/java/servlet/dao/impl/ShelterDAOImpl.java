package com.java.servlet.dao.impl;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.ShelterDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.ShelterVO;

public class ShelterDAOImpl implements ShelterDAO {
	
	private static final ShelterDAO instance = new ShelterDAOImpl();
	
	private ShelterDAOImpl() {
	}
	
	public static ShelterDAO getInstance() {
		return instance;
	}

	@Override
	public List<ShelterVO> selectShelter(int shelter_no) {
		
			String sql ="SELECT      \r\n"
					+ "              shelter_no\r\n"
					+ "              ,careNm\r\n"
					+ "               ,divisionNm\r\n"
					+ "               ,saveTrgtAnimal\r\n"
					+ "               ,careAddr\r\n"
					+ "           		,weekOprStime\r\n"
					+ "           		,weekOprEtime\r\n"
					+ "           		,weekCellStime \r\n"
					+ "           		,weekCellEtime \r\n"
					+ "           		,weekendOprStime  \r\n"
					+ "           		,weekendOprEtime  \r\n"
					+ "           		,weekendCellStime  \r\n"
					+ "           		,weekendCellEtime\r\n"
					+ "           		,closeDay\r\n"
					+ "           		,careTel\r\n"
					+ "               FROM shelter where shelter_no=?\r\n";
			List<ShelterVO> list = null;
			
			try(
					Connection conn = DBCP2Util.getConnection();// DBCP2Util
					PreparedStatement pstmt = conn.prepareStatement(sql);
					){
					pstmt.setInt(1, shelter_no); 
					list = new ArrayList<>();
					ResultSet rs = pstmt.executeQuery();
					
					while( rs.next() ) {
						ShelterVO vo = new ShelterVO();
						vo.setShelter_no(rs.getInt("shelter_no"));
						vo.setCareNm(rs.getString("careNm"));
						vo.setDivisionNm(rs.getString("divisionNm"));
						vo.setSaveTrgtAnimal(rs.getString("saveTrgtAnimal"));
						vo.setCareAddr(rs.getString("careAddr"));
						vo.setWeekOprStime(rs.getString("weekOprStime"));
						vo.setWeekOprEtime(rs.getString("weekOprEtime"));
						vo.setWeekCellStime(rs.getString("weekCellStime"));
						vo.setWeekCellEtime(rs.getString("weekCellEtime"));
						vo.setWeekendOprEtime(rs.getString("weekendOprStime"));
						vo.setWeekendOprEtime(rs.getString("weekendOprEtime"));
						vo.setWeekendCellStime(rs.getString("weekendCellStime"));
						vo.setWeekendCellEtime(rs.getString("weekendCellEtime"));
						vo.setCloseDay(rs.getString("closeDay"));
						vo.setCareTel(rs.getString("careTel"));
						
						list.add(vo);
					}
					rs.close();
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
	
	
	
	
	@Override
	public List<ShelterVO> selectAllBoard() {
		
		String sql = "SELECT      \r\n"
				+ "              shelter_no\r\n"
				+ "              ,careNm\r\n"
				+ "               ,divisionNm\r\n"
				+ "               ,saveTrgtAnimal\r\n"
				+ "               ,careAddr\r\n"
				+ "           		,weekOprStime\r\n"
				+ "           		,weekOprEtime\r\n"
				+ "           		,weekCellStime \r\n"
				+ "           		,weekCellEtime \r\n"
				+ "           		,weekendOprStime  \r\n"
				+ "           		,weekendOprEtime  \r\n"
				+ "           		,weekendCellStime  \r\n"
				+ "           		,weekendCellEtime\r\n"
				+ "           		,closeDay\r\n"
				+ "           		,careTel\r\n"
				+ "               FROM shelter\r\n"
			
               ;
				
				
				
			
					
		List<ShelterVO> list = null;
		
		try(
				Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
				Statement stmt = conn.createStatement();
				){
				
				ResultSet rs = stmt.executeQuery(sql);
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					ShelterVO vo = new ShelterVO();
					vo.setShelter_no(rs.getInt("shelter_no"));
					vo.setCareNm(rs.getString("careNm"));
					vo.setDivisionNm(rs.getString("divisionNm"));
					vo.setSaveTrgtAnimal(rs.getString("saveTrgtAnimal"));
					vo.setCareAddr(rs.getString("careAddr"));
					vo.setWeekOprStime(rs.getString("weekOprStime"));
					vo.setWeekOprEtime(rs.getString("weekOprEtime"));
					vo.setWeekCellStime(rs.getString("weekCellStime"));
					vo.setWeekCellEtime(rs.getString("weekCellEtime"));
					vo.setWeekendOprEtime(rs.getString("weekendOprStime"));
					vo.setWeekendOprEtime(rs.getString("weekendOprEtime"));
					vo.setWeekendCellStime(rs.getString("weekendCellStime"));
					vo.setWeekendCellEtime(rs.getString("weekendCellEtime"));
					vo.setCloseDay(rs.getString("closeDay"));
					vo.setCareTel(rs.getString("careTel"));
					
					list.add(vo);
				}
				rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int seletCountAllBoard() {
		int result = 0;
		String sql = "SELECT COUNT(1) \r\n"
						+ "    FROM shelter "
					;
		try(	Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DataBaseUtil
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
				
				if( rs.next() ) {
					result = rs.getInt(1);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
			
		return result;
	}

	@Override
	public List<ShelterVO> selectAllBoardByPage(PageMaker pageMaker) {
		String sql = "SELECT * FROM (\r\n"
				+ "				   SELECT\r\n"
				+ "				  ROWNUM as rn\r\n"
				+ "				  \r\n"
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
				+ "				 FROM  shelter \r\n"
				+ "				 WHERE ROWNUM <= ( ? * ? )   \r\n"
				+ "				          )\r\n"
				+ "				   WHERE rn > ( ( ? - 1 ) * ? ) \r\n"
				;
		
		List<ShelterVO> list = null;
		ResultSet rs = null;
		try(	Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, pageMaker.getCri().getPageNum());
			pstmt.setInt(2, pageMaker.getCri().getAmount());
			pstmt.setInt(3, pageMaker.getCri().getPageNum());
			pstmt.setInt(4, pageMaker.getCri().getAmount());
			
			rs = pstmt.executeQuery();
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					ShelterVO vo = new ShelterVO();
					vo.setShelter_no(rs.getInt("shelter_no"));
					vo.setCareNm(rs.getString("careNm"));
					vo.setDivisionNm(rs.getString("divisionNm"));
					vo.setSaveTrgtAnimal(rs.getString("saveTrgtAnimal"));
					vo.setCareAddr(rs.getString("careAddr"));
					vo.setWeekOprStime(rs.getString("weekOprStime"));
					vo.setWeekOprEtime(rs.getString("weekOprEtime"));
					vo.setWeekCellStime(rs.getString("weekCellStime"));
					vo.setWeekCellEtime(rs.getString("weekCellEtime"));
					vo.setWeekendOprEtime(rs.getString("weekendOprStime"));
					vo.setWeekendOprEtime(rs.getString("weekendOprEtime"));
					vo.setWeekendCellStime(rs.getString("weekendCellStime"));
					vo.setWeekendCellEtime(rs.getString("weekendCellEtime"));
					vo.setCloseDay(rs.getString("closeDay"));
					vo.setCareTel(rs.getString("careTel"));
					
					list.add(vo);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) { try {	rs.close();		 	} catch (SQLException e) {} }
			//if(pstmt != null) { try {	pstmt.close();	} catch (SQLException e) {} }
			/* if(conn != null) { try { conn.close(); } catch (SQLException e) {} } */
		}
		return list;
	}

	
	
	
}
