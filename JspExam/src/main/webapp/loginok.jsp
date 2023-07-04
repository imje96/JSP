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
    
    if (id.equals("admin") && password.equals("1234")) {
    
         
        response.sendRedirect("welcome.jsp?id=" + id); // 로그인 성공 시 이동할 페이지로 리다이렉트 할 때는 
        //url만 넘어가기 때문에 파라미터 값을 넘겨줘야 하는 것임
    } else {
        out.println("로그인에 실패했습니다. 사용자 이름과 비밀번호를 확인해주세요.");
        response.sendRedirect("login.jsp");
    }
%>

</body>
</html>