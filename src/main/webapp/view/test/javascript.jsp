<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"
     integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
     crossorigin="anonymous"></script>
<script>
window.onload = function() {
	

    getPublicData(1, 100);
    
  };
function getPublicData(page, perPage) {
	  const url = "https://api.odcloud.kr/api/15111389/v1/uddi:41944402-8249-4e45-9e9d-a52d0a7db1cc";
	  const param = {
	    page: page,
	    perPage: perPage,
	    serviceKey: "XKL1GkKtwYuho4vgELMsHwLJu1cEuZFc2YKWsqSlNEIumOcQnDtstUKKhsDGNQ9o4v3bg4HIy9TBQs47uLnJDw=="
	  };

	  $.ajax({
	    url: url, // 서버 측 경로
	    type: "POST",
	    _type:"json",
	    data: { apiData: JSON.stringify(param) },
	    success: function (response) {
	      console.log("API 데이터를 SQL 데이터베이스에 저장했습니다.");
	    },
	    error: function (jqXHR, textStatus, errorThrown) {
	      console.error(jqXHR);
	      console.error(textStatus);
	      console.error(errorThrown);
	    }
	  });
	} 
</script>
</head>
<body>

</body>
</html>