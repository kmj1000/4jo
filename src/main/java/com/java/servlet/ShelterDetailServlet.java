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

import com.java.servlet.service.ShelterService;
import com.java.servlet.service.impl.ShelterServiceImpl;
import com.java.servlet.vo.ShelterVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/shelterdetail")
public class ShelterDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final ShelterService service = ShelterServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShelterDetailServlet() {
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
     
         
         String shelter_no = request.getParameter("shelter_no");
         int shelterId = Integer.parseInt(shelter_no);

         List<ShelterVO> boardList = service.getShelter(shelterId);
    
         
         // allboard 가져와야 함.
          boardList =service.getShelter(shelterId);//getAllBoardByPage
         //List<BoardVO> boardList =service.getAllBoard(	);//getAllBoardByPage
         System.out.println(boardList);
         request.setAttribute("boardList", boardList);
         
        
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/shelterdetail.jsp");
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