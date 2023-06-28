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

import com.java.servlet.service.With_petService;
import com.java.servlet.service.impl.With_petServiceImpl;
import com.java.servlet.vo.ShelterVO;
import com.java.servlet.vo.With_petVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/withpetdetail")
public class With_petDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final With_petService service = With_petServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public With_petDetailServlet() {
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
         
         // pagesetting
     
         
         String with_pet_no = request.getParameter("with_pet_no");
         int withpetId = Integer.parseInt(with_pet_no);

         List<With_petVO> boardList = service.getWith_pet(withpetId);
    
         
         // allboard 가져와야 함.
          boardList =service.getWith_pet(withpetId);//getAllBoardByPage
         //List<BoardVO> boardList =service.getAllBoard(	);//getAllBoardByPage
         System.out.println(boardList);
         request.setAttribute("boardList", boardList);
         
        
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/with_petdetail.jsp");
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