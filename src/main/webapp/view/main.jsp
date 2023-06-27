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
        <title>Main</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/mypageStyles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
        <style> 
        
       a:hover{
                background-color: #fbde7b;
            }
            .main{
            margin-top: 1cm;
            padding-right : 1.5cm;
            padding-bottom : 0;
            height: 120px;
            }         
            .bg-yellow {
				  --bs-bg-opacity: 1;
				  background-color: #fbde7b !important;
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
        </style>
    </head>
   <body class="sb-nav-fixed"> 
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
         <a class="mainlogo" href="${pageContext.servletContext.contextPath}/main" >
         <img class = "img_main" src="../logo.png" style="width: 250px; height: 90px;"/>
         </a>
        </nav>
        
         <nav class="tab sb-topnav2 navbar navbar-expand; bg-white" >
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link active" aria-current="page" href="http://localhost:8080/4jo/view/pet_notice.jsp"><b>공고</b></a> 
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="http://localhost:8080/4jo/view/shelter.jsp"><b>보호소</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="http://localhost:8080/4jo/view/with_pet.jsp"><b>위드펫</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link " href="http://localhost:8080/4jo/view/community.jsp"><b>커뮤니티</b></a>
			<a class=" pt-3 pb-3 flex-sm-fill text-sm-center nav-link " href="http://localhost:8080/4jo/view/notice.jsp"><b>공지사항</b></a>
        <!--  </nav> -->
            </nav>
            <main>
    			<div id="photomain">
    			
				<img class = "mainbanner" src="../mainimg.png" style="width: 1300px;"/>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>

                        </div>
                    </div>
                </footer>
            </div>
        </div>
    	
    </body>
</html>