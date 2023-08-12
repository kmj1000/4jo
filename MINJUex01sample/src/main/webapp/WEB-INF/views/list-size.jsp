<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list-size</title>
</head>
<body>
   
   \${sessionScope.SESS_AUTH } : ${sessionScope.SESS_AUTH }
   <br>
   \${fn:length(list) } : ${fn:length(list) }

</body>
</html>