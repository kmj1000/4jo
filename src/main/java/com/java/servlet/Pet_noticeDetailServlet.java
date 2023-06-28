package com.java.servlet;

import java.io.IOException;



import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.servlet.service.Pet_noticeService;
import com.java.servlet.service.impl.Pet_noticeServiceImpl;
import com.java.servlet.util.Criteria;
import com.java.servlet.util.PageMaker;

import com.java.servlet.vo.Pet_noticeVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/petnoticedetail")
public class Pet_noticeDetailServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private final Pet_noticeService service = Pet_noticeServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pet_noticeDetailServlet() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session= request.getSession(true);
      boolean SESS_AUTH = true;
      System.out.println(session);
      if(session == null){
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() 
                           + "/login?msg="+msg);
         return;
      }
      
      try {
         SESS_AUTH = (boolean)session.getAttribute("SESS_AUTH");
      }catch(Exception e) {}
      
      if( SESS_AUTH ) {
         
         request.setCharacterEncoding("utf-8");
         request.setAttribute("SESS_AUTH", true);
         
         // pagesetting
         String pageNo = request.getParameter("pageNo");
         String perAmount = request.getParameter("perAmount");
         String displayNo = request.getParameter("displayNo");
         
         int currPageNo = (pageNo == null || pageNo.equals("")) ? 1 : Integer.parseInt(pageNo);
         int currAmount = (perAmount == null || perAmount.equals("")) ? 10 : Integer.parseInt(perAmount);
         int disPlayPageNum = (displayNo == null || displayNo.equals("")) ? 10 : Integer.parseInt(displayNo);
         
         int totalCount = service.getCountAllBoard();
         
         Criteria cri = new Criteria(currPageNo, currAmount); //현재페이지, 한페이지당 출력갯수
         PageMaker pageMaker = new PageMaker(cri, totalCount); // cri, totalCount=100
         pageMaker.setDisplayPageAmount(disPlayPageNum);
         System.out.println(pageMaker);
         
         // allboard 가져와야 함.
         List<Pet_noticeVO> boardList =service.getAllBoardByPage(pageMaker);//getAllBoardByPage
         //List<BoardVO> boardList =service.getAllBoard();//getAllBoardByPage
         System.out.println(boardList);
         request.setAttribute("boardList", boardList);
         
         request.setAttribute("pageMaker", pageMaker);
         
         String petNoticeNo = request.getParameter("pet_notice_no");
         request.setAttribute("petNoticeNo", petNoticeNo);
         RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/pet_noticedetail.jsp");
         dispatcher.forward(request, response);
      }else {
         String msg = "You are Not allowed, Plz login!";
         response.sendRedirect(request.getContextPath() + "/login?msg="+msg);
      }
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}