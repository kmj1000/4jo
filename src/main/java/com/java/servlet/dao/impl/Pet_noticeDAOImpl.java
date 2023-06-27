package com.java.servlet.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.Pet_noticeDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Pet_noticeVO;

public class Pet_noticeDAOImpl implements Pet_noticeDAO {
	
	private static final Pet_noticeDAO instance = new Pet_noticeDAOImpl();
	
	private Pet_noticeDAOImpl() {
	}
	
	public static Pet_noticeDAO getInstance() {
		return instance;
	}

	@Override
	public List<Pet_noticeVO> selectAllBoard() {
		
		String sql = "SELECT      \r\n"
				+ "              happenDt\r\n"
				+ "               ,happenPlace\r\n"
				+ "               ,kindCd\r\n"
				+ "               ,colorCd\r\n"
				+ "           		,age\r\n"
				+ "           		,weight\r\n"
				+ "           		,noticeNo \r\n"
				+ "           		,noticeSdt \r\n"
				+ "           		,noticeEdt  \r\n"
				+ "           		,popfile  \r\n"
				+ "           		,processState  \r\n"
				+ "           		,sexCd\r\n"
				+ "           		,neuterYn\r\n"
				+ "           		,specialMark\r\n"
				+ "           		,careNm\r\n"
				+ "           		,careTel\r\n"
				+ "           		,careAddr\r\n"
				+ "               FROM pet_notice  \r\n"
			
               ;
	
		List<Pet_noticeVO> list = null;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
				Statement stmt = conn.createStatement();
				){
				
				ResultSet rs = stmt.executeQuery(sql);
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					Pet_noticeVO vo = new Pet_noticeVO();
					
					vo.setHappenDt(rs.getString("happenDt"));
					vo.setHappenPlace(rs.getString("happenPlace"));
					vo.setKindCd(rs.getString("kindCd"));
					vo.setColorCd(rs.getString("colorCd"));
					vo.setAge(rs.getString("age"));
					vo.setWeight(rs.getString("weight"));
					vo.setNoticeNo(rs.getString("noticeNo"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processState"));
					vo.setSexCd(rs.getString("sexCd"));
					vo.setNeuterYn(rs.getString("neuterYn"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setCareNm(rs.getString("careNm"));
					vo.setCareTel(rs.getString("careTel"));
					vo.setCareAddr(rs.getString("careAddr"));
					
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
						+ "    FROM pet_notice "
					;
		try(	Connection conn = DataBaseUtil.getConnection(); // DBCP2Util, DataBaseUtil
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
	public List<Pet_noticeVO> selectAllBoardByPage(PageMaker pageMaker) {
		String sql = "SELECT * FROM (\r\n"
				+ "				   SELECT\r\n"
				+ "				  ROWNUM as rn\r\n"
				+ "				  \r\n"
				+ "              ,happenDt\r\n"
				+ "               ,happenPlace\r\n"
				+ "               ,kindCd\r\n"
				+ "               ,colorCd\r\n"
				+ "           		,age\r\n"
				+ "           		,weight\r\n"
				+ "           		,noticeNo \r\n"
				+ "           		,noticeSdt \r\n"
				+ "           		,noticeEdt  \r\n"
				+ "           		,popfile  \r\n"
				+ "           		,processState  \r\n"
				+ "           		,sexCd\r\n"
				+ "           		,neuterYn\r\n"
				+ "           		,specialMark\r\n"
				+ "           		,careNm\r\n"
				+ "           		,careTel\r\n"
				+ "           		,careAddr\r\n"
				+ "				 FROM  pet_notice \r\n"
				+ "				 WHERE ROWNUM <= ( ? * ? )   \r\n"
				+ "				          )\r\n"
				+ "				   WHERE rn > ( ( ? - 1 ) * ? ) \r\n"
				+ "				"
				;
		
		List<Pet_noticeVO> list = null;
		ResultSet rs = null;
		try(	Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setInt(1, pageMaker.getCri().getPageNum());
			pstmt.setInt(2, pageMaker.getCri().getAmount());
			pstmt.setInt(3, pageMaker.getCri().getPageNum());
			pstmt.setInt(4, pageMaker.getCri().getAmount());
			
			rs = pstmt.executeQuery();
				
				list = new ArrayList<>();
				
				while( rs.next() ) {
					Pet_noticeVO vo = new Pet_noticeVO();
				
					vo.setHappenDt(rs.getString("happenDt"));
					vo.setHappenPlace(rs.getString("happenPlace"));
					vo.setKindCd(rs.getString("kindCd"));
					vo.setColorCd(rs.getString("colorCd"));
					vo.setAge(rs.getString("age"));
					vo.setWeight(rs.getString("weight"));
					vo.setNoticeNo(rs.getString("noticeNo"));
					vo.setNoticeSdt(rs.getString("noticeSdt"));
					vo.setNoticeEdt(rs.getString("noticeEdt"));
					vo.setPopfile(rs.getString("popfile"));
					vo.setProcessState(rs.getString("processState"));
					vo.setSexCd(rs.getString("sexCd"));
					vo.setNeuterYn(rs.getString("neuterYn"));
					vo.setSpecialMark(rs.getString("specialMark"));
					vo.setCareNm(rs.getString("careNm"));
					vo.setCareTel(rs.getString("careTel"));
					vo.setCareAddr(rs.getString("careAddr"));
					
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
