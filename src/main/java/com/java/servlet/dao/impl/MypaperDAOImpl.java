package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.MypaperDAO;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.CommunityVO;

public class MypaperDAOImpl implements MypaperDAO {
	private final static MypaperDAO instance = new MypaperDAOImpl();
	public static MypaperDAO getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}
	@Override
	public List<CommunityVO> selectMypaper(String nickname) {
		String sql = "SELECT c_no\r\n" + "        "
	            + ",title\r\n" + "        "
	            + ",content\r\n" + "        "
	            + ",reg_date\r\n"
	            + ",nickname\r\n"
	            + "    FROM community where nickname=?";
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
	public List<CommunityVO> selectMypaper() {
		// TODO Auto-generated method stub
		return null;
	}



}
