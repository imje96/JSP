<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
	<% 
	/* 	response.setStatus(200);	*/
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	에러 발생 <br/>
	에러유형 : <%= exception.getClass.getName() %> 
	예외 메시지 :<%= exception.getMessage() %>
	예외유형 및 메세지 : <%= %>
</body>
</html>