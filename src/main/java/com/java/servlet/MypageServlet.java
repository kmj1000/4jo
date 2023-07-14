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

import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.MypageServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class MainServlet a
 */
@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final MypageService service = MypageServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session= request.getSession(false);
      boolean SESS_AUTH = false;
      
      System.out.println(session);

      
      try {
         SESS_AUTH = (boolean)session.getAttribute("SESS_AUTH");
      }catch(Exception e) {}
      
      if( SESS_AUTH ) {
         
         request.setCharacterEncoding("utf-8");
         request.setAttribute("SESS_AUTH", false);
        
         MembersVO vo = new MembersVO();
         String email=(String) session.getAttribute("SESS_EMAIL");
         
//         System.out.println("메롱"+email);           
  
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypage.jsp");
         dispatcher.forward(request, response);
                
      } 
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}