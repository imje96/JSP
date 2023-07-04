<%@page import="java.util.Enumeration"%>
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
	session.removeAttribute("mySessionName");
	Enumeration<String> enumerational = session.getAttributeNames();
	
	while(enumerational.hasMoreElements()) {
		String sName = enumerational.nextElement().toString();
		String sValue = session.getAttribute(sName).toString();
		
		
		out.println("sName: " + sName + "<br />");
		out.println("sName: " + sValue + "<br />");
	}
	
	out.println("========================================== <br />");
	
	session.invalidate();
	if(request.isRequestedSessionIdValid()) {
		out.println("session valid" + "<br />");		
	} else {
		out.println("session invalid" + "<bra />");
	}
	
	%>
	
	<a href="sessionget.jsp">session get</a>

</body>
</html>