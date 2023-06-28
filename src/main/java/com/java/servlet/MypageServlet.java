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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.dao.MembersDAO;
import com.java.servlet.dao.impl.MembersDAOImpl;
import com.java.servlet.service.MypageService;
import com.java.servlet.service.impl.MypageServiceImpl;
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
	   request.setCharacterEncoding("utf-8");
       response.setContentType("application/json;charset=UTF-8");
       
      HttpSession session= request.getSession(true);
      boolean SESS_AUTH = true; 
     
      if(session == null){
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() 
                           + "/login?msg="+msg);
         return;
      }

      try {
         SESS_AUTH = (boolean)session.getAttribute("SESS_AUTH");
      }catch(Exception e) {}
       
    	  if (session != null && session.getAttribute("SESS_AUTH") != null && (boolean) session.getAttribute("SESS_AUTH")) {
    	        // 세션에 인증 정보가 있을 경우
    		  String email = (String) session.getAttribute("SESS_EMAIL");
    	      String username = (String) session.getAttribute("SESS_USERNAME");

    	   // 게시물 불러오기
    			MembersDAO dao = new MembersDAOImpl(); // 다오 객체 생성
    			MembersVO vo = dao.PersonalInfo(email); // 게시물 내용을 가져온다.
    			dao.close();
    	        

//    			// 게시물 저장 후 뷰로 포워드
//    			request.setAttribute("vo", vo);// vo 객체를 request 영역에 저장
//    			request.getRequestDispatcher("/view/mypage.jsp").forward(request, response);
    	        
    	   //원본     
//         request.setCharacterEncoding("utf-8");
//         request.setAttribute("SESS_AUTH", true);
//	     
         // allboard 가져와야 함.
         List<MembersVO> boardList =service.getAllBoard();//getAllBoardByPage
         System.out.println(boardList);
         request.setAttribute("boardList", boardList);      
//   
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
 
	  
	   
	   private static final String REMOVE = "remove";
	   
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      MembersVO vo = new MembersVO();

	      String email = request.getParameter("email");
	    
	        if (email == null || email.equals("")) {
	            email = "-1";
	        }
	        	       
	      vo.setPwd(request.getParameter("pwd"));
	     
	      //{ result : 1}
	      String method = request.getParameter("method");
	      int result = 0;
	      
	       switch (method) {
	          
	           case REMOVE:
	               String[] emails = email.split(",");
	               for (String email2 : emails) {
	                   result = service.removeId(request.getParameter("email2"));
	                   if (result != 1) {
	                       break;
	                   }
	               }
	               break;
	       }

	      
	      JsonObject jsonObj = new JsonObject();
	      jsonObj.addProperty("result", result);
	      jsonObj.addProperty("method", method);
	      response.getWriter().println( new Gson().toJson(jsonObj) );
	   }


      
   }
   
