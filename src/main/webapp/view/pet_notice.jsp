<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>유기동물 공고 목록</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->

        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/styles.css" rel="stylesheet" />
        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/page-nation.css" rel="stylesheet" />
       	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
      
     	

        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/mypageStyles.css" rel="stylesheet" />
		<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
		<script src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
		<script src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
	
		<style>
		
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
				    .bgcolor{
				   background-color: #f9f8f3;
				    }
		</style>
      
        
    </head>
    <body class="sb-nav-fixed bgcolor"> 
           <nav class="main1 sb-topnav2 navbar navbar-expand; navbar-dark bg-yellow" >
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-0 my-md-0 mt-sm-0 ">
                <div class="input-group">
                	<button type="button" class="btn" onclick="location='login.jsp'" style="font-size: 14px;">로그아웃</button>					
					<button type="button" class="btn" onclick="location='mypage.jsp'" style="font-size: 14px;">마이페이지</button>
                </div>
            </form>     
            </nav>
            
         <!-- 로고 -->              
        <nav class="main bg-white" >
         <a class="mainlogo" href="${pageContext.servletContext.contextPath}/main">
         <img class = "img_main" src="image/logo.png" style="width: 250px; height: 90px;"/>
         </a>
        </nav>

        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.html">Login</a>
                                            <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            
                <main>
                
                           		<!-- ---------------------------------------- -->
                           		

        
         <nav class="tab sb-topnav2 navbar navbar-expand; bg-white" >
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/petnotice"><b>공고</b></a> 
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/shelter"><b>보호소</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/withpet"><b>위드펫</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/community"><b>커뮤니티</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/notice"><b>공지사항</b></a>
   
            </nav>
        
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-3 pt-3">
                        <h1 class="mt-1">유기동물 공고</h1>
                      
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                              
                            </div>
                            <div class="card-body">

	                                <table id="datatablesSimple">
	                                    <thead>
	                                        <tr>
	                                       		<th >Image </th>
	                                            <th>품종</th>
	                                            <th>나이</th>
	                                            <th>체중 </th>
	                                            <th>성별 </th>
	                                            <th>특징 </th>
	                                           
	                                            
	                                            <!-- <th>조회수</th> -->
	                                        </tr>
	                                    </thead>
	                                    <tfoot>
	                                        <tr>
	                                           	
	                                            <th >Image </th>
	                                            <th>품종</th>
	                                            <th>나이</th>
	                                            <th>체중 </th>
	                                            <th>성별 </th>
	                                            <th>특징 </th>
	                                            
	                                            <!-- <th>조회수</th> -->
	                                        </tr>
	                                    </tfoot>
	                                    <tbody>
	                                    	<c:forEach var="Pet_noticeVO" items="${ requestScope.boardList }" varStatus="status">
											<a href ="" >
											<tr onclick="location.href='${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}'" style="cursor:pointer" >
												<!-- pageScope에 vo가 생성되었다.  -->
											
												<td >
												<a href ="${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}" >
												<img src="${Pet_noticeVO.popfile}" alt="펫이미지" style="height:100px"/>
												</a>
												</td>
												<td>
												<a href ="${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}" >
												${Pet_noticeVO.kindCd}
												</a>
												</td>
												<td>
												<a href ="${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}" >
												${Pet_noticeVO.age}
												</a>
												</td>								
												<td>
												<a href ="${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}" >
												${Pet_noticeVO.weight}
												</a>
												</td>
												<td>
												<a href ="${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}" >
												${Pet_noticeVO.sexCd}
												</a>
												</td>
												<td>
												<a href ="${pageContext.servletContext.contextPath}/petnoticedetail?method=get&pet_notice_no=${Pet_noticeVO.pet_notice_no}" >
												${Pet_noticeVO.specialMark}
												</a>
												</td>
											
											</tr>
										
											</c:forEach>
	                                    </tbody>
	                                </table>
	                              
	                            </div>
					<%-- <%@ include file="/view/import/page-community.jsp" %> --%>
                           <%-- <jsp:include page="/view/import/page-nation.jsp"></jsp:include>  --%>
                        	<c:import url="/view/import/page-pet_notice.jsp"></c:import>
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
	</div>

</body>
</html>