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
	Cookie[] cookies = request.getCookies();
	for(int i=0; i < cookies.length; i++) {
		String str = cookies[i].getName();

	
		if(str.equals("Cookie1")) {
			cookies[i].setMaxAge(0);
			
			response.addCookie(cookies[i]);
			
			out.println("������ ��Ű�� �Ӽ� �̸�(name[" + i + "]): " + cookies[i].getName() + "<br />");
			out.println("������ ��Ű�� �Ӽ� ��(value[" + i + "]): " + cookies[i].getValue() + "<br />");
			out.println("--------------------------------------------------------------------------");
		
		}
	
	}	
	
	%>
	
</body>
</html>