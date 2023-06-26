package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.java.servlet.service.JoinService;
import com.java.servlet.service.impl.JoinServiceImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final JoinService service=JoinServiceImpl.getInstance();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/join.jsp" );
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MembersVO vo = new MembersVO();
		vo.setNickname( request.getParameter("nickname") );
		vo.setEmail( request.getParameter("email") );
		vo.setPwd( SHAEncodeUtil.encodeSha( request.getParameter("pwd") ));
		vo.setName( request.getParameter("name") );
		vo.setPhone( Integer.parseInt(request.getParameter("phone")) );
		
		System.out.println(vo);
		
		int isOk = 1;
		String msg = null;
		if( service.registerMembers(vo) == isOk) {
			msg = "success";
		}else {
			msg = "fail, try again";
		}
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect(request.getContextPath() 
									+	 "/login?msg="+msg);	
	}

}
