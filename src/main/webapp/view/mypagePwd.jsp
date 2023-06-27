<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.java.servlet.vo.MembersVO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>password 이봐 수정이..!</title>
	<!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
	<link
		href="${ pageContext.servletContext.contextPath }/bootstrap/css/mypageStyles.css"
		rel="stylesheet" />
	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${ pageContext.servletContext.contextPath }/bootstrap/js/scripts.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${ pageContext.servletContext.contextPath }/bootstrap/js/datatables-simple-demo.js"></script>
	<script>
	String pwd=request.getParameter("pwd");
	String uppwd=request.getParameter("uppwd");
	String checkpwd=request.getParameter("checkpwd");
	MembersDAO dao=new MembersDAO()
	
	function doubleCheck(value) {
        let uppwd=document.getElementById("uppwd").value;
        //let uppwd=document.getElementById("checkpwd").value;
        let boxSpan=document.getElementById("box-span");
        let ch=document.getElementById("checkpwd");
        if(uppwd==value) {
            boxSpan.className="box-span-on";
            ch.className="form-control is-valid";
        }else{
            boxSpan.className="box-span-off";
            ch.className="form-control is-invalid";
        }
    }
	</script>
	<style>
        .box-submit {
            text-align: center;
        }
        .box-input {
            text-align: center;
        }
        .box-line-height {
            margin-bottom: 10px;
        }
        .header > h3 {
            text-align: center;
        }
        .box-span-on {
            color: green;
            font-weight: bold;
            font-size: 2 rem;
        }
        .box-span-off {
            color: red;
            font-weight: 800;
        }
        :focus {
            cursor: grab;
        }
        .btn:hover {
        	cursor:grab;
        }

    </style>
</head>
<body class="sb-nav-fixed bg-primary">

	<nav
		class=" ps-5 sb-topnav navbar navbar-expand; navbar-dark bg-yellow">
		<img class="ps-5 img_main" src="../dogfoot.png"
			style="width: 120px; height: 70px;" /><br /> <a
			class="navbar-brand ps-1 pe-5" href="${pageContext.servletContext.contextPath}/main"><h1>옥독캣</h1></a>

		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-0 my-md-0 mt-sm-0 ">
			<div class="input-group">
				<button type="button" class="btn btn-outline-dark"
					onclick="location='favorite_shelter.jsp'">로그아웃</button>
				<button type="button" class="btn btn-outline-dark"
					onclick="location='favorite_with_pet.jsp'">마이페이지</button>
			</div>
		</form>
	</nav>

	<nav class="sb-topnav navbar navbar-expand; navbar-dark bg-yellow">
		<!--   <nav class="nav nav-pills flex-column flex-sm-row justify-content-evenly"> -->
		<a class="flex-sm-fill text-sm-center nav-link active"
			aria-current="page" href="${pageContext.servletContext.contextPath}/pet_notice"><b>공고</b></a> 
		<a class="flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/shelter"><b>보호소</b></a>
		<a class="flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/with_pet"><b>위드펫</b></a>
		<a class="flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/community"><b>커뮤니티</b></a>
		<a class="flex-sm-fill text-sm-center nav-link" href="${pageContext.servletContext.contextPath}/notice"><b>공지사항</b></a>

	</nav>
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-10 pt-10">
				<h1 class="mt-1">마이페이지</h1>
				<br>
			<!-- form-control : 녹색 빨ㅅ간색 설정  -->
				<%-- <c:forEach var="MembersVO" items="${requestScope.boardList}" varStatus="status"> </c:forEach> --%>
					
					<div class="form-group">
						  <label class="form-label mt-4" for="inputValid">현재 비밀번호</label>
						  <input type="text" class="form-control" id="pwd" placeholder="현재 비밀번호를 입력하세요.">

					</div>
					<div class="form-group up">
						  <label class="form-label mt-4" for="inputValid">새 비밀번호</label>
						  <input type="text" class="form-control" id="uppwd" placeholder="새 비밀번호를 입력하세요.">
						 
					</div>
					<div class="form-group check">
						  <label class="form-label mt-4" for="inputValid">비밀번호 확인</label>
						  <input type="text" class="form-control " id="checkpwd" placeholder="새 비밀번호를 다시 입력해주세요." onkeyup="doubleCheck(this.value);">
						  <span id="box-span" class="box-span-on"></span>
					</div>
					<br>
					<input type="submit" value="비밀번호 변경" onclick="return check()">
				<!-- 	 -->
					
					<br>
					<br>
					<div>
							<td colspan="2" align="center">
							<input type="submit" value="내가쓴글" onclick="location='login.jsp'" /> &nbsp; 
							<input type="submit" value="보호소 즐겨찾기" onclick="location='login.jsp'" />&nbsp; 
							<input type="submit" value="위드펫 즐겨찾기" onclick="location='login.jsp'" />
							</td>
							<a href="#">회원탈퇴</a>
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