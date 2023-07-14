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
import com.java.servlet.service.NoticeCService;
import com.java.servlet.service.impl.NoticeCServiceImpl;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;


/**
 * Servlet implementation class Board.
 */
@WebServlet("/noticecontent")
public class NoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final NoticeCService service = NoticeCServiceImpl.getInstance(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		System.out.println("method = "+request.getParameter("method"));
		System.out.println("notice_no = "+request.getParameter("notice_no"));
		String notice_no=request.getParameter("notice_no");
		
		if(notice_no==null || notice_no.equals("")) {
			notice_no="0";
		}
		int nno = Integer.parseInt(notice_no);
		System.out.println(notice_no);
		switch(method) {
		case "get": 
			NoticeVO noticeVO= service.getNotice(nno);
			request.setAttribute("noticeVO", noticeVO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/notice-content.jsp");
			dispatcher.forward(request, response);
			break;
		case "register": // 등록완료
			dispatcher = request.getRequestDispatcher("/view/notice-content.jsp");
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
