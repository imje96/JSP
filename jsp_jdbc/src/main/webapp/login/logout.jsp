<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<% String sName = (String)session.getAttribute("name");%>
		<%=sName%>님 로그아웃 하겠습니다.
		<% session.invalidate(); %>
	

</body>
</html>