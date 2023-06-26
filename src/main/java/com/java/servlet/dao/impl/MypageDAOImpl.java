package com.java.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
               + "        ,nickname --scalar 쿼리\r\n"
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
   public int seletCountAllBoard() {
      int result = 0;
      String sql = "SELECT COUNT(1) \r\n"
                  + "    FROM members"
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
   public List<MembersVO> selectAllBoardByPage(PageMaker pageMaker) {
      String sql = "SELECT \r\n"
            + "        * \r\n"
            + "    FROM (\r\n"
            + "            SELECT /*+ INDEX (favorites index_favorites_no_pk) */\r\n"
            + "                    ROWNUM as rn\r\n"
            + "                    ,name\r\n"
            + "                    ,email\r\n"
            + "                    ,pwd\r\n"
            + "                    ,phone\r\n"
            + "                    ,(SELECT nickname FROM members WHERE nickname='aa') as nickname\r\n"
            + "                FROM members\r\n"
            + "                WHERE ROWNUM <= ( ? * ? )   -- page 1=10, 2=20, 3=30  page * 10, 10: 페이지당 게시글 갯수\r\n"
            + "            )\r\n"
            + "    WHERE rn > ( ( ? - 1 ) * ? )"
            ;
      
      List<MembersVO> list = null;
      
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
   
   
}