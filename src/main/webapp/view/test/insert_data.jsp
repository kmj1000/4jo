<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
     integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
     crossorigin="anonymous"></script>
<script>
<%
Connection conn = null;
PreparedStatement pstmt = null;

try {
    // Oracle 데이터베이스에 연결
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##abd", "abd");
    
    // INSERT 문 실행을 위한 PreparedStatement 생성
    String sql = "INSERT INTO shelter (careNm,divisionNm,saveTrgtAnimal,"
    		+"careAddr,weekOprStime,weekOprEtime,weekCellStime,weekCellEtime,"
    		+"weekendOprStime,weekendOprEtime,weekendCellStime,weekendCellEtime,"
    		+"closeDay,careTel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
    pstmt = conn.prepareStatement(sql);
    
    // AJAX 요청에서 전달받은 데이터 바인딩
    String careNm = request.getParameter("careNm");
    String divisionNm = request.getParameter("divisionNm");
    String saveTrgtAnimal = request.getParameter("saveTrgtAnimal");
    String careAddr = request.getParameter("careAddr");
    String weekOprStime = request.getParameter("weekOprStime");
    String weekOprEtime = request.getParameter("weekOprEtime");
    String weekCellStime = request.getParameter("weekCellStime");
    String weekCellEtime = request.getParameter("weekCellEtime");
    String weekendOprStime = request.getParameter("weekendOprStime");
    String weekendOprEtime = request.getParameter("weekendOprEtime");
    String weekendCellStime = request.getParameter("weekendCellStime");
    String weekendCellEtime = request.getParameter("weekendCellEtime");
    String closeDay = request.getParameter("closeDay");
    String careTel = request.getParameter("careTel");
    
    // PreparedStatement에 데이터 바인딩
    pstmt.setString(1, careNm);
    pstmt.setString(2, divisionNm);
    pstmt.setString(3, saveTrgtAnimal);
    pstmt.setString(4, careAddr);
    pstmt.setString(5, weekOprStime);
    pstmt.setString(6, weekOprEtime);
    pstmt.setString(7, weekCellStime);
    pstmt.setString(8, weekCellEtime);
    pstmt.setString(9, weekendOprStime);
    pstmt.setString(10, weekendOprEtime);
    pstmt.setString(11, weekendCellStime);
    pstmt.setString(12, weekendCellEtime);
    pstmt.setString(13, closeDay);
    pstmt.setString(14, careTel);
    
    // INSERT 문 실행
    pstmt.executeUpdate();
    
    // 리소스 정리
    pstmt.close();
    conn.close();
    
    // AJAX 요청에 성공 응답 전송
    response.getWriter().write("success");
} catch (Exception e) {
    e.printStackTrace();
    response.getWriter().write("error");
}
%>
</script>
</head>
<body>

</body>
</html>