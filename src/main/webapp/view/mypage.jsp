<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.java.servlet.vo.MembersVO"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page import="com.java.servlet.dao.MypageDAO" %> 
<%@ page import="com.java.servlet.dao.impl.MypageDAOImpl" %> 


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Tables - SB Admin</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
<link href="${root}/bootstrap/css/mypageStyles.css"   rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"   crossorigin="anonymous"></script>
<script   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"   crossorigin="anonymous"></script>
<script   src="${root}/bootstrap/js/scripts.js"></script>
<script   src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="${root}/bootstrap/js/datatables-simple-demo.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" 
    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" 
    crossorigin="anonymous"></script>
<style>
 tr {
    text-align : center;
 }
  a:hover{
                background-color: #feeaa5;
            }
            .main{
            padding-top: 0.7cm;
            padding-left: 1.0cm;
            padding-right : 1.5cm;
            padding-bottom : 3cm;
            height: 120px;
            }         
            .bg-yellow {
              --bs-bg-opacity: 1;
              background-color: #feeaa5 !important;
         }
         .main1{
         border-bottom : 1px solid #645326;
          padding-bottom : 2px;
          padding-top : 2px;
         }
         .tab{
             padding-bottom : 0;
             padding-top : 0;
            border-bottom : 1px solid #645326;
            border-top : 1px solid #645326;
         }
         
         .img_main{
         width: 60%;
          margin: 0px auto;
          display: block;
          width: 250px; height: 90px;
          }
          .bgcolor {
         background-color: #f9f8f3;
          }
</style>
</head>
 <body class="sb-nav-fixed bgcolor" > 
           <nav class="main1 sb-topnav2 navbar navbar-expand; navbar-dark bg-yellow" >
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-0 my-md-0 mt-sm-0 ">
              <div class="input-group">
                <% String email = (String)session.getAttribute("SESS_EMAIL"); %>
              <%System.out.println(email);%>
            <%  if( email != null) { %>
                   <a href ="${root}/logout"><button type="button" class="btn" style="font-size: 14px;">로그아웃</button></a> 
                    <a href="${root}/mypage"><button type="button" class="btn" style="font-size: 14px;">마이페이지</button></a>                  
         	<%} else{%>
                <a href ="${root}/login"><button type="button" class="btn" style="font-size: 14px;">로그인</button></a>                 
             
            <%}  %>
                </div>
            </form>     
            </nav>
            
         <!-- 로고 -->              
        <nav class="main bg-white" >
         <a class="mainlogo" href= "${root}/main" >
         <img class = "img_main" src="image/logo.png" style="width: 250px; height: 90px;"/>
         </a>
        </nav>
        
         <nav class="tab sb-topnav2 navbar navbar-expand; bg-white" >
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/petnotice"><b>공고</b></a> 
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/shelter"><b>보호소</b></a>
          <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/withpet"><b>위드펫</b></a>
          <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/community"><b>커뮤니티</b></a>
         <a class=" pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/notice"><b>공지사항</b></a>
   
            </nav>
   <div id="layoutSidenav_content">
   
      <main>
      <%--  <%
        String email = session.getAttribute("SESS_EMAIL").toString();
        
        // 세션에 저장된 아이디를 가져와서
        // 회원정보를 가져온다.
        MembersDAO dao = MembersDAO.getInstance();
        MemberBean memberBean = dao.getUserInfo(email);
    %> --%> 

   
         <div class="container-fluid px-10 pt-5 ps-4">
            <h1 class="mt-1"><b>마이페이지</b></h1>
            </div>
            <ol class="breadcrumb mb-4 pt-3">

            </ol>

            <div class="card mb-4">
               <div class="card-header">
                  <i class="fas fa-table me-1"></i> 개인정보조회
               </div>
         
           	<%	
           		String id = (String)session.getAttribute("SESS_EMAIL"); 
		        // 세션에 저장된 아이디를 가져와서
		        // 그 아이디 해당하는 회원정보를 가져온다.
		        MypageDAO dao = MypageDAOImpl.getInstance();
		        MembersVO vo = dao.selectMypage(id);
		    %>
           	 
               <div class="card-body">
				
                  <table id="datatablesSimple" >
 				
                        <tr>
                           <td>닉네임</td>                        
                            <td> <%=vo.getNickname() %> </td>      
                        </tr>                    
                      
                        <tr>         
                           <td >비밀번호</td>
                            <td> <%=vo.getPwd() %> </td>
                        </tr>                                         
                       
                        <tr>
                           <td>이메일</td>                 
                         <td> <%=vo.getEmail() %> </td>
                        </tr>
                       
                        <tr>
                           <td>이름</td>
                           <td> <%=vo.getName() %> </td>       
                        </tr>                       
                       
                        <tr>
                           <td>전화번호</td>
                           <td> <%=vo.getPhone() %> </td>    
                        </tr>
 				
					</table>
				
                
 					<tr>
					<td colspan="2" align="center">
                      <a href ="${root}/mypaper"><button type="button" class ="btn btn-warning" >내가쓴글</button></a>&nbsp; 
                    <a href ="${root}/favorites"><button type="button" class ="btn btn-warning" >보호소 즐겨찾기</button></a> &nbsp; 
                    <a href ="${root}/favoritew"><button type="button" class ="btn btn-warning" >위드펫 즐겨찾기</button></a>
                   <!--   <button type="button" class="remove-favorites" onclick="removeFavorites();">회원탈퇴</button> -->
					</tr>
                    
            </div>
         </div>
      </main>
      <footer class="py-4 bg-light mt-auto">
         <div class="container-fluid px-4">
            <div class="d-flex align-items-center justify-content-between small">
               <div class="text-muted">Copyright &copy; Your Website 2023</div>

               <div></div>
            </div>
         </div>
      </footer>
   </div>
   

</body>
</html>