<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="member" class="com.jieun.jsp.Member" scope="session"/>

	<!-- 멤버 정보 가져오기  -->
    <h1>Member Information</h1>
    <p>Id: <jsp:getProperty name="member" property="id" /></p>
    <p>Password: <jsp:getProperty name="member" property="password" /></p>
    <p>Name: <jsp:getProperty name="member" property="name" /></p>
    <p>Email: <jsp:getProperty name="member" property="email" /></p>
    
  

</body>
</html>