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
import com.java.servlet.service.CommunityCService;
import com.java.servlet.service.impl.CommunityCServiceImpl;
import com.java.servlet.vo.CommunityVO;


/**
 * Servlet implementation class Board.
 */
@WebServlet("/communitycontent")
public class CommunityContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final CommunityCService service = CommunityCServiceImpl.getInstance(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		System.out.println("method2 = "+request.getParameter("method"));
		System.out.println("c_no2 = "+request.getParameter("c_no"));
		String c_no=request.getParameter("c_no");
		
		if(c_no==null || c_no.equals("")) {
			c_no="0";
		}
		
		
		switch(method) {
		case "get": 
			CommunityVO communityVO= service.getCommunity(Integer.parseInt(c_no));
			request.setAttribute("communityVO", communityVO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/community-content.jsp");
			dispatcher.forward(request, response);
			break;
		case "register": // 등록완료
			dispatcher = request.getRequestDispatcher("/view/community-content.jsp");
			dispatcher.forward(request, response);
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}
