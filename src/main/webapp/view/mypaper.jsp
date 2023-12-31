<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.java.servlet.vo.MembersVO"%>
<!DOCTYPE html>
<html lang="ko">

	<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>내가 쓴 글</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
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
		<script>
			window.onload = function(){
				initClass();
			}
			
			function adoptMethod(type){
				$("input[name='method']").val(type);
				initClass();
			}
			
			function initClass(){
				// modify
				$("textarea").removeClass("modify");
				$("input[type='text']").removeClass("modify");
				$(".modify").attr("readonly", false);
			}
			
			function adoptMethod(type) {
			    $("input[name='method']").val(type);
			    initClass();
			    // TODO: 정보 수정을 위한 코드를 추가하세요
			    // 예를 들어, 입력 필드를 수정 가능한 상태로 변경하거나 필요한 UI 변경을 수행할 수 있습니다.
			    $("textarea").addClass("modify");
			    $("input[type='text']").addClass("modify");
			    $(".modify").attr("readonly", false);
			}
	</script>
	</head>
    <body class="sb-nav-fixed bgcolor"> 
           <nav class="main1 sb-topnav2 navbar navbar-expand; navbar-dark bg-yellow" >
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-0 my-md-0 mt-sm-0 ">
                <div class="input-group">
                <% String email = (String)session.getAttribute("SESS_EMAIL"); %>
                <%System.out.println(email);%>
				<%  if( email != null) { %>
                   <button type="button" class="btn" onclick="logout();" style="font-size: 14px;">로그아웃</button>
                   <button type="button" class="btn" onclick="location.href='${pageContext.servletContext.contextPath}/mypage'" style="font-size: 14px;">마이페이지</button>                  
            <%} else{%>
                <button type="button" class="btn" onclick="location.href='${pageContext.servletContext.contextPath}/login'" style="font-size: 14px;">로그인</button>                 
             
            <%}  %>                </div>
            </form>     
            </nav>
            <script>
               function logout() {
             if (confirm("로그아웃 하시겠습니까?")) {
             location.href = "${pageContext.servletContext.contextPath}/logout";
                }
         }
            </script>
         <!-- 로고 -->              
        <nav class="main bg-white" >
         <a class="mainlogo" href="${pageContext.servletContext.contextPath}/main">
         <img class = "img_main" src="image/logo.png" style="width: 250px; height: 90px;"/>
         </a>
        </nav>
        
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
                        <h1 class="mt-1">내가 쓴 글</h1>
                      
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                              
                            </div>
                            <div class="card-body">
                           		
                           		 <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>작성일</th>
                                            <th>작성자</th>
                                            <!-- <th>조회수</th>  -->
                                        </tr>
                                       
                                    </thead>
                                   
                                    <tbody>
                                    	<c:forEach var="communityVO" items="${communityList}" varStatus="status">
                                        <tr>
                                            <td>${communityVO.c_no}</td>
                                            <td><a href="${pageContext.servletContext.contextPath}/communitycontent?method=get&c_no=${communityVO.c_no}">${communityVO.title}</a></td>
                                            <td>${communityVO.reg_date}</td>
                                            <td>${communityVO.nickname}</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <%-- <%@ include file="/view/import/page-paper.jsp" %> --%>
                           <%--  <jsp:include page="/view/import/page-nation.jsp"></jsp:include>  --%>
                        	<C:import url="/view/import/page-paper.jsp"></C:import>
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