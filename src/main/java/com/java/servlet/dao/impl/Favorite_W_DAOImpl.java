package com.java.servlet.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.Favorite_W_DAO;

import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;

import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_W_VO;

public class Favorite_W_DAOImpl implements Favorite_W_DAO {
   
   private static final Favorite_W_DAO instance = new Favorite_W_DAOImpl();
   
   private Favorite_W_DAOImpl() {
   }
   
   public static Favorite_W_DAO getInstance() {
      return instance;
   }

   @Override
   public List<Favorite_W_VO> selectWithPetBoard() {
      
      String sql = "SELECT f.favoritew_no\r\n"
        		+ "     , f.favoritew_reg_date\r\n"
          		+ "     , w.with_pet_no\r\n"
          		+ "     , w.building\r\n"
          		+ "     , w.road\r\n"
          		+ "     , s.tel\r\n"
          		+ "     , (SELECT nickname FROM members WHERE nickname = f.nickname) as nickname\r\n"
          		+ "FROM favorites f\r\n"
          		+ "JOIN with_pet w ON f.with_pet_no = w.with_pet_no\r\n"
               ;
      List<Favorite_W_VO> list = null;
      
      try(
            Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
            Statement stmt = conn.createStatement();
            ){
            
            ResultSet rs = stmt.executeQuery(sql);
            
            list = new ArrayList<>();
            
            while( rs.next() ) {
            	Favorite_W_VO vo = new Favorite_W_VO();
               vo.setFavoritew_no(rs.getInt("favoritew_no"));
               vo.setFavoritew_reg_date(rs.getDate("favoritew_reg_date"));
               vo.setNickname(rs.getString("nickname"));
               vo.setWith_pet_no(rs.getInt("with_pet_no"));
               vo.setBuilding(rs.getString("building"));
               vo.setRoad(rs.getString("road"));
               vo.setTel(rs.getString("tel"));
              
               
               list.add(vo);
            }
                rs.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      return list;
   }

   @Override
   public int seletCountWithPetBoard() {
      int result = 0;
      String sql = "SELECT COUNT(1) \r\n"
                  + "    FROM favoritew"
               ;
      try{
            Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if( rs.next() ) {
               result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
         
      return result;
   }

   @Override
   public List<Favorite_W_VO> selectWithPetBoardByPage(PageMaker pageMaker) {
      String sql = "SELECT \r\n"
              + "favoritew_no\r\n"
              + ",favoritew_reg_date\r\n"
              + ",with_pet_no\r\n"
              + ",building\r\n"
              + ",road\r\n"
              + ",tel\r\n"
              + ",(SELECT nickname FROM members WHERE nickname='aa') as nickname\r\n"
              + "FROM (\r\n"
              + "SELECT /*+ INDEX (favoritew index_favoritew_no_pk) */\r\n"
              + "ROWNUM as rn\r\n"
              +",f.favoritew_no\r\n"
        		+ ", f.favoritew_reg_date\r\n"
        		+ ", w.with_pet_no\r\n"
        		+ ", w.building\r\n"
        		+ ", w.road\r\n"
        		+ ", w.tel\r\n"
        		+ ", (SELECT nickname FROM members WHERE nickname = f.nickname) as nickname\r\n"
        		+"FROM favoritew f\r\n"
        		+"JOIN with_pet w ON f.with_pet_no = w.with_pet_no\r\n"
        		+ "WHERE ROWNUM <= ( ? * ? )\r\n"
        		+ "            )\r\n"
        		+ "    WHERE rn > ( ( ? - 1 ) * ? )"
            ;
      
      List<Favorite_W_VO> list = null;
      
      try(
            Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ){
         
         pstmt.setInt(1, pageMaker.getCri().getPageNum());
         pstmt.setInt(2, pageMaker.getCri().getAmount());
         pstmt.setInt(3, pageMaker.getCri().getPageNum());
         pstmt.setInt(4, pageMaker.getCri().getAmount());
         
         ResultSet rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while( rs.next() ) {
            	Favorite_W_VO vo = new Favorite_W_VO();
            	
            	vo.setFavoritew_no(rs.getInt("favoritew_no"));
                vo.setFavoritew_reg_date(rs.getDate("favoritew_reg_date"));
                vo.setNickname(rs.getString("nickname"));
                vo.setWith_pet_no(rs.getInt("with_pet_no"));
                vo.setBuilding(rs.getString("building"));
                vo.setRoad(rs.getString("road"));
                vo.setTel(rs.getString("tel"));
               
               list.add(vo);
            }
                rs.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      return list;
   }
   
   
}