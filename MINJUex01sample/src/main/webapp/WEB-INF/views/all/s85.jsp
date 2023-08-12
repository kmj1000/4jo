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
  var job = document.getElementsByName("job").value;
  var mgr = document.getElementsByName("mgr").value;
  var sal = document.getElementsByName("sal").value;
  var comm = document.getElementsByName("comm").value;
  var deptno = document.getElementsByName("deptno").value;

  return true;
}
</script>

</head>

<body>
<h2>85 insert</h2>
<form action="${pageContext.servletContext.contextPath }/all/s84" method="get" >
	<button type="submit">84로 돌아 가기</button>
</form>
<form action="${pageContext.servletContext.contextPath }/all/s85" method="post" >
	<p>사원번호 : <input type="text" name="empno"></p>
	<p>사원이름 : <input type="text" name="ename"></p>
	<p>직무 : <input type="text" name="job"></p>
	<p>MGR : <input type="text" name="mgr"></p>
	<p>월급 : <input type="text" name="sal"></p>
	<p>comm : <input type="text" name="comm"></p>
	<p>deptno : <input type="text" name="deptno"></p>
	<button type="submit" onclick=" show();" >insert</button>
</form>
	

</body>
</html>