package com.java.test;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class test2 {
   public static void main(String[] args) {
      try {
         // API 호출 및 XML 파싱
         URL url = new URL("https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo?numOfRows=207&pageNo=1&serviceKey=XKL1GkKtwYuho4vgELMsHwLJu1cEuZFc2YKWsqSlNEIumOcQnDtstUKKhsDGNQ9o4v3bg4HIy9TBQs47uLnJDw==");
         
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         InputStream inputStream = url.openStream();

         try {
        	
        	    byte[] buffer = new byte[1024];
        	    int bytesRead;
        	    StringBuilder stringBuilder = new StringBuilder();

        	    while ((bytesRead = inputStream.read(buffer)) != -1) {
        	        stringBuilder.append(new String(buffer, 0, bytesRead, "UTF-8"));
        	    }

        	    String result = stringBuilder.toString();
        	    System.out.println(result);
        	 
         }catch(Exception e) {
        	 e.printStackTrace();
         }
         
        	    // 변환된 문자열(result)을 사용합니다.
//         Document doc = dbFactory.newDocumentBuilder().parse(url.openStream());
//         System.out.println(doc);
         // DB 연결
//
//         Class.forName("oracle.jdbc.driver.OracleDriver");
//         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##abd", "abd");
//         // 삽입 쿼리 실행
//         NodeList nodeList = doc.getElementsByTagName("item");
//         String query = "INSERT INTO shelter (careNmShelter ,divisionNm ,saveTrgtAnimal ,careAddrShelter ,weekOprStime ,weekOprEtime "
//         		+ ",weekCellStime ,weekCellEtime ,weekendOprStime ,weekendOprEtime ,weekendCellStime, weekendCellEtime, closeDay, careTelShelter)"
//               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//         // 넣을 테이블 이랑 컬럼
//         PreparedStatement stmt = conn.prepareStatement(query);
//
//         for (int i = 0; i < nodeList.getLength(); i++) {
//            Element element = (Element) nodeList.item(i);
////            int shelter_no = i+1;
//            String careNm = element.getElementsByTagName("careNm").item(0).getTextContent();
//            String divisionNm = element.getElementsByTagName("divisionNm").item(0).getTextContent();
//            String saveTrgtAnimal = element.getElementsByTagName("saveTrgtAnimal").item(0).getTextContent();
////            Integer saveTrgtAnimal= Integer.parseInt(element.getElementsByTagName("saveTrgtAnimal").item(0).getTextContent());
//            String careAddr = element.getElementsByTagName("careAddr").item(0).getTextContent();
//            String weekOprStime = element.getElementsByTagName("weekOprStime").item(0).getTextContent();
//            String weekOprEtime = element.getElementsByTagName("weekOprEtime").item(0).getTextContent();
//            String weekCellStime = element.getElementsByTagName("weekCellStime").item(0).getTextContent();
//            String weekCellEtime = element.getElementsByTagName("weekCellEtime").item(0).getTextContent();
//            String weekendOprStime = element.getElementsByTagName("weekendOprStime").item(0).getTextContent();
//            String weekendOprEtime = element.getElementsByTagName("weekendOprEtime").item(0).getTextContent();
//            String weekendCellStime = element.getElementsByTagName("weekendCellStime").item(0).getTextContent();
//            String weekendCellEtime = element.getElementsByTagName("weekendCellEtime").item(0).getTextContent();
//            String closeDay = element.getElementsByTagName("closeDay").item(0).getTextContent();
//            String careTel = element.getElementsByTagName("careTel").item(0).getTextContent();
//
////            stmt.setInt(1, shelter_no);
//            stmt.setString(1, careNm);
//            stmt.setString(2, divisionNm);
////            stmt.setInt(3, saveTrgtAnimal);
//            stmt.setString(3, saveTrgtAnimal);
//            stmt.setString(4, careAddr);
//            stmt.setString(5, weekOprStime);
//            stmt.setString(6, weekOprEtime);
//            stmt.setString(7, weekCellStime);
//            stmt.setString(8, weekCellEtime);
//            stmt.setString(9, weekendOprStime);
//            stmt.setString(10, weekendOprEtime);
//            stmt.setString(11, weekendCellStime);
//            stmt.setString(12, weekendCellEtime);
//            stmt.setString(13, closeDay);
//            stmt.setString(14, careTel);
//
//            stmt.executeUpdate();
//         }

//         stmt.close();
//         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}