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
        out.println("jdbc driver �ε� ����<br>");
        DriverManager.getConnection(url, user, password);
        out.println("����Ŭ ���� ����<br>");
    } catch (ClassNotFoundException e) {
        out.println("jdbc driver �ε� ����<br>");
    } catch (SQLException e) {
        out.println("����Ŭ ���� ����<br>");
    }
%>
</body>
</html>