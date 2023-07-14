<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>
<script>
	function insert93(){
		var empno=document.getElementsByName("empno")[0].value;
		var name = document.getElementsByName("name")[0].value;
		var deptno=document.getElementsByName("deptno")[0].value;
		var emp_type=document.getElementsByName("emp_type")[0].value;
		var tel=document.getElementsByName("tel")[0].value;
		var hobby=document.getElementsByName("hobby")[0].value;
		var pay = document.getElementsByName("pay")[0].value;
		var position = document.getElementsByName("position")[0].value;
		var pempno = document.getElementsByName("pempno")[0].value;
		var msg="success";
		alert(msg);
		return true;
	}
	function update94(){
		var empno=document.getElementsByName("empno")[0].value;
		var name = document.getElementsByName("name")[0].value;
		var msg="success";
		alert(msg);
		return true;
	}
	function delete95(){
		var msg="success";
		alert(msg);
		var empno=document.getElementsByName("emono")[0].value;
		
		return true;
	}
</script>
</head>

<body>
<h2>92 select</h2>
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

	<form action="${pageContext.servletContext.contextPath }/all/s93" method="get">
		<div>
			사원번호 : <input type="text" name="empno" />
			이름 : <input type="text" name="name" />
			부서번호 : <input type="text" name="deptno" />
			사원타입 : <input type="text" name="emp_type" />
			전화번호 : <input type="text" name="tel" />
		</div>
		<div>
			취미 : <input type="text" name="hobby"/>
			급여 : <input type="text" name="pay" />
			직급 : <input type="text" name="position"/>
			pempno : <input type="text" name="pempno"/>
			<button type="submit" onclick="insert93();")>93 insert</button>
		</div>
			
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s94" method="get">
		사원번호 : <input type="text" name="empno" />
		이름 : <input type="text" name="name" />
		<button type="submit" onclick="update94();">94 update</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s95" method="get">
		사원번호 : <input type="text" name="empno" />
		<button type="submit" onclick="delete95();">95 delete</button>
	</form>
	<form action="${pageContext.servletContext.contextPath }/all/s96" method="get">
		<button type="submit" onclick="delete96();">96 으로 가기</button>
	</form>
</body>
</html>
