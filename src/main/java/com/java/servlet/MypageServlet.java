package com.java.servlet;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session= request.getSession(false);
	      boolean SESS_AUTH = false;
	      System.out.println(session);
	      if(session == null){
	         String msg = "You are Not allowed, Plz login!";
	         response.sendRedirect(request.getContextPath() 
	                           + "/login?msg="+msg);
	         return;
	      }else {
	    	  
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/mypage.jsp");
	          dispatcher.forward(request, response);
	      }
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
