package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

	   private final static NoticeDAO instance = new NoticeDAOImpl();
	   private NoticeDAOImpl() {
	   }
	   public static NoticeDAO getInstance() {
	      return instance;
	   }
	   
	@Override
	public NoticeVO selectNotice(String nickname) {
		
		String sql = "SELECT notice_no\r\n"
	            + "        ,notice_title\r\n"
	            + "        ,notice_content\r\n"
	            + "        ,notice_reg_date\r\n"
	            + "        ,select nickname from members where nickname='관리자' as nickname\r\n"
	            + "     FROM notice"
	            ;
	      NoticeVO vo = null;
	      
	      try(
	            Connection conn = DBCP2Util.getConnection();// DBCP2Util
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ){
	            
				pstmt.setString(1, nickname);
	         
	            ResultSet rs = pstmt.executeQuery();
	            
	            if( rs.next() ) {
	               vo = new NoticeVO();
	               vo.setNotice_no(rs.getInt("Notice_no"));
	               vo.setNickname(rs.getString("nickname"));
	               vo.setNotice_title(rs.getString("notice_title"));
	               vo.setNotice_content(rs.getString("notice_content"));
	               vo.setNotice_reg_date(rs.getDate("notice_reg_date"));
	            }
	            rs.close();
	            
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return vo;
	}
	@Override
	public List<NoticeVO> selectAllNotice() {
		 String sql = "SELECT notice_no\r\n" + "        "
		            + ",notice_title\r\n" + "        "
		            + ",notice_content\r\n" + "        "
		            + ",notice_reg_date\r\n"
		            + "        ,(SELECT admin_name FROM admin) as admin_name\r\n"
		            + "    FROM notice";
		      List<NoticeVO> list = null;

		      try (Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DataBaseUtil
		            Statement stmt = conn.createStatement();) {

		         ResultSet rs = stmt.executeQuery(sql);

		         list = new ArrayList<>();

		         while (rs.next()) {
		        	NoticeVO vo = new NoticeVO();
		            vo.setNotice_no(rs.getInt("notice_no"));
		            vo.setNickname(rs.getString("nickname"));
		            vo.setNotice_title(rs.getString("notice_title"));
		           // vo.setContent(rs.getString("content"));
		            vo.setNotice_reg_date(rs.getDate("notice_reg_date"));

		            list.add(vo);
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return list;
		   }

	@Override
	public int selectCountAllNotice() {
		int result = 0;
	      String sql = "SELECT COUNT(1) \r\n" + "    FROM notice ";
	      try {
	         Connection conn = DBCP2Util.getConnection();// DBCP2Util, DataBaseUtil
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);

	         if (rs.next()) {
	            result = rs.getInt(1);
	         }
	         rs.close();
	         stmt.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return result;
	   }
	@Override
	public List<NoticeVO> selectAllNoticeByPage(PageMaker pageMaker) {
		String sql = "SELECT \r\n" + "        * \r\n" + "    FROM (\r\n"
	            + "            SELECT /*+ INDEX ( index_noticeno_pk) */\r\n"
	            + "                    ROWNUM as rn\r\n" + "                    ,notice_no\r\n"
	            + "                    ,notice_title\r\n" + "                    ,notice_content\r\n"
	            + "                    ,notice_reg_date\r\n"
	            + "                    ,(select nickname from members where nickname='관리자') as nickname\r\n"
	            + "                FROM notice\r\n"
	            + "                WHERE ROWNUM <= ( ? * ? )   -- page 1=10, 2=20, 3=30  page * 10, 10: 페이지당 게시글 갯수\r\n"
	            + "            )\r\n" + "    WHERE rn > ( ( ? - 1 ) * ? )";

	      List<NoticeVO> list = null;

	      try (Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DataBaseUtil
	            PreparedStatement pstmt = conn.prepareStatement(sql);) {

	         pstmt.setInt(1, pageMaker.getCri().getPageNum());
	         pstmt.setInt(2, pageMaker.getCri().getAmount());
	         pstmt.setInt(3, pageMaker.getCri().getPageNum());
	         pstmt.setInt(4, pageMaker.getCri().getAmount());

	         ResultSet rs = pstmt.executeQuery();

	         list = new ArrayList<>();

	         while (rs.next()) {
	            NoticeVO vo = new NoticeVO();
	            vo.setNotice_no(rs.getInt("notice_no"));
	            vo.setNotice_title(rs.getString("notice_title"));
	            vo.setNotice_reg_date(rs.getDate("notice_reg_date"));
	            vo.setNickname(rs.getString("nickname"));
	            

	            list.add(vo);
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	      return list;
	   }
	@Override
	public NoticeVO selectNotice(int notice_no) {
		String sql = "SELECT notice_no\r\n"
	            + "        ,notice_title\r\n"
	            + "        ,notice_content\r\n"
	            + "        ,notice_reg_date\r\n"
	            + "        ,nickname\r\n"
	            + "     FROM notice"
	            ;
	      NoticeVO vo = null;
	      
	      try(
	            Connection conn = DBCP2Util.getConnection();// DBCP2Util
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ){
	            
				pstmt.setInt(1, notice_no);
	         
	            ResultSet rs = pstmt.executeQuery();
	            
	            if( rs.next() ) {
	               vo = new NoticeVO();
	               vo.setNotice_no(rs.getInt("Notice_no"));
	               vo.setNickname(rs.getString("nickname"));
	               vo.setNotice_title(rs.getString("notice_title"));
	               vo.setNotice_content(rs.getString("notice_content"));
	               vo.setNotice_reg_date(rs.getDate("notice_reg_date"));
	            }
	            rs.close();
	            
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      return vo;
	}
	
}
