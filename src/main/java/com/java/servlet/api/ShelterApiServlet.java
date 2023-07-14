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
import com.java.servlet.service.ShelterApiService;
import com.java.servlet.service.impl.ShelterApiServiceImpl;
import com.java.servlet.vo.Favorite_S_VO;
import com.java.servlet.vo.ShelterVO;

/**
 * Servlet implementation class BoardApiServlet
 */
@WebServlet("/api/favorites")
public class ShelterApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final ShelterApiService service = ShelterApiServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShelterApiServlet() {
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
		ShelterVO vo = new ShelterVO();
		Favorite_S_VO vo2 = new Favorite_S_VO();
		String shelter_no = request.getParameter("shelter_no");
		
		Date favorites_reg_date = new Date(System.currentTimeMillis());
        if (shelter_no == null || shelter_no.equals("")) {
            shelter_no = "-1";
        }
        
        vo2.setNickname(request.getParameter("nickname"));
        vo2.setFavorites_reg_date(favorites_reg_date);
		vo.setShelter_no(Integer.parseInt(shelter_no));
		vo.setCareNm( request.getParameter("careNm"));
		vo.setDivisionNm( request.getParameter("divisionNm"));
		vo.setSaveTrgtAnimal( request.getParameter("saveTrgtAnimal"));
		vo.setCareAddr( request.getParameter("careAddr"));
		vo.setWeekOprStime( request.getParameter("weekOprStime"));
		vo.setWeekOprEtime( request.getParameter("weekOprEtime"));
		vo.setWeekCellStime( request.getParameter("weekCellStime"));
		vo.setWeekCellEtime( request.getParameter("weekCellEtime"));
		vo.setWeekendOprStime( request.getParameter("weekendOprStime"));
		vo.setWeekendOprEtime( request.getParameter("weekendOprEtime"));
		vo.setWeekendCellStime( request.getParameter("weekendCellStime"));
		vo.setWeekendCellEtime( request.getParameter("weekendCellEtime"));
		vo.setCloseDay( request.getParameter("closeDay"));
		vo.setCareTel( request.getParameter("careTel"));
		
		
		
		String method = request.getParameter("method");
		int result = 0;
		
		 switch (method) {
	        case REGISTER:
	            result = service.registerShelter(vo);
	            break;

	        case REMOVE:
	            String[] shelterNos = shelter_no.split(",");
	            for (String shelterNo : shelterNos) {
	                result = service.removeShelter(Integer.parseInt(shelterNo));
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
