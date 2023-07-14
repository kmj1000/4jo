<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>
<script>
	function insert(){
		var data=("form").serialize();
		$.ajax(
			{
				url:"all/s100",
				data:"data",
				type:"post",
				success:function(data, textStatus){
					
				},error:function(jqHXR, textStatus, errorThrown){
					console.log(jqHXR);
					console.log(textStatus);
					console.log(errorThrown);
				}
				
			}		
		
		);
		return true;
	}
	function update(){
		var data=("form").serialize();
		$.ajax(
			{
				url:"all/s100",
				data:"data",
				type:"PUT",
				success:function(data,textStatus){
					
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

	<table border=1>
	<tr>
		<th>사원번호</th>
		<th>이름</th>
		<th>생일</th>
		<th>부서번호</th>
		<th>사원타입</th>
		<th>전화번호</th>
		<th>취미</th>
		<th>급여</th>
		<th>직위</th>
		<th>pempno</th>
		
	</tr>
	<tr>
		<td>사원번호</td>
		<td>이름</td>
		<td>생일</td>
		<td>부서번호</td>
		<td>사원타입</td>
		<td>전화번호</td>
		<td>취미</td>
		<td>급여</td>
		<td>직위</td>
		<td>pempno</td>
		
	</tr>
	<c:forEach var="dto2" items="${emp2list}">
	<tr>
		<td>${dto2.empno}</td>
		<td>${dto2.name}</td>
		<td>${dto2.birthday}</td>
		<td>${dto2.deptno}</td>
		<td>${dto2.emp_type}</td>
		<td>${dto2.tel}</td>
		<td>${dto2.hobby}</td>
		<td>${dto2.pay}</td>
		<td>${dto2.position}</td>
		<td>${dto2.pempno}</td>
		
	</tr>
	</c:forEach>
	</table>
	<section id=containerin>
		<h3>insert</h3>
		<form action ="${pageContext.servletContext.contextPath}/all/s100" method="post">
			<div>
				<label class="label" for="empno">사원번호</label>
				<input type="text" name="empno" id="empno"/>
			</div>
			<div>
				<label class="label" for="name">이름</label>
				<input type="text" name="name" id="id"/>
			</div>
			<div>
				<label class="label" for="deptno">부서번호</label>
				<input type="text" name="deptno" id="deptno"/>
			</div>
			<button type="submit" onclick="insert();">insert</button>
		</form>
	</section>
	<section id=containerup>
		<h3>update</h3>
		<form action ="${pageContext.servletContext.contextPath }/all/s100">
			<div>
				<label class="label" for="empno">사원번호</label>
				<input type="text" id="empno" name="empno"/>
			</div>
			<div>
				<label class="label" for="name">이름</label>
				<input type="text" id="name" name="name"/>
			</div>
			<div>
				<label class="lable" for="deptno">부서번호</label>
				<input type="text" id="deptno" name="deptno"/>
			</div>
			<input type="hidden" name="_method" value="PUT">
			<button type="submit" onclick="update();">update</button>
		</form>
	</section>
	
</body>
</html>
