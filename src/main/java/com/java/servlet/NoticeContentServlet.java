package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlet.service.CommunityService;
import com.java.servlet.service.NoticeService;
import com.java.servlet.service.impl.CommunityServiceImpl;
import com.java.servlet.service.impl.NoticeServiceImpl;
import com.java.servlet.vo.CommunityVO;
import com.java.servlet.vo.NoticeVO;


/**
 * Servlet implementation class Board
 */
@WebServlet("/noticecontent")
public class NoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final NoticeService service = NoticeServiceImpl.getInstance(); 
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
		
		switch(method) {
			case "get":
				NoticeVO noticeVO=service.getNotice(Integer.parseInt(notice_no));
				request.setAttribute("noticeVO", noticeVO);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/view/notice-content.jsp");
				dispatcher.forward(request, response);
				break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println("method = "+request.getParameter("method"));
		System.out.println("notice_no = "+request.getParameter("notice_no"));
		String notice_no=request.getParameter("notice_no");
		switch(method) {
			case "get":
				NoticeVO noticeVO=service.getNotice(Integer.parseInt(notice_no));
				request.setAttribute("noticeVO", noticeVO);
				// dispatcher
			case "modify": // 수정완료 
				break;
			case "register": // 등록완료 insert 
				break;
			case "remove": // delete -> redirect
			break;
		}
	}

}
