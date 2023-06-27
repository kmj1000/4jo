package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.servlet.service.FindService;
import com.java.servlet.service.JoinService;
import com.java.servlet.service.impl.FindPwdServiceImpl;
import com.java.servlet.service.impl.JoinServiceImpl;
import com.java.servlet.util.SHAEncodeUtil;
import com.java.servlet.vo.MembersVO;
import com.java.servlet.dao.FindPwdDAO;
import com.java.servlet.dao.FindPwdDAOImpl;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/findPwd")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FindService service=FindPwdServiceImpl.getInstance();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub �� ����媛�????
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/findPwd.jsp"	);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersVO vo = new MembersVO();
		vo.setName(request.getParameter("name"));
		vo.setPhone( Integer.parseInt(request.getParameter("phone")) );
		vo.setEmail(request.getParameter("email"));
		
		FindPwdDAO fpdao = FindPwdDAO();
		String pwd = fpdao.findPwd(fpdao);
		
		 if(pwd != null) {//결과가 있으면(정보가 맞다면)
			 response.sendRedirect("find_id_result.jsp?member_id="+pwd);
	            
			 request.getSession().setAttribute("member_id", pwd);
	            response.sendRedirect("find_id_result.jsp");
	         }
	         else {//결과가 없으면(정보가 맞지 않으면)
	        	 response.sendRedirect("find_id.jsp?error");
	         }
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
		
	}

}
