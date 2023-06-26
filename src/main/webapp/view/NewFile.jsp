<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="com.java.servlet.vo.MembersVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
<script>
   
</script>
<style>
      tr {
         text-align : center;
         border: 2px;
      }
      
      .tal {
         text-align : end;
         }
   </style>
</head>
<body>
<%MembersVO vo = new MembersVO(); %>
   <h1 align="center">마이페이지</h1>
   

   <%-- <c:if test = "${name }"> --%>
      <table var ="vo" items = "${ requestScope.MemberList }"varStatus = "status" border="1" align="center" width="600">
         <tr>
         <tr>
            <td colspan="2" >개인정보조회</td>
         </tr>
         <tr>
            <td >닉네임</td>
            <td><%= vo.getNickname() %></td>
            <%-- <td><input type="text" name="name" value="${vo.name}" readonly="readonly"></td> --%>
         </tr>
         <tr>
            <td>비밀번호</td>
            <td><%= vo.getEmail() %>
            <input type = "button" value = "변경" onclick="location='login.jsp'" align = "end"/>
            </td>
         </tr>
         <tr>
            <td>이메일</td>
            <td><%= vo.getPwd() %></td>
            
         </tr>
         <tr>
            <td>이름</td>
            <td><%= vo.getName() %></td>
            
         </tr>
         <tr>
            <td>전화번호</td>
            <td><%= vo.getPhone() %>
            <input type = "button" value = "변경" onclick="location='login.jsp'"/>
            </td>
         </tr>

         <tr align="center">
            <td colspan="2">
               <input type="submit" value="내가쓴글" onclick="location='login.jsp'"/> &nbsp;
               <input type="submit" value="보호소 즐겨찾기" onclick="location='login.jsp'"/> &nbsp;
               <input type="submit" value="위드펫 즐겨찾기" onclick="location='login.jsp'"/>
             </td>
          </tr>
          <tr text-align = "end">
          <td id = "tal">회원탈퇴</td>
          </tr>
          </tr>
      </table>
      
</body>
</html>