package com.java.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.MypageServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;
import com.java.servlet.vo.Favorite_S_VO;
import com.java.servlet.vo.MembersVO;
import com.java.servlet.vo.ShelterVO;

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
      
      HttpSession session = request.getSession(true);
      boolean SESS_AUTH = true;
      
      System.out.println(session);
      
      if (session == null) {
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() + "/login?msg=" + msg);
         return;
      }
      
      try {
         SESS_AUTH = (boolean) session.getAttribute("SESS_AUTH");
      } catch (Exception e) {}
      
      if (SESS_AUTH) {
         
         request.setCharacterEncoding("utf-8");
         request.setAttribute("SESS_AUTH", true);
         
         // allboard 가져와야 함.
         List<MembersVO> boardList = service.getAllBoard(); // getAllBoardByPage
         System.out.println(boardList);
         request.setAttribute("boardList", boardList);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/view/mypage.jsp");
         dispatcher.forward(request, response);
         
      } else {
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() + "/login?msg=" + msg);
      }      
   }
   
   private static final String REMOVE = "remove";

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      MembersVO vo = new MembersVO();
      
      String m_no = request.getParameter("m_no");
      String phone = request.getParameter("phone");
      
      if (m_no == null || m_no.equals("")) {
         m_no = "0";
      }
      
      vo.setM_no(Integer.parseInt(m_no));
      vo.setNickname(request.getParameter("nickname"));
      vo.setEmail(request.getParameter("email"));
      vo.setPwd(request.getParameter("pwd"));
      vo.setName(request.getParameter("name"));
      
      String method = request.getParameter("method");
      int result = 0;
      
      switch (method) {
         case REMOVE:
            result = service.getOutS(Integer.parseInt(m_no));
            System.out.println("여기1="+result);
            if (result == 1) {
             
            }
            break;
      }

      JsonObject jsonObj = new JsonObject();
      jsonObj.addProperty("result", result);
      jsonObj.addProperty("method", method);
      response.getWriter().println(new Gson().toJson(jsonObj));
   }
}