<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	파라미터 전송: <c:out value="${param.name }"/>
	<hr>
	
	<!-- set/out 사용 예 -->
	<c:set var="mName" value="홍길동"/>
	VarName : <c:out value="${mName }" />
	<br/>
	
	<!--  remove 사용 예 -->
	<c:remove var="mName"/>
	VarName 제거 후: <c:out value="${mName}" />
	<hr/>



</body>
</html>