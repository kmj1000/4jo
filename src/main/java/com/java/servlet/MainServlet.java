package com.java.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main1")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
 
	
	         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/main.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
