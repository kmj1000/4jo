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
import com.java.servlet.service.CommunityService;
import com.java.servlet.service.impl.CommunityServiceImpl;
import com.java.servlet.vo.CommunityVO;


/**
 * Servlet implementation class Board.
 */
@WebServlet("/communitycontent")
public class CommunityContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final CommunityService service = CommunityServiceImpl.getInstance(); 
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
		System.out.println("method = "+request.getParameter("method"));
		System.out.println("c_no = "+request.getParameter("c_no"));
		String c_no=request.getParameter("c_no");
		
		if(c_no==null || c_no.equals("")) {
			c_no="0";
		}
		
		switch(method) {
		case "get": 
			CommunityVO communityVO= service.getCommunity( Integer.parseInt(c_no) );
			request.setAttribute("communityVO", communityVO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/board-content.jsp");
			dispatcher.forward(request, response);
			break;
		case "register": // 등록완료
			dispatcher = request.getRequestDispatcher("/view/board-content.jsp");
			dispatcher.forward(request, response);
			break;
		
	}
		
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
		System.out.println("method = "+request.getParameter("method"));
		System.out.println("c_no = "+request.getParameter("c_no"));
		String c_no=request.getParameter("c_no");
		
		if(c_no==null || c_no.equals("")) {
			c_no="0";
		}
		
		//{ result : 1}
		int result = 0;
		switch(method) {
			case "get":
				CommunityVO communityVO=service.getCommunity(Integer.parseInt(c_no));
				request.setAttribute("communityVO", communityVO);
				// dispatcher
			case Community_REQ_METHOD_MODIFY:
				result = service.modifyBoard(vo);
				break;
			case Community_REQ_METHOD_REGISTER:
				result = service.registerBoard(vo);
				break;
			case Community_REQ_METHOD_REMOVE:
				result = service.removeBoard( Integer.parseInt( c_no ) );
				break;
			}

		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		jsonObj.addProperty("method", method);
		response.getWriter().println( new Gson().toJson(jsonObj) );
	}

}
