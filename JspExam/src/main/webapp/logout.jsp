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

	
		if(str.equals("id")) {
			cookies[i].setMaxAge(0);
			
			response.addCookie(cookies[i]);
			
			out.println("현재 설정한 쿠키의 개수 =>" + cookies.length + "<br />");
			out.println("=====================================================<br />");
			out.println("삭제할 쿠키의 속성 이름(name[" + i + "]): " + cookies[i].getName() + "<br />");
			out.println("삭제된 쿠키의 속성 값(value[" + i + "]): " + cookies[i].getValue() + "<br />");
			out.println("--------------------------------------------------------------------------");
		
		}
	
	}
	
/* 	if(cookies != null) {
		for(int i=0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("id") || cookies[i].getName().equals("pw")) {
				cookies[i].setMaxAge(0);
				
				 */
			}
		}
	}
	
    // 로그아웃 후 리다이렉트할 페이지로 이동합니다.
/*     response.sendRedirect("login.jsp"); */
    
%>

</body>
</html>