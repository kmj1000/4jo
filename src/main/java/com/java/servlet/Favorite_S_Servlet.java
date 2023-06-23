package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlet.service.Favorite_S_Service;
import com.java.servlet.service.impl.Favorite_S_ServiceImpl;
import com.java.servlet.vo.Favorite_S_VO;

/**
 * Servlet implementation class favorite_S_Servlet
 */
@WebServlet("/favorite_shelter")
public class Favorite_S_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final Favorite_S_Service service= Favorite_S_ServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorite_S_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		String favorite_shelter_no = request.getParameter("favorite_shelter_no");
		
		if(favorite_shelter_no==null || favorite_shelter_no.equals("")) {
			favorite_shelter_no="0";
		}
		RequestDispatcher dispatcher;
		Favorite_S_VO favorite_s_VO;
		switch(method) {
			case "get":
				favorite_s_VO = service.getFavorite_shelter(Integer.parseInt(favorite_shelter_no));
				request.setAttribute("favorite_s_VO", favorite_s_VO);
				dispatcher = request.getRequestDispatcher("/view/favorite_shelter.jsp");
				dispatcher.forward(request, response);
				break;
			case "register":
				dispatcher = request.getRequestDispatcher("/view/favorite_shelter.jsp");
				dispatcher.forward(request, response);
				break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
