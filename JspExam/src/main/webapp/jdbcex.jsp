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
	    // 오라클의 JDBC 드라이버 이름
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    // jdbc:oracle:thin:@{호스트 이름}?TNS_ADMIN={Wallet파일 위치경로}
	    String url = "jdbc:oracle:thin:@dinkdb_medium?" +
	            "TNS_ADMIN=/Users/test/Wallet_DinkDB";
	    String user = "DA2316";
	    String passwd = "Data16";
	    // DriverManager를 이용해서 Connection 생성한다.
	    conn = DriverManager.getConnection(url, user, passwd);
	
	    // 연결이 성공했을 경우 연결 완료 메시지를 표시합니다.
	    out.println("데이터베이스 연결이 성공적으로 완료되었습니다.");
	    // 여기에서 Connection 객체를 사용하여 작업을 수행하면 됩니다.
	
	} catch (ClassNotFoundException e) {
	    // 드라이버 로드 중 예외가 발생한 경우 처리합니다.
	    e.printStackTrace();
	} catch (SQLException e) {
	    // 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
	    e.printStackTrace();
	} finally {
	    // 작업이 끝난 후 Connection을 닫습니다.
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