<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>
<script>

</script>
</head>

<body>
<h2>96 select</h2>
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

	<form action="${pageContext.servletContext.contextPath }/all/s97" method="get">
		<button type="submit">97 insert</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s98" method="post">
		<button type="submit" >98 update</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s99" method="get">
		<button type="submit" >99 delete</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s100" method="get">
		<button type="submit" >100 가기</button>
	</form>
</body>
</html>
