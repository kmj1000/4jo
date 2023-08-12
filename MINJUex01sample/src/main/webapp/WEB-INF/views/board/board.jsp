<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link href="${ pageContext.servletContext.contextPath }/resources/bootstrap/css/page-nation.css" rel="stylesheet" />
<link href="${ pageContext.servletContext.contextPath }/resources/bootstrap/css/styles.css" rel="stylesheet" />
</head>

<body>
	<table border=1>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>작성자</th>
			
		
		</tr>
		<!--<c:if test="${boardList ne null }"></c:if>-->
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.b_no }</td>
			<td>${board.title }</td>
			<td>${board.reg_date }</td>
			<td>${board.up_date }</td>
			<td>${board.id}</td>
		</tr>
		
		</c:forEach>	
		
		</table>
		<%@ include file="../import/page-nation.jsp" %>
		<!--<c:import url="../import/page-nation.jsp"></c:import>-->
</body>
</html>