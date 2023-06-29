package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutServlet
 */
		@WebServlet("/Logout")
		public class LogoutServlet extends HttpServlet {
			private static final long serialVersionUID = 1L;
			protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("[LogoutServiceCon]");
				//로그아웃 : 로그인한 정보 삭제 
				HttpSession session = request.getSession();
//				session.invalidate();  페이지에사용되는 모든 세션 삭제 => 세션삭제
				session.removeAttribute("info");
				
				System.out.println("로그아웃 성공");
				response.sendRedirect("main.jsp");
		
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
