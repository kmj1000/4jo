package com.java.servlet;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.servlet.service.CommunityService;
import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.CommunityServiceImpl;
import com.java.servlet.service.impl.MypageServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class MainServlet a
 */
@WebServlet("/mypaper")
public class MypaperServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final CommunityService service = CommunityServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypaperServlet() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session= request.getSession(true);
      boolean SESS_AUTH = true;
      
      System.out.println(session);
      
      if(session == null){
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() 
                           + "/login?msg="+msg);
         return;
      }
      
      try {
         SESS_AUTH = (boolean)session.getAttribute("SESS_AUTH");
      }catch(Exception e) {}
      
      if( SESS_AUTH ) {
         
         request.setCharacterEncoding("utf-8");
         request.setAttribute("SESS_AUTH", true);

         
         // allboard 가져와야 함.
       
         List<CommunityVO> communityMyList =service.getMyCommunity();//getAllBoardByPage
         System.out.println(communityMyList);
         request.setAttribute("communityMyList", communityMyList);
         
   
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypaper.jsp");
         dispatcher.forward(request, response);
         
       
      }else {
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() + "/login?msg="+msg);
      }      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}