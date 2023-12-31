<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>비밀번호 찾기</title>
        <link href="${pageContext.servletContext.contextPath}/bootstrap/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
             <script>
         	var msg = '<%= request.getParameter("msg")%>';
        	console.log("Dsa");
        	window.onload = function(){
        		showMsg();
        	}
        	
        	function showMsg(){
    	    	if( msg != null && msg != 'null' && msg != '' ){
    	    		alert(msg);
    	    	}
        	}
             
        function verifyField(){
            let element = document.getElementById("name");
            let msg = "이름을 입력하세요";
            if( !isValid (element,msg) ){
                return false;
            }
            console.log("1");
            element  = document.getElementById("phone");
            msg = "핸드폰 번호를 입력하세요.";
            if( !isValid (element,msg) ){
                return false;
            } 
            element  = document.getElementById("email");
            msg = "이메일을 입력하세요.";
            if( !isValid (element,msg) ){
                return false;
            }
            element  = document.getElementById("phone");
            msg = "숫자로만 핸드폰 번호를 입력하세요.";
            if( !number (element,msg) ){
                return false;
            } 
            console.log("2");
            return true;
        }
   
        
        function number(element, msg) {
            let result = false;
            if (isNaN(element.value) || element.value.trim() === '') {
                alert(msg);
                element.focus();
            } else {
                result = true;
            }
            console.log("3");
            return result;
        }
        
        function isValid(element, msg){
            let result = false;
            if(element.value == ''){
                alert(msg);
                element.focus();
                result = false;
            }else{
                result = true;
            }
            console.log("4");
            return result;
        }
        
    </script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">비밀번호 찾기</h3></div>
                                    <div class="card-body">
                                        <div class="small mb-3 text-muted">정보를 입력해 주세요</div>
                                        <form action="${pageContext.servletContext.contextPath}/findPwd" method="post">
                                        
                                        	<div class="form-floating mb-3">
                                                <input class="form-control" id="name" name="name" type="text"  />
                                                <label for="name">이름</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                
                                                <input class="form-control" id="phone" name="phone" type="tel"  />
                                                <label for="phone">핸드폰 번호</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="email" name="email" type="email"  />
                                                <label for="email">이메일</label>
                                            </div>
                                            
                                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="${pageContext.servletContext.contextPath}/login">로그인 하러 가기</a>
                                                <%-- <a class="btn btn-warning" href="${pageContext.servletContext.contextPath}/view/login.jsp">전송</a> --%>
                                                <input class="btn btn-warning btn-block" type="submit" value="전송" onclick="return verifyField();">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="${pageContext.servletContext.contextPath}/join">회원가입</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
