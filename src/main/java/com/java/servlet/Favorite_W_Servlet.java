package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlet.service.Favorite_W_Service;
import com.java.servlet.service.impl.Favorite_W_ServiceImpl;
import com.java.servlet.vo.Favorite_W_VO;

/**
 * Servlet implementation class favorite_S_Servlet
 */
@WebServlet("/favorite_with_pet")
public class Favorite_W_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final Favorite_W_Service service= Favorite_W_ServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorite_W_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		String favorite_with_pet_no = request.getParameter("favorite_with_pet_no");
		
		if(favorite_with_pet_no==null || favorite_with_pet_no.equals("")) {
			favorite_with_pet_no="0";
		}
		RequestDispatcher dispatcher;
		Favorite_W_VO favorite_w_VO;
		switch(method) {
			case "get":
				favorite_w_VO = service.getFavorite_with_pet(Integer.parseInt(favorite_with_pet_no));
				request.setAttribute("favorite_s_VO", favorite_w_VO);
				dispatcher = request.getRequestDispatcher("/view/favorite_with_pet.jsp");
				dispatcher.forward(request, response);
				break;
			case "register":
				dispatcher = request.getRequestDispatcher("/view/favorite_with_pet.jsp");
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
