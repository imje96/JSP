<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
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
    String upw = "tiger";

    PreparedStatement stmt = null;
    Connection conn = null;
    
	try {
	    Class.forName(driver);
	    out.println("jdbc driver �ε� ����<br>");
	    conn = DriverManager.getConnection(url, user, upw);
	    out.println("����Ŭ ���� ����<br>");

	    String id = request.getParameter("id");
	    String pw = request.getParameter("password");
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone"); 

	    String sql = "INSERT INTO MEMBERS (id, password, name, phone) VALUES (?, ?, ?, ?)";
	    stmt = conn.prepareStatement(sql);
	    stmt.setString(1, id);
	    stmt.setString(2, pw);
	    stmt.setString(3, name);
	    stmt.setString(4, phone);

	    stmt.executeUpdate();

	    out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
	} catch (ClassNotFoundException e) {
	    out.println("jdbc driver �ε� ����<br>");
	    e.printStackTrace();
	} catch (SQLException e) {
	    out.println("����Ŭ ���� ����<br>");
	    e.printStackTrace();
	} finally {
	    // Close resources in the finally block
	    if (stmt != null) {
	        try {
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    if (conn != null) {
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	%>


</body>
</html>