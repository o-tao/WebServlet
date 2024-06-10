<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<h2>DB 연동</h2>

<%
  Connection conn=null;

  try{
	 String jdbcUrl = "jdbc:mariadb://localhost:23306/edu";
     String dbId = "root"; // 설정된 id
     String dbPass = "1234"; // 설정된 password
	
	 Class.forName("org.mariadb.jdbc.Driver");
	 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	 out.println("연결 성공");
  }catch(Exception e){ 
	 e.printStackTrace();
  }
%>
