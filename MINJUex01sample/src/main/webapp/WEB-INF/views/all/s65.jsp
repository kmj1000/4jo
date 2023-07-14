<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample5</title>
<script>
function submit(){
	window.location.href="${pageContext.servletContext.contextPath}/all/s66"
}
</script>
</head>

<body>
	<p>66로 가기<button type="button" onclick="submit();">전송</button></p>
</body>
</html>