package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.MembersDAO;
import com.java.servlet.dao.MypageDAO;

import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.MembersVO;

public class MypageDAOImpl implements MypageDAO {
   
   private static final MypageDAO instance = new MypageDAOImpl();
   
   private MypageDAOImpl() {
   }
   
   public static MypageDAO getInstance() {
      return instance;
   }

   @Override
   public List<MembersVO> selectAllBoard() {
      
      String sql = "SELECT name\r\n"
               + "        ,email\r\n"
               + "        ,pwd\r\n"
               + "        ,phone\r\n"
               + "        ,nickname\r\n"
               + "    FROM members"
               ;
      List<MembersVO> list = null;
      
      try(
            Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
            Statement stmt = conn.createStatement();
            ){
            
            ResultSet rs = stmt.executeQuery(sql);
            
            list = new ArrayList<>();
            
            while( rs.next() ) {
            	MembersVO vo = new MembersVO();
            	 vo.setName(rs.getString("name"));
                 vo.setEmail(rs.getString("email"));
                 vo.setPwd(rs.getString("pwd"));
                 vo.setPhone(rs.getInt("phone"));
                 vo.setNickname(rs.getString("nickname"));
                 
              
               
               list.add(vo);
            }
                rs.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      return list;
   }

   @Override
	public int updatePwd(MembersVO vo) {
		int result = 0;
		String sql = "UPDATE members\r\n"
				+ "    SET pwd = ?\r\n"
				+ "    WHERE email = ?"
				;
		try(
				Connection conn = DataBaseUtil.getConnection();// DBCP2Util
				PreparedStatement ps = conn.prepareStatement(sql);
				){
				
				ps.setString(1, vo.getPwd());
				ps.setString(2, vo.getEmail());
				System.out.println(result);
				result = ps.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

