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
        <title>Tables - SB Admin</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/styles.css" rel="stylesheet" />
        <link href="${ pageContext.servletContext.contextPath }/bootstrap/css/page-nation.css" rel="stylesheet" />
       	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
        	<script src="https://code.jquery.com/jquery-3.7.0.min.js" 
    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" 
    crossorigin="anonymous"></script>
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
  
    
   
      	
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
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
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Tables</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                                <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example 
                            </div>
                            <div class="card-body">
                           		
                           		<!-- --------------------------------------- -->
                           		<!-- <div class="card-body">
                           	
                                <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns"><div class="datatable-top">
									    <div class="datatable-dropdown">
									            <label>
									                <select class="datatable-selector"><option value="5">5</option><option value="10" selected="">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option></select> entries per pageㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴ
									            </label>
									        </div>
									    <div class="datatable-search">
									            <input class="datatable-input" placeholder="Search..." type="search" title="Search within table" aria-controls="datatablesSimple">
									        </div>
									</div>
									<div class="datatable-container"><table id="datatablesSimple" class="datatable-table"><thead><tr><th data-sortable="true" style="width: 16.335877862595417%;"><a href="#" class="datatable-sorter">글번호</a></th><th data-sortable="true" style="width: 45.19083969465649%;"><a href="#" class="datatable-sorter">제목</a></th><th data-sortable="true" style="width: 18.778625954198475%;"><a href="#" class="datatable-sorter">작성일</a></th><th data-sortable="true" style="width: 19.69465648854962%;"><a href="#" class="datatable-sorter">작성자</a></th></tr></thead><tbody><tr data-index="0"><td>1020</td><td><a href="/project/board?method=get&amp;b_no=1020">안녕하세요 가입인사드립니다.</a></td><td>jemminy01</td><td>2023-05-31</td></tr><tr data-index="1"><td>1051</td><td><a href="/project/board?method=get&amp;b_no=1051">제목없음1123</a></td><td>jemminy01</td><td>2023-06-12</td></tr><tr data-index="2"><td>1099</td><td><a href="/project/board?method=get&amp;b_no=1099">hello1099</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="3"><td>1060</td><td><a href="/project/board?method=get&amp;b_no=1060">hello1060</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="4"><td>1061</td><td><a href="/project/board?method=get&amp;b_no=1061">hello1061</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="5"><td>1062</td><td><a href="/project/board?method=get&amp;b_no=1062">hello1062</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="6"><td>1063</td><td><a href="/project/board?method=get&amp;b_no=1063">hello1063</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="7"><td>1064</td><td><a href="/project/board?method=get&amp;b_no=1064">hello1064</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="8"><td>1065</td><td><a href="/project/board?method=get&amp;b_no=1065">hello1065</a></td><td>jemminy01</td><td>2023-06-13</td></tr><tr data-index="9"><td>1066</td><td><a href="/project/board?method=get&amp;b_no=1066">hello1066</a></td><td>jemminy01</td><td>2023-06-13</td></tr></tbody></table></div>
									<div class="datatable-bottom">
									    <div class="datatable-info">Showing 1 to 10 of 100 entries</div>
									    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item datatable-hidden datatable-disabled"><a data-page="1" class="datatable-pagination-list-item-link">‹</a></li><li class="datatable-pagination-list-item datatable-active"><a data-page="1" class="datatable-pagination-list-item-link">1</a></li><li class="datatable-pagination-list-item"><a data-page="2" class="datatable-pagination-list-item-link">2</a></li><li class="datatable-pagination-list-item"><a data-page="3" class="datatable-pagination-list-item-link">3</a></li><li class="datatable-pagination-list-item"><a data-page="4" class="datatable-pagination-list-item-link">4</a></li><li class="datatable-pagination-list-item"><a data-page="5" class="datatable-pagination-list-item-link">5</a></li><li class="datatable-pagination-list-item"><a data-page="6" class="datatable-pagination-list-item-link">6</a></li><li class="datatable-pagination-list-item"><a data-page="7" class="datatable-pagination-list-item-link">7</a></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><a class="datatable-pagination-list-item-link">…</a></li><li class="datatable-pagination-list-item"><a data-page="10" class="datatable-pagination-list-item-link">10</a></li><li class="datatable-pagination-list-item"><a data-page="2" class="datatable-pagination-list-item-link">›</a></li></ul></nav>
									</div></div>
									                                <div class="datatable-bottom">
									    <div class="datatable-info">Showing 31 to 40 of 100 entries</div>
									    <nav class="datatable-pagination"><ul class="datatable-pagination-list"><li class="datatable-pagination-list-item"><a data-page="3" class="datatable-pagination-list-item-link">‹</a></li><li class="datatable-pagination-list-item"><a data-page="1" class="datatable-pagination-list-item-link">1</a></li><li class="datatable-pagination-list-item"><a class="datatable-pagination-list-item-link" data-page="2">2</a></li><li class="datatable-pagination-list-item"><a data-page="3" class="datatable-pagination-list-item-link">3</a></li><li class="datatable-pagination-list-item datatable-active"><a data-page="4" class="datatable-pagination-list-item-link">4</a></li><li class="datatable-pagination-list-item"><a data-page="5" class="datatable-pagination-list-item-link">5</a></li><li class="datatable-pagination-list-item"><a data-page="6" class="datatable-pagination-list-item-link">6</a></li><li class="datatable-pagination-list-item"><a data-page="7" class="datatable-pagination-list-item-link">7</a></li><li class="datatable-pagination-list-item datatable-ellipsis datatable-disabled"><a class="datatable-pagination-list-item-link">…</a></li><li class="datatable-pagination-list-item"><a data-page="10" class="datatable-pagination-list-item-link">10</a></li><li class="datatable-pagination-list-item"><a data-page="5" class="datatable-pagination-list-item-link">›</a></li></ul></nav>
									</div>
                            </div> -->
                           		
                           		
                           		<!-- ---------------------------------------- -->
                           		
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
	                                            
	                                            <!-- <th>조회수</th> -->
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
	                                            <!-- <th>조회수</th> -->
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

