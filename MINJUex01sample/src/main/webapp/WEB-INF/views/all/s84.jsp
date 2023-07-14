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
	<h2>84 select</h2>
	<table border=1>
	<tr>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>직무</th>
		<th>MGR</th>
		<th>고용날짜</th>
		<th>월급</th>
		<th>COMM</th>
		<th>부서번호</th>
		
	</tr>
	<tr>
		<td>사원번호</td>
		<td>사원이름</td>
		<td>직무</td>
		<td>MGR</td>
		<td>고용날짜</td>
		<td>월급</td>
		<td>COMM</td>
		<td>부서번호</td>
	</tr>
	<c:forEach var="e" items="${emplist}">
	<tr>
		<td>${e.empno}</td>
		<td>${e.ename}</td>
		<td>${e.job}</td>
		<td>${e.mgr}</td>
		<td>${e.hiredate}</td>
		<td>${e.sal}</td>
		<td>${e.comm}</td>
		<td>${e.deptno}</td>

	</tr>
	</c:forEach>
	</table>
<form action="${pageContext.servletContext.contextPath }/all/s85" method="get">
	<button type="submit">85로 인서트 하러 가기</button>
</form>
<form action="${pageContext.servletContext.contextPath }/all/s86" method="get">
	<button type="submit">86로 업데이트 하러 가기</button>
</form>
<form action="${pageContext.servletContext.contextPath }/all/s87" method="post">
	<button type="submit">87로 딜리트 하러 가기</button>
</form>
<form action="${pageContext.servletContext.contextPath }/all/s88" method="get">
	<button type="submit">88로 가기</button>
</form>
</body>
</html>