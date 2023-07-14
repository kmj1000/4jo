package com.java.servlet.api;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.java.servlet.service.With_petApiService;
import com.java.servlet.service.impl.With_petApiServiceImpl;
import com.java.servlet.vo.Favorite_W_VO;
import com.java.servlet.vo.With_petVO;

/**
 * Servlet implementation class BoardApiServlet
 */
@WebServlet("/api/favoritew")
public class With_petApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final With_petApiService service = With_petApiServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public With_petApiServlet() {
        super();
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
	private static final String REGISTER = "register";
	
	private static final String REMOVE = "remove";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		With_petVO vo = new With_petVO();
		Favorite_W_VO vo2 = new Favorite_W_VO();
		String with_pet_no = request.getParameter("with_pet_no");
		
		Date favoritew_reg_date = new Date(System.currentTimeMillis());
        if (with_pet_no == null || with_pet_no.equals("")) {
        	with_pet_no = "-1";
        }
        
        vo2.setNickname(request.getParameter("nickname"));
        vo2.setFavoritew_reg_date(favoritew_reg_date);
		vo.setWith_pet_no(Integer.parseInt(with_pet_no));
		vo.setBuilding( request.getParameter("building"));
		vo.setCategory3( request.getParameter("category3"));
		vo.setRoad( request.getParameter("road"));
		vo.setHomepage( request.getParameter("homepage"));
		vo.setHour( request.getParameter("hour"));
		vo.setParking( request.getParameter("parking"));
		vo.setWith_pet_info( request.getParameter("with_pet_info"));
		vo.setOnly_pet_info( request.getParameter("only_pet_info"));
		vo.setPet_size( request.getParameter("pet_size"));
		vo.setPet_limit(request.getParameter("pet_limit"));
		vo.setInside( request.getParameter("inside"));
		vo.setOutside( request.getParameter("outside"));
		vo.setExtra( request.getParameter("extra"));
		
		
		
		//{ result : 1}
		String method = request.getParameter("method");
		int result = 0;
		
		 switch (method) {
	        case REGISTER:
	            result = service.registerWith_pet(vo);
	            break;

	        case REMOVE:
	            String[] withpetNos = with_pet_no.split(",");
	            for (String withpetNo : withpetNos) {
	                result = service.removeWith_pet(Integer.parseInt(withpetNo));
	                if (result != 1) {
	                    break;
	                }
	            }
	            break;
	    }

		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("result", result);
		jsonObj.addProperty("method", method);
		response.getWriter().println( new Gson().toJson(jsonObj) );
	}

}
