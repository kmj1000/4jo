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
	<h2>80 select</h2>
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

	<form action="${pageContext.servletContext.contextPath }/all/s81" method="post">
		<button type="submit">81로 delete 가기</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s82" method="post">
		<button type="submit">82로 insert 가기</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s83" method="get">
		<button type="submit">83로 update 가기</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s84" method="get">
		<button type="submit">84로 가기</button>
	</form>

</body>
</html>