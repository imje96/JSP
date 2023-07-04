<%@page import="com.daodto.MemberDTO"%>
<%@page import="com.daodto.MemberDAO"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");	
	MemberDAO memberDAO = new MemberDAO();
	if(memberDAO.loginCheck(id, pw)){
        
        session.setAttribute("id", id);
        session.setAttribute("pw", pw);
		response.sendRedirect("/MemberEx/main.jsp");

	}
	else{
	    out.println("로그인 실패하였습니다.");
	    response.sendRedirect("/MemberEx/LoginEx/login.jsp");
	}

	%>

</body>
</html>