package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.servlet.service.LoginService;
import com.java.servlet.service.impl.LoginServiceImpl;
import com.java.servlet.util.Define;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LoginService service = LoginServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("msg"));
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/login.jsp"	);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MembersVO vo = new MembersVO();
		vo.setEmail(request.getParameter("email"));
		vo.setPwd( SHAEncodeUtil.encodeSha( request.getParameter("pwd") ) );
		
		if( service.getCountMember(vo) == Define.LOGIN_AUTH_SUCCESS) {
			// session binding
			service.getMembersByIdAndPwd(vo); 
			
			HttpSession session = request.getSession(false);
			session.setAttribute("SESS_AUTH", true);
			session.setAttribute("SESS_EMAIL", vo.getEmail());
			session.setAttribute("SESS_USERNAME", vo.getName());
			
			response.sendRedirect(request.getContextPath() +  "/main");
			
			System.out.println("session - " + session);
		}else {
			request.getRequestDispatcher( "/view/login.jsp?msg=login failed, plz try again!")
					.forward(request, response);
		}
		
	}

}
