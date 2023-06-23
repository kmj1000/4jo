<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My 37th Page - Json 또 Test</title>
    <script src="https://code.jquery.com/jquery-3.7.0.js"
     integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" 
     crossorigin="anonymous"></script>
    <script src="js/js_sysout.js"></script>
    <script src="js/js_table.js"></script>
    
    <style>
       
        table, table td, table th {
            border: 1px red solid;    
            width: 50%;       
            text-align: center;
        }
        tr:nth-of-type(2n){
            background-color: blue;
            color:aqua;
        }
        tr:nth-of-type(2n+1){
            background-color: yellow;
            color:black;
        }
        tr:first-child{
            background-color:transparent;
            color:black;
        }
        img{
        	width:200;
        	height:200;
        }
    </style>
    <script>
    window.onload = function() {
    	
       
        getPublicData(1, 100);
        
      };
       
        
        function display(array) {
            let jsonObj;
       
            const box_tb_json=document.getElementById("box-tb-json");
            const table=new Table('box-table');
            table.makeTr();
            table.insertElement('th',field.happenDt);
            table.insertElement('th',field.happenPlace);
            table.insertElement('th',field.kindCd);
            table.insertElement('th',field.colorCd);
            table.insertElement('th',field.age);
            table.insertElement('th',field.weight);
            table.insertElement('th',field.noticeNo);
            table.insertElement('th',field.noticeSdt);
            table.insertElement('th',field.noticeEdt);
            table.insertElement('th',field.filename);
            table.insertElement('th',field.processState);
            table.insertElement('th',field.sexCd);
            table.insertElement('th',field.neuterYn);
            table.insertElement('th',field.specialMark);
            table.insertElement('th',field.careNm);
            table.insertElement('th',field.careTel);
            table.insertElement('th',field.careAddr);
            table.insertTr2Table();
            
            box_tb_json.appendChild(table.toTable());
        
            for(var i=0; i<array.length;i++){
                jsonObj=array[i];
                insertRow(table,jsonObj);
               
                let img = document.createElement("img");
               
                img.src = array[i].popfile;
                img.width = 200;
                img.height = 200;
                let imgWrapper = document.createElement("div");
                imgWrapper.style.width = "200px";
                imgWrapper.style.height = "200px";

                // 이미지를 imgWrapper에 추가
                imgWrapper.appendChild(img);

                // 이미지 주소를 없애기 위해 해당 속성을 제거
                delete array[i].popfile;

                $("td:contains('" + jsonObj[field.filename] + "')").empty().append(imgWrapper);         
            }           
        }
  

  const field={
		  happenDt : "happenDt"
		  ,happenPlace : "happenPlace"
		  ,kindCd : "kindCd"
		  ,colorCd : "colorCd"
		  ,age : "age"
            ,weight : "weight"
            ,noticeNo:"noticeNo"
            ,noticeSdt: "noticeSdt"
            ,noticeEdt: "noticeEdt"
            ,filename:"filename"
            ,processState: "processState"           	
            ,sexCd: "sexCd"
            ,neuterYn: "neuterYn"
            ,specialMark: "specialMark"
            ,careNm: "careNm"
            ,careTel: "careTel"
            ,careAddr: "careAddr"
        };
  
  
  
        function insertRow(tableElement,jsonObj) {
        	 tableElement.makeTr();
     
           
            tableElement.insertElement('td',jsonObj[field.happenDt]);
            tableElement.insertElement('td',jsonObj[field.happenPlace]);
            tableElement.insertElement('td',jsonObj[field.kindCd]);
            tableElement.insertElement('td',jsonObj[field.colorCd]);
            tableElement.insertElement('td',jsonObj[field.age]);
            tableElement.insertElement('td',jsonObj[field.weight]);
            tableElement.insertElement('td',jsonObj[field.noticeNo]);
            tableElement.insertElement('td',jsonObj[field.noticeSdt]);
            tableElement.insertElement('td',jsonObj[field.noticeEdt]);
            tableElement.insertElement('td',jsonObj[field.filename]);
            tableElement.insertElement('td',jsonObj[field.processState]);
            tableElement.insertElement('td',jsonObj[field.sexCd]);
            tableElement.insertElement('td',jsonObj[field.neuterYn]);
            tableElement.insertElement('td',jsonObj[field.specialMark]);
            tableElement.insertElement('td',jsonObj[field.careNm]);
            tableElement.insertElement('td',jsonObj[field.careTel]);
            tableElement.insertElement('td',jsonObj[field.careAddr]);
        
            tableElement.insertTr2Table();
        }
        function getPublicData(page, perPage) {
            const url = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic";
            const decoded = "XKL1GkKtwYuho4vgELMsHwLJu1cEuZFc2YKWsqSlNEIumOcQnDtstUKKhsDGNQ9o4v3bg4HIy9TBQs47uLnJDw==";
            const encoded = encodeURIComponent(decoded);
          
            const param = {
              pageNo: page,
              numOfRows: perPage,
              _type:'json'
              ,serviceKey: decoded
            };
          
            $.ajax({
              url: url,
              async: true,
              contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
              type: "POST",
              data: param,
              dataType: "json",
              success: function(data, textStatus) {
            	let array = data.response.body.items.item;
            	
            	
                display(array);
                
              },
              error: function(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
              }
            });
          }
     
  
  
    
        

        
    </script>
</head>
<body>
	
    <div id="box-tb-json"></div>
    <div id="box-div"></div>
</body>
</html>