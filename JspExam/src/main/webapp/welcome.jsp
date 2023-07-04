<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	

	
 	    Cookie loginCookie = new Cookie("id", id); // 쿠키 생성
	    loginCookie.setMaxAge(60 * 60 * 24); 
	    response.addCookie(loginCookie); 
	        
	
	%>
		
	
	<a href="logout.jsp">logout</a>
	<a href="logincookie.jsp">쿠키확인하기</a>
	
</body>
</html>


