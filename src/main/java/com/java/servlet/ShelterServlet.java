package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@WebServlet("/Shelter")
public class ShelterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Oracle 데이터베이스 연결 정보
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String DB_USER = "c##abd";
    private static final String DB_PASSWORD = "abd";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 전달된 API 데이터 추출
    	String careNmString = request.getParameter("careNm");
        String divisionNmString = request.getParameter("divisionNm");
        String saveTrgtAnimalString = request.getParameter("saveTrgtAnimal");
        String careAddrString = request.getParameter("careAddr");
        String weekOprStimeString = request.getParameter("weekOprStime");
        String weekOprEtimeString = request.getParameter("weekOprEtime");
        String weekCellStimeString = request.getParameter("weekCellStime");
        String weekCellEtimeString = request.getParameter("weekCellEtime");
        String weekendOprStimeString = request.getParameter("weekendOprStime");
        String weekendOprEtimeString = request.getParameter("weekendOprEtime");
        String weekendCellStimeString = request.getParameter("weekendCellStime");
        String weekendCellEtimeString = request.getParameter("weekendCellEtime");
        String closeDayString = request.getParameter("closeDay");
        String careTelString = request.getParameter("careTel");
        // JSON 문자열을 객체로 변환
        JsonObject careNm = new JsonParser().parse(careNmShelter).getAsJsonObject();
        JsonObject divisionNm = new JsonParser().parse(divisionNmShelter).getAsJsonObject();
        JsonObject saveTrgtAnimal = new JsonParser().parse(saveTrgtAnimalShelter).getAsJsonObject();
        JsonObject careAddr = new JsonParser().parse(careAddrShelter).getAsJsonObject();
        JsonObject weekOprStime = new JsonParser().parse(weekOprStimeShelter).getAsJsonObject();
        JsonObject weekOprEtime = new JsonParser().parse(weekOprEtimeShelter).getAsJsonObject();
        JsonObject weekCellStime = new JsonParser().parse(weekCellStimeShelter).getAsJsonObject();
        JsonObject weekCellEtime = new JsonParser().parse(weekCellEtimeShelter).getAsJsonObject();
        JsonObject weekendOprStime = new JsonParser().parse(weekendOprStimeShelter).getAsJsonObject();
        JsonObject weekendOprEtime = new JsonParser().parse(weekendOprEtimeShelter).getAsJsonObject();
        JsonObject weekendCellStime = new JsonParser().parse(weekendCellStimeShelter).getAsJsonObject();
        JsonObject weekendCellEtime = new JsonParser().parse(weekendCellEtimeShelter).getAsJsonObject();
        JsonObject closeDay = new JsonParser().parse(closeDayShelter).getAsJsonObject();
        JsonObject careTel = new JsonParser().parse(careTelShelter).getAsJsonObject();
       
        // Oracle 데이터베이스에 연결
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // API 데이터를 Oracle 데이터베이스에 삽입하는 SQL 쿼리 작성
            String query = "INSERT INTO shelter (careNm,divisionNm,saveTrgtAnimal,"
            		+"careAddr,weekOprStime,weekOprEtime,weekCellStime,weekCellEtime,"
            		+"weekendOprStime,weekendOprEtime,weekendCellStime,weekendCellEtime,"
            		+"closeDay,careTel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
            statement = connection.prepareStatement(query);
          
            statement.setString(1, careNm.get("careNm").getAsString());
            statement.setString(2, divisionNm.get("divisionNm").getAsString());
            statement.setString(3, saveTrgtAnimal.get("saveTrgtAnimal").getAsString());
            statement.setString(4, careAddr.get("careAddr").getAsString());
            statement.setString(5, weekOprStime.get("weekOprStime").getAsString());
            statement.setString(6, weekOprEtime.get("weekOprEtime").getAsString());
            statement.setString(7, weekCellStime.get("weekCellStime").getAsString());
            statement.setString(8, weekCellEtime.get("weekCellEtime").getAsString());
            statement.setString(9, weekendOprStime.get("weekendOprStime").getAsString());
            statement.setString(10, weekendOprEtime.get("weekendOprEtime").getAsString());
            statement.setString(11, weekendCellStime.get("weekendCellStime").getAsString());
            statement.setString(12, weekendCellEtime.get("weekendCellEtime").getAsString());
            statement.setString(13, closeDay.get("closeDay").getAsString());
            statement.setString(14, careTel.get("careTel").getAsString());
            // SQL 쿼리 실행
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // 데이터가 성공적으로 삽입되었음을 응답으로 전송
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h2>API 데이터가 성공적으로 저장되었습니다.</h2>");
                out.println("</body></html>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // 오류 처리
            e.printStackTrace();
        } finally {
            // 연결 및 자원 해제
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}