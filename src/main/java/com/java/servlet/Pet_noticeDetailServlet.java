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

import com.java.servlet.service.Pet_noticeService;
import com.java.servlet.service.impl.Pet_noticeServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Pet_noticeVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/petnoticedetail")
public class Pet_noticeDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final Pet_noticeService service = Pet_noticeServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pet_noticeDetailServlet() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session= request.getSession(false);
      boolean SESS_AUTH = false;
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
         request.setAttribute("SESS_AUTH", false);
         
         // pagesetting
         
        String pet_notice_no = request.getParameter("pet_notice_no");
        int petnoticeNo = Integer.parseInt(pet_notice_no);
        
         
        
         // allboard 가져와야 함.
         List<Pet_noticeVO> boardList =service.getPet_notice(petnoticeNo);//getAllBoardByPage
         //List<BoardVO> boardList =service.getAllBoard();//getAllBoardByPage
         System.out.println(boardList);
         boardList=service.getPet_notice(petnoticeNo);
         request.setAttribute("boardList", boardList);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/pet_noticedetail.jsp");
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