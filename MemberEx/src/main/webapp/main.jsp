<%@page import="com.daodto.MemberDTO"%>
<%@page import="com.daodto.MemberDAO"%>
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
		String id = (String)session.getAttribute("id"); 
		out.println(id);
		String pw = (String)session.getAttribute("pw");
		MemberDAO memberDAO = new MemberDAO();
		out.println(memberDAO.memberSelect(id).getName() + "님 환영합니다.");		
	%>
	<br/>
	<a href="/JspClass/com/daodto/MemberEx/LoginEx/logout.jsp">로그아웃</a>
	<br/>
	<a href="/JspClass/com/daodto/MemberEx/ModifyEx/modify.jsp">회원정보수정</a>
</body>
</html>