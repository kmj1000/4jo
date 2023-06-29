<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.java.servlet.vo.MembersVO"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page import="com.java.servlet.dao.MembersDAO" %>    

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
<script src="https://code.jquery.com/jquery-3.7.0.js" 
    integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
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
                <%-- <c:if logintest = "${empty session}"> --%>
                   <button type="button" class="btn" style="font-size: 14px;">로그아웃</button>                  
            <%-- </c:if>    --%>
               <a href="${root}/mypage"><button type="button" class="btn" style="font-size: 14px;" onclick=>마이페이지</button></a>            
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
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link active" aria-current="page" href="${root}/pet_notice"><b>공고</b></a> 
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/shelter"><b>보호소</b></a>
          <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/with_pet"><b>위드펫</b></a>
          <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/community"><b>커뮤니티</b></a>
         <a class=" pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${root}/notice"><b>공지사항</b></a>
   
            </nav>
   <div id="layoutSidenav_content">
   
      <main>
      <%--  <%
        String email = session.getAttribute("SESS_EMAIL").toString();
        
        // 세션에 저장된 아이디를 가져와서
        // 그 아이디 해당하는 회원정보를 가져온다.
        MembersDAO dao = MembersDAO.getInstance();
        MemberBean memberBean = dao.getUserInfo(email);
    %> --%>
         <div class="container-fluid px-10 pt-5">
            <h1 class="mt-1">마이페이지</h1>
            </div>
            <ol class="breadcrumb mb-4">

            </ol>

            <div class="card mb-4">
               <div class="card-header">
                  <i class="fas fa-table me-1"></i> 개인정보조회
               </div>
               <div class="card-body">

                  <table id="datatablesSimple" >
                     <c:forEach var="MembersVO" items="${requestScope.boardList}" varStatus="status">
                        
                        <tr>
                           <td>회원번호</td>
                           <td>${MembersVO.m_no}</td>
                        </tr>
                        
                        
                        <tr>
                           <td>닉네임</td>
                           <td>${MembersVO.nickname}</td>
                        </tr>
                        <tr>
                        
                           <td >비밀번호</td>
                           <td>${MembersVO.pwd}
                              <button type="button" class="modify col p-3 btn btn-warning"
                                 onclick="location='notice.jsp'">변경</button>
                              <div class="col p-3"></div> <!--   </div> -->
                           </td>
                        </tr>
                        <tr>
                           <td>이메일</td>
                           <td>${MembersVO.email}</td>
                        </tr>
                        <tr>
                           <td>이름</td>
                           <td>${MembersVO.name}</td>
                        </tr>
                        <tr>
                           <td>전화번호</td>
                           <td>${MembersVO.phone}<button type="button" class="modify" 
                              onclick="location='login.jsp'" >변경</button>
                           </td>
                        </tr>
                     </c:forEach>
                  </table>

                  <tr>
                     <td colspan="2" align="center"><input type="submit"
                        value="내가쓴글" onclick="location='login.jsp'" /> &nbsp; <input
                        type="submit" value="보호소 즐겨찾기" onclick="location='login.jsp'" />
                        &nbsp; <input type="submit" value="위드펫 즐겨찾기"
                        onclick="location='login.jsp'" /></td>
                    
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