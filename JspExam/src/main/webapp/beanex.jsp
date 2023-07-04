<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="student" class="com.jieun.jsp.Student" scope="page"/>
	
	<!-- 학생 정보 설정 -->
    <jsp:setProperty name="student" property="name" value="지은" />
    <jsp:setProperty name="student" property="age" value="20" />
    <jsp:setProperty name="student" property="grade" value="1" />
    <jsp:setProperty name="student" property="studentNum" value="20230000" />
    
    <h1>Student Information</h1>
    <p>Name: <jsp:getProperty name="student" property="name" /></p>
    <p>Age: <jsp:getProperty name="student" property="age" /></p>
    <p>Grade: <jsp:getProperty name="student" property="grade" /></p>
    <p>Student Number: <jsp:getProperty name="student" property="studentNum" /></p>
    

	
	
</body>
</html>