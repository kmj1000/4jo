<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>반려동물 동반가능 업체정보 목록 상세</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/mypageStyles.css" rel="stylesheet" />
		<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
		<script src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
		<script src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
		<script src="https://code.jquery.com/jquery-3.7.0.js" 
    integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
    crossorigin="anonymous"></script>
		
		
		
		<script>   
 
		function sendFavoritew() {
			 var favoritew = [];
			  $("input[name='favorite']:checked").each(function() {
			    favoritew.push($(this).val());
			  });
			
			  $.ajax({
			    url: "/4jo/api/favoritew",
			    type: "POST",
			    data: {
			      with_pet_no: favoritew.join(","),
			      method: "register"
			    },
			    dataType: "json",
			    success: function(data) {
			      if (data.result === 1) {
			        var msg = favoritew.length + "건 등록되었습니다.";
			        alert(msg);
			       
			      } else {
			        alert("처리에 실패했습니다. 다시 시도해주세요.");
			      }
			    },
			    error: function(jqXHR, textStatus, errorThrown) {
			      console.log(jqXHR);
			      console.log(textStatus);
			      console.log(errorThrown);
			      alert("오류가 발생했습니다. 다시 시도해주세요.");
			    }
			  });
			}
			  function removeFavoritew() {
				  var favoritew = [];
				  $("input[name='favorite']:checked").each(function() {
				    favoritew.push($(this).val());
				  });
			
				  $.ajax({
				    url: "/4jo/api/favoritew",
				    type: "POST",
				    data: {
				      with_pet_no: favoritew.join(","),
				      method: "remove"
				    },
				    dataType: "json",
				    success: function(data) {
				      if (data.result === 1) {
				        var msg = favoritew.length + "건 삭제되었습니다.";
				        alert(msg);
				        
				      } else {
				        alert("처리에 실패했습니다. 다시 시도해주세요.");
				      }
				    },
				    error: function(jqXHR, textStatus, errorThrown) {
				      console.log(jqXHR);
				      console.log(textStatus);
				      console.log(errorThrown);
				      alert("오류가 발생했습니다. 다시 시도해주세요.");
				    }
				  });
				}
  		</script>
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
                <% String email = (String)session.getAttribute("SESS_EMAIL"); %>
              <%System.out.println(email);%>
            <%  if( email != null) { %>
                   <button type="button" class="btn" onclick="logout();" style="font-size: 14px;">로그아웃</button>
                   <button type="button" class="btn" onclick="location.href='${root}/mypage'" style="font-size: 14px;">마이페이지</button>                  
            <%} else{%>
                <button type="button" class="btn" onclick="location.href='${root}/login'" style="font-size: 14px;">로그인</button>                 
             
            <%}  %>
                </div>
            </form>     
            </nav>
        <script>
               function logout() {
             if (confirm("로그아웃 하시겠습니까?")) {
             location.href = "${root}/logout";
                }
         }
            </script>
         <nav class="tab sb-topnav2 navbar navbar-expand; bg-white" >
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/petnotice"><b>공고</b></a> 
             <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/shelter"><b>보호소</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/withpet"><b>위드펫</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/community"><b>커뮤니티</b></a>
			 <a class="pt-3 pb-3 flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/notice"><b>공지사항</b></a>
   
            </nav>
        <div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-3 pt-3">
                        <h1 class="mt-1">유기동물 공고 상세</h1>
                      
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                              
                            </div>
                            <div class="card-body">
                           		
                           		 <table id="datatablesSimple">
	                                    <thead>
	                                        <tr>
	                                        	<th>check</th>
	                                            <th>고유번호</th>
	                                            <th>문화시설 이름</th>
	                                            <th>문화시설 유형 </th>
	                                            <th>도로명 주소</th>
	                                            <th>전화번호 </th>
	                                            <th>홈페이지</th>
	                                            <th>휴무일 </th>
	                                            <th>운영시간 </th>
	                                            <th>주차가능여부 </th>
	                                            <th>반려동물 동반 가능정보 </th>
	                                            <th>반려동물 전용 정보 </th>
	                                            <th>입장 가능 동물 크기 </th>
	                                            <th>장소(실내)여부 </th>
	                                            <th>장소(실외)여부 </th>
	                                            <th>애견동반추가요금 </th>
	                                        </tr>
	                                    </thead>
	                                    <tfoot>
	                                        <tr>
	                                        	<th>check</th>
	                                        	<th>고유번호</th>
	                                            <th>문화시설 이름</th>
	                                            <th>문화시설 유형 </th>
	                                            <th>도로명 주소</th>
	                                            <th>전화번호 </th>
	                                            <th>홈페이지</th>
	                                            <th>휴무일 </th>
	                                            <th>운영시간 </th>
	                                            <th>주차가능여부 </th>
	                                            <th>반려동물 동반 가능정보 </th>
	                                            <th>반려동물 전용 정보 </th>
	                                            <th>입장 가능 동물 크기 </th>
	                                            <th>장소(실내)여부 </th>
	                                            <th>장소(실외)여부 </th>
	                                            <th>애견동반추가요금 </th>
	                                        </tr>
	                                    </tfoot>
	                                    <tbody>
	                                    	<c:forEach var="With_petVO" items="${ requestScope.boardList }" varStatus="status">
											<tr>
												<!-- pageScope에 vo가 생성되었다.  -->
												<td><input type="checkbox" name="favorite" 
												style="transform:scale(1.5);" value="${With_petVO.with_pet_no}" /></td>
												<td>${With_petVO.with_pet_no}</td>
												<td>${With_petVO.building}</td>
												<td>${With_petVO.category3}</td>
												<td>${With_petVO.road}</td>
												<td>${With_petVO.homepage}</td>										
												<td>${With_petVO.day_off}</td>
												<td>${With_petVO.hour}</td>
												<td>${With_petVO.parking}</td>
												<td>${With_petVO.with_pet_info}</td>
												<td>${With_petVO.only_pet_info}</td>
												<td>${With_petVO.pet_size}</td>
												<td>${With_petVO.pet_limit}</td>
												<td>${With_petVO.inside}</td>
												<td>${With_petVO.outside}</td>
												<td>${With_petVO.extra}</td>
												
										
											</tr>
											</c:forEach>
	                                    </tbody>
	                                </table>
	                              <button type="button" class="send-favoritew col p-3 btn btn-primary" 
											onclick="sendFavoritew();">전송</button>
	    								<button type="button" class="remove-favoritew col p-3 btn btn-primary" 
											onclick="removeFavoritew();">삭제</button>
	                            </div>
	                            <%@ include file="/view/import/page-with_petdetail.jsp" %>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        
    </body>
</html>

