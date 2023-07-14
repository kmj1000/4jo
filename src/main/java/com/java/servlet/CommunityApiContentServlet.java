package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.service.CommunityApiService;
import com.java.servlet.service.impl.CommunityApiServiceImpl;
import com.java.servlet.vo.CommunityVO;


/**
 * Servlet implementation class Board.
 */
@WebServlet("/communitycontentapi")
public class CommunityApiContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final CommunityApiService service = CommunityApiServiceImpl.getInstance(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityApiContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private static final String Community_REQ_METHOD_REGISTER = "register";
	private static final String Community_REQ_METHOD_MODIFY = "modify";
	private static final String Community_REQ_METHOD_REMOVE = "remove";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityVO vo = new CommunityVO();
		
		String method=request.getParameter("method");
		System.out.println("method1 = "+request.getParameter("method"));
		System.out.println("c_no1 = "+request.getParameter("c_no"));
		String c_no=request.getParameter("c_no");
		
		if(c_no==null || c_no.equals("")) {
			c_no="0";
		}
		vo.setC_no(Integer.parseInt(c_no));
		vo.setTitle(request.getParameter("title") );
		vo.setContent( request.getParameter("content"));
		vo.setNickname( request.getParameter("nickname"));
		
		//{ result : 1}
		int result = 0;
		switch(method) {
			case Community_REQ_METHOD_MODIFY:
				result = service.modifyCommunity(vo);
				break;
			case Community_REQ_METHOD_REGISTER:
				result = service.registerCommunity(vo);
				break;
			case Community_REQ_METHOD_REMOVE:
				result = service.removeCommunity(Integer.parseInt(c_no));
				break;
			}

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		jsonObj.addProperty("method", method);
		response.getWriter().println( new Gson().toJson(jsonObj) );
	}

}
