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
        
         MembersVO vo = new MembersVO();
         String email=request.getParameter("email");
         
//        int m_no = 1;
		 MembersVO memberList =service.selectMypage(email);
         System.out.println(memberList); //null
         request.setAttribute("memberList", memberList);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypage.jsp");
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