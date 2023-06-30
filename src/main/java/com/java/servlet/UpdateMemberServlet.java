package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.servlet.dao.MypageDAO;
import com.java.servlet.dao.impl.MypageDAOImpl;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/updatemember.jsp"	);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String id = (String)session.getAttribute("SESS_EMAIL"); 
		
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String phone = (String)request.getParameter("phone");
		int tel = Integer.parseInt("phone");
	
        // 세션에 저장된 아이디를 가져와서
        // 그 아이디 해당하는 회원정보를 가져온다.
        MypageDAO dao = MypageDAOImpl.getInstance();
        MembersVO vo = dao.selectMypage(id);
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setNickname(nickname);
		vo.setEmail(email);
		vo.setPhone(tel);
		
		String json_data = "";
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/updatemember.jsp");
	     dispatcher.forward(request, response);

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(json_data);
		writer.close();
	}
}


