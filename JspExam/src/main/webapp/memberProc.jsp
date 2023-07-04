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




		<!-- 멤버 정보 설정 -->
<%--     <jsp:setProperty name="member" property="id" value="${param.id}" />
    <jsp:setProperty name="member" property="password" value="${param.password}" />
    <jsp:setProperty name="member" property="name" value="${param.name}" />
    <jsp:setProperty name="member" property="email" value="${param.email}" /> --%>
    
    
	<% String id = request.getParameter("id");
 	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String eamil = request.getParameter("eamil"); %>
 
 	
    <jsp:setProperty name="member" property="id" param="id" />
    <jsp:setProperty name="member" property="password" param="password" />
    <jsp:setProperty name="member" property="name" param="name" />
    <jsp:setProperty name="member" property="email" param="email" />
    

	<!-- <a href="memberConfirm.jsp">회원정보 확인</a> -->
    <% response.sendRedirect("memberConfirm.jsp"); %>

</body>
</html>