package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.MypageDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MembersVO;

public class MypageDAOImpl implements MypageDAO {

	@Override
	public List<MembersVO> selectMembers() {
		List<MembersVO> memberList = null;
		
		String sql = "select nickname\r\n"
				+ "        , email\r\n"
				+ "        , name\r\n"
				+ "        , phone \r\n"
				+ "        from members"
				;
		
		try(
				Connection connection = DataBaseUtil.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		){
			memberList = new ArrayList();
			
			while(rs.next()) {
				MembersVO vo = new MembersVO();
//				vo.setM_no	( rs.getInt(1) 	);
//				vo.setName	( rs.getString(2) );
//				vo.setJumin	( rs.getString(3) );
//				vo.setId	( rs.getString(4) );
				memberList.add(vo);
			}
			
			//DataBaseUtil.destroyConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	

}
