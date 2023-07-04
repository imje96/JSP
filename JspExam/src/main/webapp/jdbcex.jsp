<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.lang.ClassNotFoundException" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	Connection conn = null;
	try {
	    // ����Ŭ�� JDBC ����̹� �̸�
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    // jdbc:oracle:thin:@{ȣ��Ʈ �̸�}?TNS_ADMIN={Wallet���� ��ġ���}
	    String url = "jdbc:oracle:thin:@dinkdb_medium?" +
	            "TNS_ADMIN=/Users/test/Wallet_DinkDB";
	    String user = "DA2316";
	    String passwd = "Data16";
	    // DriverManager�� �̿��ؼ� Connection �����Ѵ�.
	    conn = DriverManager.getConnection(url, user, passwd);
	
	    // ������ �������� ��� ���� �Ϸ� �޽����� ǥ���մϴ�.
	    out.println("�����ͺ��̽� ������ ���������� �Ϸ�Ǿ����ϴ�.");
	    // ���⿡�� Connection ��ü�� ����Ͽ� �۾��� �����ϸ� �˴ϴ�.
	
	} catch (ClassNotFoundException e) {
	    // ����̹� �ε� �� ���ܰ� �߻��� ��� ó���մϴ�.
	    e.printStackTrace();
	} catch (SQLException e) {
	    // �����ͺ��̽� ���� �� ���� ���� �� ���ܰ� �߻��� ��� ó���մϴ�.
	    e.printStackTrace();
	} finally {
	    // �۾��� ���� �� Connection�� �ݽ��ϴ�.
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