<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.java.servlet.vo.MembersVO" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/mypageStyles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
        
    </head>
    <body class="sb-nav-fixed"> 
          
        <nav class=" ps-5 sb-topnav navbar navbar-expand; navbar-dark bg-yellow" >
        <img class = "ps-5 img_main" src="../dogfoot.png" style="width: 120px; height: 70px;"/><br/>
             <a class="navbar-brand ps-1 pe-5" href="index.html" ><h1>옥독캣</h1></a>
              

            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-0 my-md-0 mt-sm-0 ">
                <div class="input-group">
                	<button type="button" class="btn btn-outline-primary" onclick="location='favorite_shelter.jsp'">로그아웃</button>
					<!-- <button type="button" class="btn btn-outline-secondary">Secondary</button>
					<button type="button" class="btn btn-outline-success">Success</button>
					<button type="button" class="btn btn-outline-info">Info</button>
					<button type="button" class="btn btn-outline-warning">Warning</button>
					<button type="button" class="btn btn-outline-danger">Danger</button>
					<button type="button" class="btn btn-outline-light">Light</button> -->
					<button type="button" class="btn btn-outline-danger" onclick="location='favorite_with_pet.jsp'">마이페이지</button>
                </div>
            </form>
        </nav>
        
         <nav class="sb-topnav navbar navbar-expand; navbar-dark bg-yellow" >
           <!--   <nav class="nav nav-pills flex-column flex-sm-row justify-content-evenly"> -->
              <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#"><b>공고</b></a>
              <a class="flex-sm-fill text-sm-center nav-link" href="#" ><b>보호소</b></a>
              <a class="flex-sm-fill text-sm-center nav-link" href="#" ><b>위드펫</b></a>
              <a class="flex-sm-fill text-sm-center nav-link " href="#"><b>커뮤니티</b></a>
              <a class="flex-sm-fill text-sm-center nav-link " href="#"><b>공지사항</b></a>
        <!--  </nav> -->
            </nav>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-10 pt-10">
                        <h1 class="mt-1" >마이페이지</h1>
                        <ol class="breadcrumb mb-4">
 
                        </ol>
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               개인정보조회
                            </div>
                            <div class="card-body">
                              
                                <table id="datatablesSimple">
                                <c:forEach var="MembersVO" items="${ requestScope.boardList }" varStatus="status">
                                        <tr>
                                      <%--   <% MembersVO vo = new MembersVO(); %> --%>
                                        
                                            <td>닉네임</td>
                                  			<td>${MembersVO.nickname}</td>
                                    <%-- <td><%= vo.getNickname() %> </td>  --%>
                                        </tr>
                                        <tr>
                                    <td align="center">비밀번호</td>
                                 <td>${MembersVO.pwd}</td> 
                                    <%-- <td><%= vo.getEmail() %> --%>
                                    <input type = "button" value = "변경" onclick="location='login.jsp'" align = "end"/>
                                    </td>
                                 </tr>
                                    <tr>
                                 <td>이메일</td>                                
                              <%--    <td><%= vo.getEmail() %></td>    --%>
                                 <td>${MembersVO.email}</td>                     
                              </tr>
                              <tr>
                                 <td>이름</td>
                               <%--  <td><%= vo.getName() %></td> --%>
                                 <td>${MembersVO.name}</td>                         
                              </tr>
                              <tr>
                                 <td>전화번호</td>
                                <%--  <td><%= vo.getPhone() %> --%>
                                 <td>${MembersVO.phone}</td> 
                                 <input type = "button" value = "변경" onclick="location='login.jsp'"/>
                                 </td>
                              </tr>
                              </c:forEach>
                              </table>
                              
                               <tr>
                                 <td colspan="2" align="center">
                                    <input type="submit" value="내가쓴글" onclick="location='login.jsp'"/> &nbsp;
                                    <input type="submit" value="보호소 즐겨찾기" onclick="location='login.jsp'"/> &nbsp;
                                    <input type="submit" value="위드펫 즐겨찾기" onclick="location='login.jsp'"/>
                                  </td>
                                   <a href="#">회원탈퇴</a>
                               </tr>
        
                           
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                           
                            <div>
                               
                                
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    	
    </body>
</html>