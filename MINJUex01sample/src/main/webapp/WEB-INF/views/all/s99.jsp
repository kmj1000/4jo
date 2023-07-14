<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>
<script>
	function delete(){
		var data=$("form").serialize();
		
		$.ajax(
			{
				url:"/s99",
				data:"data",
				datatype:"json",
				type:"post",
				//contentType:"application/x-www-form-urlencoded;charset=UTF-8",
				success:function(data, textStatus){
					
					alert("success");
				},error:function(jqHXR, textStatus, errorThrown){
					console.log(jqHXR);
					console.log(textStatus);
					console.log(errorThrown);
				}
			}		
		
		);
	}
</script>
</head>

<body>
<h2>99 delete</h2>
	<section id="container">
			<form action="${pageContext.servletContext.contextPath }/all/s99" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="empno">사원번호</label>
					<input class="form-control" type="text" id="empno" name="empno" />
				</div>
			
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit" onclick="delete();">delete</button>
				</div>
			</form>
		</section>
		
	<form action="${pageContext.servletContext.contextPath }/all/s96" method="get">

		<button type="submit">96 으로 가기</button>
	</form>
</body>
</html>
