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
    
         
        response.sendRedirect("welcome.jsp?id=" + id); // �α��� ���� �� �̵��� �������� �����̷�Ʈ �� ���� 
        //url�� �Ѿ�� ������ �Ķ���� ���� �Ѱ���� �ϴ� ����
    } else {
        out.println("�α��ο� �����߽��ϴ�. ����� �̸��� ��й�ȣ�� Ȯ�����ּ���.");
        response.sendRedirect("login.jsp");
    }
%>

</body>
</html>