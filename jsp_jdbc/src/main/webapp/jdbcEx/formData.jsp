<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

    <h1>ȸ�� ���� �Է�</h1>
    <form action="insertData.jsp" method="post" >
        <label for="id">���̵�:</label>
        <input type="text" id="id" name="id" required><br />
        
        <label for="password">��й�ȣ:</label>
        <input type="password" id="password" name="password" required><br />
        
        <label for="name">�̸�:</label>
        <input type="text" id="name" name="name" required><br />
        
        <label for="tel">��ȭ��ȣ:</label>
        <input type="tel" id="tel" name="tel" required><br />
        
        
        <input type="submit" value="����"></input>
        <input type="reset" value="�ʱ�ȭ"></input>
    </form>


</body>
</html>