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
		<%=sName%>�� �α׾ƿ� �ϰڽ��ϴ�.
		<% session.invalidate(); %>
	

</body>
</html>