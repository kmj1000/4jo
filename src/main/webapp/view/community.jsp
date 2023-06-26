<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.java.servlet.vo.CommunityVO"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Community List</title>
        <!-- <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" /> -->
        <link href="${pageContext.servletContext.contextPath}/bootstrap/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.servletContext.contextPath}/bootstrap/css/page-nation.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.servletContext.contextPath}/bootstrap/js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.servletContext.contextPath}/bootstrap/js/datatables-simple-demo.js"></script>
        <script type="text/javascript">
				// <![CDATA[
						var sparks=75; // how many sparks per clicksplosion
						var speed=33; // how fast - smaller is faster
						var bangs=5; // how many can be launched simultaneously (note that using too many can slow the script down)
						var colours=new Array('#03f', '#f03', '#0e0', '#93f', '#0cf', '#f93', '#f0c'); 
						//                     blue    red     green   purple  cyan    orange  pink
						
						/****************************
						*   Clicksplosion Effect    *
						*(c)2012-3 mf2fm web-design *
						*  http://www.mf2fm.com/rv  *
						* DON'T EDIT BELOW THIS BOX *
						****************************/
						var intensity=new Array();
						var Xpos=new Array();
						var Ypos=new Array();
						var dX=new Array();
						var dY=new Array();
						var stars=new Array();
						var decay=new Array();
						var timers=new Array();
						var swide=800;
						var shigh=600;
						var sleft=sdown=0;
						var count=0;
						
						function addLoadEvent(funky) {
						  var oldonload=window.onload;
						  if (typeof(oldonload)!='function') window.onload=funky;
						  else window.onload=function() {
						    if (oldonload) oldonload();
						    funky();
						  }
						}
						
						addLoadEvent(clicksplode);
						
						function clicksplode() { if (document.getElementById) {
						  var i, j;
						  window.onscroll=set_scroll;
						  window.onresize=set_width;
						  document.onclick=eksplode;
						  set_width();
						  set_scroll();
						  for (i=0; i<bangs; i++) for (j=sparks*i; j<sparks+sparks*i; j++) {
						    stars[j]=createDiv('*', 13);
						    document.body.appendChild(stars[j]);
						  }
						}}
						
						function createDiv(char, size) {
						  var div, sty;
						  div=document.createElement('div');
						  sty=div.style;
						  sty.font=size+'px monospace';
						  sty.position='absolute';
						  sty.backgroundColor='transparent';
						  sty.visibility='hidden';
						  sty.zIndex='101';
						  div.appendChild(document.createTextNode(char));
						  return (div);
						}
						
						function bang(N) {
						  var i, Z, A=0;
						  for (i=sparks*N; i<sparks*(N+1); i++) { 
						    if (decay[i]) {
						      Z=stars[i].style;
						      Xpos[i]+=dX[i];
						      Ypos[i]+=(dY[i]+=1.25/intensity[N]);
						      if (Xpos[i]>=swide || Xpos[i]<0 || Ypos[i]>=shigh+sdown || Ypos[i]<0) decay[i]=1;
							  else {
						        Z.left=Xpos[i]+'px';
						        Z.top=Ypos[i]+'px';
							  }
						      if (decay[i]==15) Z.fontSize='7px';
						      else if (decay[i]==7) Z.fontSize='2px';
						      else if (decay[i]==1) Z.visibility='hidden';
							  decay[i]--;
							}
							else A++;
						  }
						  if (A!=sparks) timers[N]=setTimeout('bang('+N+')', speed);
						}
						
						function eksplode(e) { 
						  var x, y, i, M, Z, N;
						  set_scroll();
						  y=(e)?e.pageY:event.y+sdown;
						  x=(e)?e.pageX:event.x+sleft;
						  N=++count%bangs;
						  M=Math.floor(Math.random()*3*colours.length);
						  intensity[N]=5+Math.random()*4;
						  for (i=N*sparks; i<(N+1)*sparks; i++) {
						    Xpos[i]=x;
						    Ypos[i]=y-5;
						    dY[i]=(Math.random()-0.5)*intensity[N];
						    dX[i]=(Math.random()-0.5)*(intensity[N]-Math.abs(dY[i]))*1.25;
						    decay[i]=16+Math.floor(Math.random()*16);
						    Z=stars[i].style;
						    if (M<colours.length) Z.color=colours[i%2?count%colours.length:M];
						    else if (M<2*colours.length) Z.color=colours[count%colours.length];
						    else Z.color=colours[i%colours.length];
						    Z.fontSize='13px';
						    Z.visibility='visible';
						  }
						  clearTimeout(timers[N]);
						  bang(N);
						} 
						
						function set_width() {
						  var sw_min=999999;
						  var sh_min=999999;
						  if (document.documentElement && document.documentElement.clientWidth) {
						    if (document.documentElement.clientWidth>0) sw_min=document.documentElement.clientWidth;
						    if (document.documentElement.clientHeight>0) sh_min=document.documentElement.clientHeight;
						  }
						  if (typeof(self.innerWidth)=='number' && self.innerWidth) {
						    if (self.innerWidth>0 && self.innerWidth<sw_min) sw_min=self.innerWidth;
						    if (self.innerHeight>0 && self.innerHeight<sh_min) sh_min=self.innerHeight;
						  }
						  if (document.body.clientWidth) {
						    if (document.body.clientWidth>0 && document.body.clientWidth<sw_min) sw_min=document.body.clientWidth;
						    if (document.body.clientHeight>0 && document.body.clientHeight<sh_min) sh_min=document.body.clientHeight;
						  }
						  if (sw_min==999999 || sh_min==999999) {
						    sw_min=800;
						    sh_min=600;
						  }
						  swide=sw_min-7;
						  shigh=sh_min-7;
						}
						
						function set_scroll() {
						  if (typeof(self.pageYOffset)=='number') {
						    sdown=self.pageYOffset;
						    sleft=self.pageXOffset;
						  }
						  else if (document.body && (document.body.scrollTop || document.body.scrollLeft)) {
						    sdown=document.body.scrollTop;
						    sleft=document.body.scrollLeft;
						  }
						  else if (document.documentElement && (document.documentElement.scrollTop || document.documentElement.scrollLeft)) {
						    sleft=document.documentElement.scrollLeft;
						    sdown=document.documentElement.scrollTop;
						  }
						  else {
						    sdown=0;
						    sleft=0;
						  }
						}
					// ]]>
		</script>
     <style type="text/css">* {cursor: url(https://cur.cursors-4u.net/holidays/hol-4/hol336.cur), auto !important;}</style>   
     <style type="text/css">.adfit__swipeable{-webkit-tap-highlight-color:transparent;cursor:default;height:100%;left:0;outline:none;position:absolute;top:0;width:100%}</style>
        
    </head>
    
   <body class="sb-nav-fixed"> 
          
        <nav class=" ps-5 sb-topnav navbar navbar-expand; navbar-dark bg-yellow" >
        <img class = "ps-5 img_main" src="../dogfoot.png" style="width: 120px; height: 70px;"/><br/>
             <a class="navbar-brand ps-1 pe-5" href="index.html" ><h1>옥독캣</h1></a>
              

            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-0 my-md-0 mt-sm-0 ">
                <div class="input-group">
                	<button type="button" class="btn btn-outline-primary" onclick="location='favorite_shelter.jsp'">로그아웃</button>
					<!-- <button type="button" class="btn btn-outline-secondary">Secondary</button>
					<button type="button" class="btn btn-outline-success">Success</button>
					<button type="button" class="btn btn-outline-info">Info</button>
					<button type="button" class="btn btn-outline-warning">Warning</button>
					<button type="button" class="btn btn-outline-danger">Danger</button>
					<button type="button" class="btn btn-outline-light">Light</button> -->
					<button type="button" class="btn btn-outline-danger" onclick="location='favorite_with_pet.jsp'">마이페이지</button>
                </div>
            </form>
        </nav>
        
         <nav class="sb-topnav navbar navbar-expand; navbar-dark bg-yellow" >
           <!--   <nav class="nav nav-pills flex-column flex-sm-row justify-content-evenly"> -->
              <a class="flex-sm-fill text-sm-center nav-link" aria-current="page" href="#"><b>공고</b></a>
              <a class="flex-sm-fill text-sm-center nav-link" href="#" ><b>보호소</b></a>
              <a class="flex-sm-fill text-sm-center nav-link" href="#" ><b>위드펫</b></a>
              <a class="flex-sm-fill text-sm-center nav-link" href="#"><b>커뮤니티</b></a>
              <a class="flex-sm-fill text-sm-center nav-link" href="#"><b>공지사항</b></a>
        <!--  </nav> -->
            </nav>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-10 pt-10">
                        <h1 class="mt-1" >마이페이지</h1>
                        <ol class="breadcrumb mb-4">
 
                        </ol>
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                               개인정보조회
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>작성일</th>
                                            <th>작성자</th>
                                            <!-- <th>조회수</th>  -->
                                        </tr>
                                        <button type="button" class="btn btn-outline-primary">Primary</button>
										<button type="button" class="btn btn-outline-secondary">Secondary</button>
										<button type="button" class="btn btn-outline-success">Success</button>
									<button type="button" class="btn btn-outline-info">Info</button>
									<button type="button" class="btn btn-outline-warning">Warning</button>
									<button type="button" class="btn btn-outline-danger">Danger</button>
									<button type="button" class="btn btn-outline-light">Light</button>
									<button type="button" class="btn btn-outline-dark">Dark</button>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                         	<th>글번호</th>
                                            <th>제목</th>
                                            <th>작성일</th>
                                            <th>작성자</th>
                                            <!-- <th>조회수</th>  -->
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    	<C:forEach var="communityVO" items="${communityList}" varStatus="status">
                                        <tr>
                                            <td>${communityVO.c_no}</td>
                                            <td><a href="${pageContext.servletContext.contextPath}/communitycontent?method=get&c_no=${communityVO.c_no}">${communityVO.title}</a></td>
                                            <td>${communityVO.reg_date}</td>
                                            <td>${communityVO.nickname}</td>
                                        </tr>
                                        </C:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <%@ include file="/view/import/page-nation.jsp" %>
                           <%--  <jsp:include page="/view/import/page-nation.jsp"></jsp:include> 
                        	<C:import url="/view/import/page-nation.jsp"></C:import> --%>
                        </div>
                    </div>
                </main>
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
        
    </body>
</html>
