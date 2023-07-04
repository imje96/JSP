<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<body>

	이름 : <

	<jsp:useBean id="memberBean" class="com.example.MemberBean" scope="request" />
	
	<jsp:setProperty name="memberBean" property="name" value="John Doe" />
	<jsp:setProperty name="memberBean" property="id" value="johndoe" />
	<jsp:setProperty name="memberBean" property="phone" value="123-456-7890" />



 	이름 :   <h1>Welcome, ${memberBean.name}!</h1>
    아이디 :<p>ID: ${memberBean.id}</p>
    폰 : <p>Phone: ${memberBean.phone}</p>
</body>
</html>
