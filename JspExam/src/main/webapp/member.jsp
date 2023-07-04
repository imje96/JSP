<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

    <h1>회원 정보 입력</h1>
    <form action="memberProc.jsp" method="post" >
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required><br />
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br />
        
        <label for="name">이름:</label>
        <input type="name" id="name" name="name" required><br />
        
        <label for="email">이메일주소:</label>
        <input type="email" id="email" name="email" required><br />
        
        
        <input type="submit" value="전송"></input>
    </form>


</body>
</html>