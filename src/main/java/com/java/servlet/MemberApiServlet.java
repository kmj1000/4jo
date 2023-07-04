package com.java.servlet;

import java.io.IOException;

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
import com.java.servlet.service.MemberApiService;
import com.java.servlet.service.impl.MemberApiServiceImpl;
import com.java.servlet.vo.MembersVO;

/**
 * Servlet implementation class MemberApiServlet
 */
@WebServlet("/memberapi")
public class MemberApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final MemberApiService service = MemberApiServiceImpl.getInstance(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private static final String Community_REQ_METHOD_MODIFY_PWD = "modifypwd";
	private static final String Community_REQ_METHOD_MODIFY_PHONE = "modifyphone";
	private static final String Community_REQ_METHOD_REMOVE = "remove";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersVO vo = new MembersVO();
		
		String method=request.getParameter("method");
		System.out.println("method1 = "+request.getParameter("method"));
		System.out.println("email = "+request.getParameter("email"));
		
		String email = request.getParameter("email");
		
		
		vo.setEmail(request.getParameter("email"));
		vo.setNickname(request.getParameter("nickname") );
		vo.setPwd( request.getParameter("pwd"));
		vo.setName( request.getParameter("name"));

		
		//{ result : 1}
		int result = 0;
		switch(method) {
			case Community_REQ_METHOD_MODIFY_PWD:
				result = service.modifyPwd(vo);
				break;
			case Community_REQ_METHOD_MODIFY_PHONE:
				result = service.modifyPhone(vo);
				break;
			case Community_REQ_METHOD_REMOVE:
				result = service.removeMember(email);
				break;
			}

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		jsonObj.addProperty("method", method);
		response.getWriter().println( new Gson().toJson(jsonObj) );
	}

}
