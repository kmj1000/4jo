package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.CommunityDAO;
import com.java.servlet.dao.NoticeDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;

public class CommunityDAOImpl implements CommunityDAO {
    private final static CommunityDAO instance = new CommunityDAOImpl();
	private CommunityDAOImpl() {
	}
	public static CommunityDAO getInstance() {
	     return instance;
	}
	@Override
	public CommunityVO selectCommunity(int c_no) {
		
		String sql = "SELECT c_no\r\n"
		            + "        ,title\r\n"
		            + "        ,content\r\n"
		            + "        ,reg_date\r\n"
		            + "        ,(SELECT nickname FROM members) as nickname\r\n"
		            + "    FROM community WHERE c_no = ?"
		            ;
		      CommunityVO vo = null;
		      
		      try {
		            Connection conn = DataBaseUtil.getConnection();// DBCP2Util
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            
		            
					pstmt.setInt(1, c_no);
		         
		            ResultSet rs = pstmt.executeQuery();
		            
		            if( rs.next() ) {
		               vo = new CommunityVO();
		               vo.setC_no(rs.getInt("c_no"));
		               vo.setNickname(rs.getString("nickname"));
		               vo.setTitle(rs.getString("title"));
		               vo.setContent(rs.getString("content"));
		               vo.setReg_date(rs.getDate("reg_date"));
		            }
		            rs.close();
		            
		      }catch(Exception e) {
		         e.printStackTrace();
		      }
		      
		      return vo;
		
	}
	@Override
	public List<CommunityVO> selectAllCommunity() {
		 String sql = "SELECT c_no\r\n" + "        "
		            + ",title\r\n" + "        "
		            + ",content\r\n" + "        "
		            + ",reg_date\r\n"
		            + "        ,(SELECT nickname FROM members) as nickname\r\n"
		            + "    FROM community";
		      List<CommunityVO> list = null;

		      try (Connection conn = DataBaseUtil.getConnection(); // DBCP2Util, DataBaseUtil
		            Statement stmt = conn.createStatement();) {

		         ResultSet rs = stmt.executeQuery(sql);

		         list = new ArrayList<>();

		         while (rs.next()) {
		        	CommunityVO vo = new CommunityVO();
		            vo.setC_no(rs.getInt("c_no"));
		            vo.setNickname(rs.getString("nickname"));
		            vo.setTitle(rs.getString("title"));
		           // vo.setContent(rs.getString("content"));
		            vo.setReg_date(rs.getDate("reg_date"));

		            list.add(vo);
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return list;
		   }

	@Override
	public int selectCountAllCommunity() {
		int result = 0;
	      String sql = "SELECT COUNT(1) \r\n" + "    FROM community ";
	      try {
	         Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
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
	public List<CommunityVO> selectAllCommunityByPage(PageMaker pageMaker) {
		 String sql = "SELECT \r\n" + "        * \r\n" + "    FROM (\r\n"
		            + "            SELECT /*+ INDEX (index_cno_pk) */\r\n"
		            + "                    ROWNUM as rn\r\n" + "                    ,c_no\r\n"
		            + "                    ,title\r\n" + "                    ,content\r\n"
		            + "                    ,reg_date\r\n"
		            + "                    ,(select nickname from members where nickname='민주') as nickname\r\n"
		            + "                FROM community\r\n"
		            + "                WHERE ROWNUM <= ( ? * ? )   -- page 1=10, 2=20, 3=30  page * 10, 10: 페이지당 게시글 갯수\r\n"
		            + "            )\r\n" + "    WHERE rn > ( ( ? - 1 ) * ? )";

		      List<CommunityVO> list = null;

		      try (Connection conn = DataBaseUtil.getConnection(); // DBCP2Util, DataBaseUtil
		            PreparedStatement pstmt = conn.prepareStatement(sql);) {

		         pstmt.setInt(1, pageMaker.getCri().getPageNum());
		         pstmt.setInt(2, pageMaker.getCri().getAmount());
		         pstmt.setInt(3, pageMaker.getCri().getPageNum());
		         pstmt.setInt(4, pageMaker.getCri().getAmount());

		         ResultSet rs = pstmt.executeQuery();

		         list = new ArrayList<>();

		         while (rs.next()) {
		            CommunityVO vo = new CommunityVO();
		            vo.setC_no(rs.getInt("c_no"));
		            vo.setTitle(rs.getString("title"));
		            vo.setNickname(rs.getString("nickname"));
		            vo.setReg_date(rs.getDate("reg_date"));

		            list.add(vo);
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return list;
		   }
	
}
