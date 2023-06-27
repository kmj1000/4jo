package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.servlet.service.FindService;
import com.java.servlet.service.JoinService;
import com.java.servlet.service.impl.FindPwdServiceImpl;
import com.java.servlet.service.impl.JoinServiceImpl;
import com.java.servlet.util.Define;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;
import com.java.servlet.dao.MembersDAO;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/findPwd")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FindService service=FindPwdServiceImpl.getInstance();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub �� ����媛�????
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/findPwd.jsp"	);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersVO vo = new MembersVO();
		
		String pwd = null;
		
		vo.setName(request.getParameter("name"));
		vo.setPhone( Integer.parseInt(request.getParameter("phone")) );
		vo.setEmail(request.getParameter("email"));
		
		if(pwd !=null) { 
			//새 창 넘어가기? 새 창에서 아이디 띄워주기
			
		}else {
			request.getRequestDispatcher( "/view/findPwd.jsp?msg=없는 정보입니다.")
			.forward(request, response);
}
	}



}
