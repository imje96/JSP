<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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


	Object obj1 = session.getAttribute("mySessionNames");
	String mySessionName = (String)obj1;
	out.println("mySessionName : " + mySessionName + "<br/>");
	
	Object obj2 = session.getAttribute("myNum");
	String myNum = (String)obj2;
	out.println("myNum : " + myNum + "<br/>");
	
	out.println("====================================================== <br/>");
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	long creationTime = session.getCreationTime();
	String creationTimeStr = dateFormat.format(new Date(creationTime));
	
	long lastTime = session.getLastAccessedTime();
	String lastTimeStr = dateFormat.format(new Date(lastTime));
	
	out.println("���������ð� : " + session.getMaxInactiveInterval() + "<br/>");
	out.println("���� ID : " + session.getId() + "<br/>");
	out.println("���ǽ��۽ð� : " + creationTimeStr + "<br/>");
	out.println("���������ð� : " + lastTimeStr + "<br/>");

%>
</body>
</html>

