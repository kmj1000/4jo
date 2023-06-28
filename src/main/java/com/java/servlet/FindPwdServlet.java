package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.servlet.service.FindPwdService;
import com.java.servlet.service.JoinService;
import com.java.servlet.service.impl.FindPwdServiceImpl;
import com.java.servlet.service.impl.JoinServiceImpl;
import com.java.servlet.util.Define;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;
import com.java.servlet.dao.FindPwdDAO;
import com.java.servlet.dao.impl.FindPwdDAOImpl;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/findPwd")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FindPwdDAO instance = FindPwdDAOImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPwdServlet() {
		super();
		// TODO Auto-generated constructor stub �� ����媛�????
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/findPwd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MembersVO vo = new MembersVO();
	    vo.setName(name);
        vo.setPhone(Integer.parseInt(phone));
        vo.setEmail(email);
        
		String pwd = instance.selectFindPwd(vo);
		
        //String pwd = service.getFindPwd(vo);
		//SHAEncodeUtil.encodeSha( request.getParameter("pwd");
		
		System.out.println(email);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(pwd);
		

		
		if (pwd != null) {
			request.getRequestDispatcher("/view/findEmail.jsp?msg=회원님의 이메일은 "+pwd+"입니다.").forward(request, response);
			System.out.println("널");

		} else {
			request.getRequestDispatcher("/view/findPwd.jsp?msg=없는 정보입니다.").forward(request, response);
			System.out.println("널2");
			
		}
		return;
	}

}
