<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

		session.setAttribute("MySessionName", id); // id 정보를 세션에 저장
		session.setAttribute("password", password); // password 정보를 세션에 저장


	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		session.setAttribute("id", id); // id 정보를 세션에 저장
		session.setAttribute("password", password); // password 정보를 세션에 저장
		session.setMaxInactiveInterval(60 * 20); // 세션 유효 시간 설정 (임의로 설정할 때만 ex)20분)
        // 설정하지 않았을 때는 web.xml에 default 30분으로 설정 되어 있음 

	%>
	<% 
		String sessionId = session.getId(); // 세션 ID 가져오기
		String sessionUser = (String) session.getAttribute("id"); // 세션에서 사용자 id 정보 가져오기
		String sessionPassword = (String) session.getAttribute("password"); // 세션에서 사용자 password 정보 가져오기
	
		if (sessionUser != null && sessionUser.equals("je") && sessionPassword.equals("1234")) {
			out.println(sessionUser + "님 로그인을 환영합니다.");
		} else if (sessionUser != null && sessionUser.equals("oracle") && sessionPassword.equals("1234")) {
			out.println(sessionUser + "님 로그인을 환영합니다.");
		} else {
	        out.println("로그인에 실패했습니다. 사용자 이름과 비밀번호를 확인해주세요.");
	        response.sendRedirect("session_login.html");
		}
	%>
	
	<br />
	<a href=sessionget.jsp>세션 정보 확인하기</a>
	
</body>
</html>