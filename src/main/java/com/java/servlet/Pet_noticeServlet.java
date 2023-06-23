
package com.java.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Pet_noticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 요청 파라미터 가져오기
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        reader.close();

        try {
            // JSON 데이터 파싱
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(requestBody.toString());
            JSONObject apiData = (JSONObject) jsonObject.get("apiData");

            // API 데이터 필드 가져오기
            String happenDt = apiData.get("happenDt").toString();
            String happenPlace = apiData.get("happenPlace").toString();
            String kindCd = apiData.get("kindCd").toString();
            String colorCd = apiData.get("colorCd").toString();
            String age = apiData.get("age").toString();
            String weight = apiData.get("weight").toString();
            String noticeNo = apiData.get("noticeNo").toString();
            String noticeSdt = apiData.get("noticeSdt").toString();
            String noticeEdt = apiData.get("noticeEdt").toString();
            String popfile = apiData.get("popfile").toString();
            String processState = apiData.get("processState").toString();
            String sexCd = apiData.get("sexCd").toString();
            String neuterYn = apiData.get("neuterYn").toString();
            String specialMark = apiData.get("specialMark").toString();
            String careNm = apiData.get("careNm").toString();
            String careTel = apiData.get("careTel").toString();
            String careAddr = apiData.get("careAddr").toString();

            // JDBC 연결 정보
            String url = "jdbc:oracle:thin:@localhost:1521:XE";  // 데이터베이스 URL
            String username = "c##abd";  // 데이터베이스 사용자명
            String password = "abd";  // 데이터베이스 비밀번호

            // 데이터베이스 연결 및 데이터 저장
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                // SQL 쿼리 및 PreparedStatement 생성
            	String sql = "INSERT INTO pet_notice (happenDt, happenPlace, kindCd, colorCd, age, weight, noticeNo, noticeSdt, noticeEdt, popfile, processState, sexCd, neuterYn, specialMark, careNm, careTel, careAddr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, happenDt);
                statement.setString(2, happenPlace);
                statement.setString(3, kindCd);
                statement.setString(4, colorCd);
                statement.setString(5, age);
                statement.setString(6, weight);
                statement.setString(7, noticeNo);
                statement.setString(8, noticeSdt);
                statement.setString(9, noticeEdt);
                statement.setString(10, popfile);
                statement.setString(11, processState);
                statement.setString(12, sexCd);
                statement.setString(13, neuterYn);
                statement.setString(14, specialMark);
                statement.setString(15, careNm);
                statement.setString(16, careTel);
                statement.setString(17, careAddr);

                // SQL 실행
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("API 데이터를 데이터베이스에 저장했습니다.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // 응답 설정
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println("{ \"message\": \"API 데이터를 저장했습니다.\" }");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}