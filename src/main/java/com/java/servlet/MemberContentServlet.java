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

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.dao.MypageDAO;
import com.java.servlet.dao.impl.MypageDAOImpl;
import com.java.servlet.service.MemberContentService;
import com.java.servlet.service.impl.MemberContentServiceImpl;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/membercontent")
public class MemberContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final MemberContentService service = MemberContentServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println("method2 = "+request.getParameter("method"));
		System.out.println("email = "+request.getParameter("email"));
		String email=request.getParameter("email");
		
		
		
		
		switch(method) {
		case "get": 
			MembersVO membersVO= service.getMember(email);
			request.setAttribute("membersVO", membersVO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/memberapi.jsp");
			dispatcher.forward(request, response);
			break;
		case "register": // 등록완료
			dispatcher = request.getRequestDispatcher("/view/memberapi.jsp");
			dispatcher.forward(request, response);
			break;
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request,response);
		
	
	}
}


