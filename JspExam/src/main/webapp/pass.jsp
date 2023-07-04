<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String age;	
%>
<%
	age = request.getParameter("age");
%>

	당신의 나이는 <%= age %> 로 성인입니다.<br />


</body>
</html>