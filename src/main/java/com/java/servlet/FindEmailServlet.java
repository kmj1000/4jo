package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlet.dao.FindEmailDAO;
import com.java.servlet.dao.FindPwdDAO;
import com.java.servlet.dao.impl.FindEmailDAOImpl;
import com.java.servlet.dao.impl.FindPwdDAOImpl;
import com.java.servlet.service.FindEmailService;
import com.java.servlet.service.FindPwdService;
import com.java.servlet.service.impl.FindEmailServiceImpl;
import com.java.servlet.service.impl.FindPwdServiceImpl;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class FindEmailServlet
 */
@WebServlet("/findEmail")
public class FindEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FindEmailDAO instance = FindEmailDAOImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/findEmail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MembersVO vo = new MembersVO();
	    vo.setName(name);
        vo.setPhone(Integer.parseInt(phone));
        
		String email = instance.selectFindEmail(vo);
		System.out.println(email);
		System.out.println(name);
		System.out.println(phone);

		
		if (email != null) {
			request.getRequestDispatcher("/view/findEmail.jsp?msg=회원님의 이메일은 "+email+"입니다.").forward(request, response);
		} else {
			request.getRequestDispatcher("/view/findEmail.jsp?msg=없는 정보입니다").forward(request, response);
			
		}
		return;
	}

}
