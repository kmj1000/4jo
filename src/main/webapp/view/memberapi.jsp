<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.java.servlet.vo.CommunityVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.java.servlet.dao.MypageDAO" %> 
<%@ page import="com.java.servlet.dao.impl.MypageDAOImpl" %> 
<%@ page import="com.java.servlet.vo.MembersVO"%>
<c:set var="root" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>옥독캣 - 정보수정</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
<link href="${root}/bootstrap/css/mypageStyles.css"   rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"   crossorigin="anonymous"></script>
<script   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"   crossorigin="anonymous"></script>
<script   src="${root}/bootstrap/js/scripts.js"></script>
<script   src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="${root}/bootstrap/js/datatables-simple-demo.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" 
    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" 
    crossorigin="anonymous"></script>
   
   <script src="http://code.jquery.com/jquery.js" ></script>	
	 <script>
        window.onload = function(){
        
  		initClass();
  	}
  	
  	function adoptMethod(type){
  		$("input[name='method']").val(type);
  		initClass();
  	}
  	
  	
  	function initClass(){
  		
  		// modify
  		$("textarea").removeClass("modify");
  		$("input[type='text']").removeClass("modify");
  		
  		// register
  		$("textarea").removeClass("register");
  		$("input[type='text']").removeClass("register");
  		
  		// get
  		$("textarea").removeClass("get");
  		$("input[type='text']").removeClass("get");
  		
  		const method = $("input[name='method']").val();
  		$("textarea").addClass(method);
  		$("input[type='text']").addClass(method);
  		
  		switch(method){
  			case "get" : 
  				$(".get").attr("readonly", true);
  				break;
  			case "modify" : 
  				$(".modify").attr("readonly", false);
  				break;
  			case "register" : 
  				$(".register").attr("readonly", false);
  				break;
  		}
  		
  	}
  	function goSubmit(){
  		 //const data = { opKey : 123 };
  		 console.log("여기1");
  		const data = $("form").serialize();
  		console.log(data);
         $.ajax(
                 {
                     url: "/4jo/memberapi"
                     ,async:true // 비동기 쓰레드,false : 동기식(응답 받을때까지 대기함)
                     ,contentType: 'application/x-www-form-urlencoded; charset=UTF-8' // 전송타입
                     ,type:"POST" //method
                     ,data : data
                     ,dataType:"json" // 수신타입
                     ,success:function(data, textStatus){
                     	console.log(data);
                     	
                     	if(data.result == 1){
                     		var msg ='';
                     		switch(data.method){
                     		case 'modify': msg = data.result +'건 수정되었습니다.';
                     		location.href = "${pageContext.servletContext.contextPath }/membercontent";
                     		break;
                     		case 'register': 
                     			msg = data.result +'건 등록되었습니다.';
                     		location.href = "${pageContext.servletContext.contextPath }/membercontent";
                     		break;
                     		case 'remove': msg = data.result +'건 삭제되었습니다.';
                     			location.href = "${pageContext.servletContext.contextPath }/membercontent";
                     			break;
                     		}
                     		alert( msg );
                     	}else{
                     		location.href = "${pageContext.servletContext.contextPath }/membercontent";
                     		
                     		alert(data.result + '건 실패입니다. \n다시시도하세요.');
                     	}
                     }
                     ,error:function(jqXHR, textStatus, errorThrown){
                         console.log(jqXHR);
                         console.log(textStatus);
                         console.log(errorThrown);
                     }
                 }
             );
			  		
  		
  		return false;
  	}
  </script>
</head>
<body>
<%	
				String Email = (String)session.getAttribute("SESS_EMAIL");
           		String nickname = (String)session.getAttribute("SESS_NICKNAME"); 
		        // 세션에 저장된 아이디를 가져와서
		        // 그 아이디 해당하는 회원정보를 가져온다.
		        MypageDAO dao = MypageDAOImpl.getInstance();
		        MembersVO vo = dao.selectMypage(nickname);
		        
		      
		    %>
		    
<div class="container mt-3">
  <h2 style="text-align: center;">게시글 작성</h2>  
  <form action="${pageContext.servletContext.contextPath}/membercontent" method="post">
  
    <div class="row">
        <div class="col"></div>
        <div class="col"></div>
        <div class="mt-3 col p-3">
            <label for="nickname">닉네임:</label>
            <p class="form-control" id="nickname" name="nickname">${ requestScope.communityVO.nickname == null ? sessionScope.SESS_NICKNAME : requestScope.communityVO.nickname }</p>
        </div>
        
    </div>
    
    <div class="row">
        <div class="mb-3 mt-3 col p-3">
           <label for="pwd">비밀번호:</label>
           <input type="text" class="form-control" id="pwd" placeholder="Enter pwd" name="pwd" value="${ requestScope.membersVO.pwd }">
        </div>
        <div class="mb-3 mt-3 col p-3">
            <label for="email">이메일:</label>
            <div class="form-control" id="email" name="email">${ requestScope.membersVO.email == null ? sessionScope.SESS_EMAIL : requestScope.membersVO.email }</div>
        </div> 
    </div>
    <div class="mb-3 mt-3">
        <label for="name">이름:</label>
        <div class="form-control" rows="5" id="name" name="name" >${ membersVO.name }</div>
     	</div>
     	<div class="mb-3 mt-3">
        <label for="phone">전화번호:</label>
        <div class="form-control" rows="5" id="phone" name="phone" >${ membersVO.phone }</div>
     	</div>
    	<div class="row">
       	<button type="button" class="get col p-3 btn btn-warning" onclick="history.back();">뒤로</button>
       	<div class="col p-3"></div>
       	<button type="submit" class="register col p-3 btn btn-warning" onclick="return goSubmit();">전송</button>
         	<div class="col p-3"></div>
       	<button type="submit"  class="modify col p-3 btn btn-warning" onclick="adoptMethod('modify');">수정</button>
       		<div class="col p-3"></div>
	    <button type="button"  class="remove col p-3 btn btn-warning" onclick="adoptMethod('remove'); return goSubmit();">삭제</button>
	    	<div class="col p-3"></div>
   			
    </div>
    	<input type="hidden" name="method" value="${param.method}">
    	
        <input type="hidden" name="email" value="${ requestScope.membersVO.email == null ? sessionScope.SESS_EMAIL : requestScope.membersVO.email }">
  
		<input type="hidden" name="nickname" value="${communityVO.nickname == null ? sessionScope.SESS_NICKNAME : requestScope.communityVO.nickname  }">
  </form>
</div>

</body>
</html>