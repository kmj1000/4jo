package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.servlet.dao.NoticeApiDAO;
import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.NoticeVO;

public class NoticeApiDAOImpl implements NoticeApiDAO {
	private final static NoticeApiDAO instance = new NoticeApiDAOImpl();
	private  NoticeApiDAOImpl() {
		
	}
	public static NoticeApiDAO getInstance(){
		return instance;
	}
	@Override
	public int insertNotice(NoticeVO vo) {
		int result=0;
		String sql = "INSERT INTO notice(\r\n"
				+"notice_no \r\n"
				+",notice_title \r\n"
				+",notice_content \r\n"
				+",notice_reg_date \r\n"
				+",nickname) \r\n"
				+"VALUES(\r\n"
				+"seq_notice_no.nextval \r\n"
				+",? \r\n"
				+",? \r\n"
				+",sysdate"
				+",(SELECT nickname FROM members where nickname='관리자')\r\n"
				+")"
				;
				try(
						Connection conn = DataBaseUtil.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						){
					pstmt.setString(1, vo.getNotice_title());
					pstmt.setString(2, vo.getNotice_content());
					pstmt.setInt(3, vo.getNotice_no());
					
					result= pstmt.executeUpdate();
				}catch(Exception e) {
					e.printStackTrace();
				}
		
		return result;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		int result=0;
		String sql = "UPDATE notice\r\n"
				+"set notice_title=?"
				+",notice_content=?"
				+"WHERE notice_no =?"
				;
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			pstmt.setString(1, vo.getNotice_title());
			pstmt.setString(2, vo.getNotice_content());
			pstmt.setInt(3, vo.getNotice_no());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int removeNotice(int notice_no) {
		int result=0;
		String sql="DELETE FROM notice(\r\n"
				+"WHERE notice_no=?";
		try(
				Connection conn = DataBaseUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			pstmt.setInt(1, notice_no);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
