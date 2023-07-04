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
    <form action="insertData.jsp" method="post" >
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required><br />
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br />
        
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br />
        
        <label for="tel">전화번호:</label>
        <input type="tel" id="tel" name="tel" required><br />
        
        
        <input type="submit" value="전송"></input>
        <input type="reset" value="초기화"></input>
    </form>


</body>
</html>