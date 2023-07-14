package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.service.NoticeApiService;
import com.java.servlet.service.impl.NoticeApiServiceImpl;
import com.java.servlet.service.impl.NoticeServiceImpl;
import com.java.servlet.vo.NoticeVO;

/**
 * Servlet implementation class NoticeApiServlet
 */
@WebServlet("/noticecontentapi")
public class NoticeApiServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final NoticeApiService service  = NoticeApiServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeApiServlet() {
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
	private static final String Notice_REQ_METHOD_REGISTER = "register";
	private static final String Notice_REQ_METHOD_MODIFY = "modify";
	private static final String Notice_REQ_METHOD_REMOVE = "remove";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		String notice_no=request.getParameter("notice_no");
		NoticeVO vo = new NoticeVO();
		if(notice_no==null || notice_no.equals("")) {
			notice_no="0";
		}
		vo.setNotice_no(Integer.parseInt(notice_no));
		vo.setNotice_title(request.getParameter("title"));
		vo.setNotice_content(request.getParameter("content"));
		vo.setNickname(request.getParameter("nickname"));
		int result=0;
		
		switch(method) {
		case Notice_REQ_METHOD_REGISTER:
			result = service.registerNotice(vo);
			break;
		case Notice_REQ_METHOD_MODIFY:
			result = service.modifyNotice(vo);
			break;
		case Notice_REQ_METHOD_REMOVE:
			result = service.removeNotice(Integer.parseInt(notice_no));
		}
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		jsonObj.addProperty("method", method);
		response.getWriter().println(new Gson().toJson(jsonObj));
		
	}

}
