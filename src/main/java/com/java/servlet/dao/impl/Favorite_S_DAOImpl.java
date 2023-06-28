package com.java.servlet.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.servlet.dao.Favorite_S_DAO;

import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_S_VO;

public class Favorite_S_DAOImpl implements Favorite_S_DAO {
   
   private static final Favorite_S_DAO instance = new Favorite_S_DAOImpl();
   
   private Favorite_S_DAOImpl() {
   }
   
   public static Favorite_S_DAO getInstance() {
      return instance;
   }

   @Override
   public List<Favorite_S_VO> selectShelterBoard() {
      
      String sql = "SELECT f.favorites_no\r\n"
      		+ "     , f.favorites_reg_date\r\n"
      		+ "     , s.shelter_no\r\n"
      		+ "     , s.careNm\r\n"
      		+ "     , s.careAddr\r\n"
      		+ "     , s.careTel\r\n"
      		+ "     , (SELECT nickname FROM members WHERE nickname = f.nickname) as nickname\r\n"
      		+ "FROM favorites f\r\n"
      		+ "JOIN shelter s ON f.shelter_no = s.shelter_no\r\n"
               ;
      List<Favorite_S_VO> list = null;
      
      try(
            Connection conn = DataBaseUtil.getConnection();// DBCP2Util, DataBaseUtil
            Statement stmt = conn.createStatement();
            ){
            
            ResultSet rs = stmt.executeQuery(sql);
            
            list = new ArrayList<>();
            
            while( rs.next() ) {
            	Favorite_S_VO vo = new Favorite_S_VO();
            	 vo.setFavorites_no(rs.getInt("favorites_no"));
                 vo.setNickname(rs.getString("nickname"));
                 vo.setFavorites_reg_date(rs.getDate("favorites_reg_date"));
                 vo.setShelter_no(rs.getInt("shelter_no"));
                 vo.setCareNm(rs.getString("careNm"));
                 vo.setCareAddr(rs.getString("careAddr"));
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
   public int seletCountShelterBoard() {
      int result = 0;
      String sql = "SELECT COUNT(1) \r\n"
                  + "    FROM favorites"
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
   public List<Favorite_S_VO> selectShelterBoardByPage(PageMaker pageMaker) {
      String sql = "SELECT \r\n"
              + "favorites_no\r\n"
              + ",favorites_reg_date\r\n"
              + ",shelter_no\r\n"
              + ",careNm\r\n"
              + ",careAddr\r\n"
              + ",careTel\r\n"
              + ",(SELECT nickname FROM members WHERE nickname='aa') as nickname\r\n"
              + "FROM (\r\n"
              + "SELECT /*+ INDEX (favorites index_favorites_no_pk) */\r\n"
              + "ROWNUM as rn\r\n"
              +",f.favorites_no\r\n"
        		+ ", f.favorites_reg_date\r\n"
        		+ ", s.shelter_no\r\n"
        		+ ", s.careNm\r\n"
        		+ ", s.careAddr\r\n"
        		+ ", s.careTel\r\n"
        		+ ", (SELECT nickname FROM members WHERE nickname = f.nickname) as nickname\r\n"
        		+"FROM favorites f\r\n"
        		+"JOIN shelter s ON f.shelter_no = s.shelter_no\r\n"
        		+ "WHERE ROWNUM <= ( ? * ? )\r\n"
        		+ "            )\r\n"
        		+ "    WHERE rn > ( ( ? - 1 ) * ? )"
            ;
      
      List<Favorite_S_VO> list = null;
      
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
            	Favorite_S_VO vo = new Favorite_S_VO();
            	
                vo.setFavorites_no(rs.getInt("favorites_no"));
                vo.setNickname(rs.getString("nickname"));
                vo.setFavorites_reg_date(rs.getDate("favorites_reg_date"));
                vo.setShelter_no(rs.getInt("shelter_no"));
                vo.setCareNm(rs.getString("careNm"));
                vo.setCareAddr(rs.getString("careAddr"));
                vo.setCareTel(rs.getString("careTel"));
               
               list.add(vo);
            }
                rs.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      
      return list;
   }
   
   
}