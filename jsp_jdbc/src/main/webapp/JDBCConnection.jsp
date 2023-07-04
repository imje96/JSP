<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.DriverManager, java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
    String user = "scott";
    String password = "tiger";
    try {
        Class.forName(driver);
        out.println("jdbc driver 로딩 성공<br>");
        DriverManager.getConnection(url, user, password);
        out.println("오라클 연결 성공<br>");
    } catch (ClassNotFoundException e) {
        out.println("jdbc driver 로딩 실패<br>");
    } catch (SQLException e) {
        out.println("오라클 연결 실패<br>");
    }
%>
</body>
</html>