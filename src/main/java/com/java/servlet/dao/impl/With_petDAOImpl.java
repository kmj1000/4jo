package com.java.servlet.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.With_petDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.With_petVO;

public class With_petDAOImpl implements With_petDAO {
	
	private static final With_petDAO instance = new With_petDAOImpl();
	
	private With_petDAOImpl() {
	}
	
	public static With_petDAO getInstance() {
		return instance;
	}

	@Override
	public List<With_petVO> selectWith_pet(int with_pet_no) {
		String sql="SELECT with_pet_no\r\n"
				+", building\r\n"
				+", category3\r\n"
				+", road\r\n"
				+", tel\r\n"
				+", homepage\r\n"
				+", day_off\r\n"
				+", hour\r\n"
				+", parking\r\n"
				+", with_pet_info\r\n"
				+", only_pet_info\r\n"
				+", pet_size\r\n"
				+", pet_limit\r\n"
				+", inside\r\n"
				+", outside\r\n"
				+", extra\r\n"
				+"FROM with_pet WHERE with_pet_no=?"
				;
		List<With_petVO>list = null;
				
				try(
					Connection conn = DBCP2Util.getConnection();	
					PreparedStatement pstmt = conn.prepareStatement(sql);
						){
					pstmt.setInt(1, with_pet_no);
					ResultSet rs = pstmt.executeQuery();
					list = new ArrayList<>();
					while(rs.next()) {
						With_petVO vo = new With_petVO();
						vo.setWith_pet_no(rs.getInt("with_pet_no"));
						vo.setBuilding(rs.getString("building"));
						vo.setCategory3(rs.getString("category3"));
						vo.setRoad(rs.getString("road"));
						vo.setTel(rs.getString("tel"));
						vo.setHomepage(rs.getString("homepage"));
						vo.setDay_off(rs.getString("day_off"));
						vo.setHour(rs.getString("hour"));
						vo.setParking(rs.getString("parking"));
						vo.setWith_pet_info(rs.getString("with_pet_info"));
						vo.setOnly_pet_info(rs.getString("only_pet_info"));
						vo.setPet_size(rs.getString("pet_size"));
						vo.setPet_limit(rs.getString("pet_limit"));
						vo.setInside(rs.getString("inside"));
						vo.setOutside(rs.getString("outside"));
						vo.setExtra(rs.getString("extra"));
						list.add(vo);
						
					}
					rs.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
		
		
		
		return list;
	}
	
	
	@Override
	public List<With_petVO> selectAllBoard() {
		
		String sql = "SELECT  with_pet_no      \r\n"
				+ "  ,            building\r\n"
				+ "               ,category3\r\n"
				+ "               ,road\r\n"
				+ "               ,tel\r\n"
				+ "           		,homepage\r\n"
				+ "           		,day_off\r\n"
				+ "           		,hour\r\n"
				+ "           		,parking \r\n"
				+ "           		,with_pet_info \r\n"
				+ "           		,only_pet_info  \r\n"
				+ "           		,pet_size  \r\n"
				+ "           		,pet_limit  \r\n"
				+ "           		,inside\r\n"
				+ "           		,outside\r\n"
				+ "           		,extra\r\n"
				+ "               FROM with_pet  \r\n"
               ;
				
				
				
			
					
		List<With_petVO> list = null;
		
		try(
				Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
				Statement stmt = conn.createStatement();
				){
				
				ResultSet rs = stmt.executeQuery(sql);
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					With_petVO vo = new With_petVO();
					vo.setWith_pet_no(rs.getInt("with_pet_no"));
					vo.setBuilding(rs.getString("building"));
					vo.setCategory3(rs.getString("category3"));
					vo.setRoad(rs.getString("road"));
					vo.setTel(rs.getString("tel"));
					vo.setHomepage(rs.getString("homepage"));
					vo.setDay_off(rs.getString("day_off"));
					vo.setHour(rs.getString("hour"));
					vo.setParking(rs.getString("parking"));
					vo.setWith_pet_info(rs.getString("with_pet_info"));
					vo.setOnly_pet_info(rs.getString("only_pet_info"));
					vo.setPet_size(rs.getString("pet_size"));
					vo.setPet_limit(rs.getString("pet_limit"));
					vo.setInside(rs.getString("inside"));
					vo.setOutside(rs.getString("outside"));
					vo.setExtra(rs.getString("extra"));
					
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
						+ "    FROM with_pet "
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
	public List<With_petVO> selectAllBoardByPage(PageMaker pageMaker) {
		String sql = "SELECT * FROM (\r\n"
				+ "				  SELECT\r\n"
				+ "				ROWNUM as rn\r\n"
				+ "				\r\n"
				+ "				,with_pet_no\r\n"
				+ "				,building\r\n"
				+ "				,category3\r\n"
				+ "                ,road\r\n"
				+ "				,tel\r\n"
				+ "				,homepage\r\n"
				+ "						,day_off\r\n"
				+ "					,hour \r\n"
				+ "					,parking \r\n"
				+ "						,with_pet_info \r\n"
				+ "						,only_pet_info \r\n"
				+ "						,pet_size\r\n"
				+ "				,pet_limit \r\n"
				+ "				,inside\r\n"
				+ "				,outside\r\n"
				+ "				,extra\r\n"
				+ "					FROM with_pet \r\n"
				+ "				WHERE ROWNUM <= ( ? * ? )  \r\n"
				+ "                       )\r\n"
				+ "				  WHERE rn > ( ( ? - 1 ) * ? )  \r\n"
				+ "				"
				;
		
		List<With_petVO> list = null;
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
					With_petVO vo = new With_petVO();
					vo.setWith_pet_no(rs.getInt("with_pet_no"));
					vo.setBuilding(rs.getString("building"));
					vo.setCategory3(rs.getString("category3"));
					vo.setRoad(rs.getString("road"));
					vo.setTel(rs.getString("tel"));
					vo.setHomepage(rs.getString("homepage"));
					vo.setDay_off(rs.getString("day_off"));
					vo.setHour(rs.getString("hour"));
					vo.setParking(rs.getString("parking"));
					vo.setWith_pet_info(rs.getString("with_pet_info"));
					vo.setOnly_pet_info(rs.getString("only_pet_info"));
					vo.setPet_size(rs.getString("pet_size"));
					vo.setPet_limit(rs.getString("pet_limit"));
					vo.setInside(rs.getString("inside"));
					vo.setOutside(rs.getString("outside"));
					vo.setExtra(rs.getString("extra"));
					
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
