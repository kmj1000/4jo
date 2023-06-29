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
         
         System.out.println("메롱"+email);           
         
//		 MembersVO memberList =service.getMypage(email);
//         System.out.println(memberList); 
//         request.setAttribute("memberList", memberList);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypage.jsp");
         dispatcher.forward(request, response);
                
      }else {
//         String msg = "You are Not allowed, Plz login!";
//         response.sendRedirect(request.getContextPath() + "/login?msg="+msg);
      }      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}



















//package com.java.servlet;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.java.servlet.service.MypageService;
//import com.java.servlet.service.impl.MypageServiceImpl;
//import com.java.servlet.util.Criteria;
//import com.java.servlet.util.PageMaker;
//import com.java.servlet.vo.Favorite_S_VO;
//import com.java.servlet.vo.MembersVO;
//import com.java.servlet.vo.ShelterVO;
//
///**
// * Servlet implementation class MainServlet a
// */
//@WebServlet("/mypage")
//public class MypageServlet extends HttpServlet {
//   private static final long serialVersionUID = 1L;
//   private final MypageService service = MypageServiceImpl.getInstance();
//         
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MypageServlet() {
//        super();
//    }
//    
//   /**
//    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//    */
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      
//   }
////         //아이디 세션 얻기
////         MembersVO vo = (MembersVO)session.getAttribute("MembersVO");
////         String email=vo.getEmail();     
////         
////         //회원정보 조회
////         MembersVO userInfo =service.getInfo(email);
////         s
//        
////         // allboard 가져와야 함.
////         List<MembersVO> boardList = service.getAllBoard(); // getAllBoardByPage
////         System.out.println(boardList);
////         request.setAttribute("boardList", boardList);
//         
////         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypage.jsp");
////         dispatcher.forward(request, response);
//         
////      } else {
////         String msg = "You are Not allowed, Plz login!";
////         response.sendRedirect(request.getContextPath() + "/login?msg=" + msg);
////      }      
////   }
//   
//   
//
//   /**
//    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//    */
//   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      
//      HttpSession session = request.getSession(true);
//      boolean SESS_AUTH = true;
//      
//      System.out.println(session);
//      
////      if (session == null) {
////         String msg = "You are Not allowed, Plz login!";
////         response.sendRedirect(request.getContextPath() + "/login?msg=" + msg);
////         return;
////      }
//      
//      try {
//         SESS_AUTH = (boolean) session.getAttribute("SESS_AUTH");
//      } catch (Exception e) {}
//      
//      if (SESS_AUTH) {
//    	  request.setCharacterEncoding("utf-8");
//          request.setAttribute("SESS_AUTH", true);
//          
////      MembersVO vo = new MembersVO();
////      vo.setEmail(vo.getEmail());
//      
//      String email = request.getParameter("email");
//      String pwd = request.getParameter("pwd");
//      
//      MembersVO memberList = service.getMypage(); // getAllBoardByPage
//      System.out.println(memberList);
//      request.setAttribute("memberList", memberList);
//       
//		session.setAttribute("email", email);
//		//id라는 이름으로 변수 uid 이라는 값을넣었음 "uid"쓰면 문자열이 담김
//		//세션에 id를 담고 페이지 이동..
//		response.sendRedirect("mypage.jsp");
//		//세션에 id라는 이름이 저장된 정보를 가져오는 getAttribute("id") =>jsp생성
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypage.jsp");
//		dispatcher.forward(request, response);
//      
//      }
//   }
//}