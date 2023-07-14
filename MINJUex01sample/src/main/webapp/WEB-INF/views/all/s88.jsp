<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>

</head>

<body>
	<h2>88 select</h2>
	<table border=1>
	<tr>
		<th>학생번호</th>
		<th>학생이름</th>
		<th>아이디</th>
		<th>학년</th>
		<th>주민번호</th>
		<th>생일</th>
		<th>전화번호</th>
		<th>키</th>
		<th>몸무게</th>
		<th>deptno1</th>
		<th>deptno2</th>
		<th>profno</th>
	</tr>
	<tr>
		<td>학생번호</td>
		<td>학생이름</td>
		<td>아이디</td>
		<td>학년</td>
		<td>주민번호</td>
		<td>생일</td>
		<td>전화번호</td>
		<td>키</td>
		<td>몸무게</td>
		<td>deptno1</td>
		<td>deptno2</td>
		<td>profno</td>
	</tr>
	<c:forEach var="s" items="${list}">
	<tr>
		<td>${s.studno}</td>
		<td>${s.name}</td>
		<td>${s.id}</td>
		<td>${s.grade}</td>
		<td>${s.jumin}</td>
		<td>${s.birthday}</td>
		<td>${s.tel}</td>
		<td>${s.height}</td>
		<td>${s.weight}</td>
		<td>${s.deptno1}</td>
		<td>${s.deptno2}</td>
		<td>${s.profno}</td>
	</tr>
	</c:forEach>
	</table>
	<form action="${pageContext.servletContext.contextPath }/all/s89" method="get">
	<button type="submit">89 insert</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s90" method="get">
	<button type="submit">90 update</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s91" method="get">
	<button type="submit">91 delete</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s92" method="get">
	<button type="submit">92 로 넘어가기</button>
	</form>

</body>
</html>