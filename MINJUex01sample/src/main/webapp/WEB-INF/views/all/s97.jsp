<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>
<script>
	function submit(){
		
		var data=$("form").serialize();
		$.ajax(	
			{
				url:"/s97",
				type:"post",
				//contentType:"application/x-www-form-urlencoded;charset=UTF-8",
				data:"data",
				datatype:"json",
				success:function(data,textStatus){
					alert("success");
				},error:function(jqHXR, textStatus, errorThrown){
					console.log(jqHXR);
					console.log(textStatus);
					console.log(errorThrown);
				}
			}
		);
		return true;
	}
	
</script>
</head>

<body>
<h2>97 insert</h2>
		<section id="container">
			<form action="${pageContext.servletContext.contextPath }/all/s97" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="empno">사원번호</label>
					<input class="form-control" type="text" id="empno" name="empno" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="name">이름</label>
					<input class="form-control" type="text" id="name" name="name" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="deptno">부서번호</label>
					<input class="form-control" type="text" id="deptno" name="deptno" />
				</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit" onclick="submit();">insert</button>
				</div>
			</form>
		</section>
		
			

	
	<form action="${pageContext.servletContext.contextPath }/all/s96" method="get">
		<button type="submit" >96 으로 가기</button>
	</form>
</body>
</html>
