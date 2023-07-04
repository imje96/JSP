<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="ModifyOk" method="post">
		회원정보 수정<br/>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br />
        
        <label for="tel">전화번호 1:</label>
        <input type="tel" id="tel" name="tel" required><br />
        
        <label for="tel">전화번호 2:</label>
        <input type="tel" id="tel" name="tel" required><br />
        
        <label for="tel">전화번호 3:</label>
        <input type="tel" id="tel" name="tel" required><br />

        <label for="gender">성별 구분:</label>
        <input type="radio" name="gender" value="남" checked ="checked">남, 
        <input type="radio" name="gender" value="여">여 <br />
            
        
        <input type="submit" value="전송"></input>
        <input type="reset" value="초기화"></input>
    </form>
		
</body>
</html>