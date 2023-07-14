<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>

<script>
function show() {
  var empno = document.getElementsByName("empno").value;
  var ename = document.getElementsByName("ename").value;
 

  var msg = "success"
             
  alert(msg);
  return true;
}
</script>

</head>

<body>
<h2>86 update</h2>
<form action="${pageContext.servletContext.contextPath }/all/s84" method="get">
	<button type="submit">84로 돌아 가기</button>
</form>
<form action="${pageContext.servletContext.contextPath }/all/s86" method="get">
	<p>사원번호 : <input type="text" name="empno"></p>
	<p>사원이름 : <input type="text" name="ename"></p>
	
	<button type="submit" onclick="return show();" >update</button>
</form>
	

</body>
</html>