<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

		session.setAttribute("MySessionName", id); // id ������ ���ǿ� ����
		session.setAttribute("password", password); // password ������ ���ǿ� ����


	<%
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		session.setAttribute("id", id); // id ������ ���ǿ� ����
		session.setAttribute("password", password); // password ������ ���ǿ� ����
		session.setMaxInactiveInterval(60 * 20); // ���� ��ȿ �ð� ���� (���Ƿ� ������ ���� ex)20��)
        // �������� �ʾ��� ���� web.xml�� default 30������ ���� �Ǿ� ���� 

	%>
	<% 
		String sessionId = session.getId(); // ���� ID ��������
		String sessionUser = (String) session.getAttribute("id"); // ���ǿ��� ����� id ���� ��������
		String sessionPassword = (String) session.getAttribute("password"); // ���ǿ��� ����� password ���� ��������
	
		if (sessionUser != null && sessionUser.equals("je") && sessionPassword.equals("1234")) {
			out.println(sessionUser + "�� �α����� ȯ���մϴ�.");
		} else if (sessionUser != null && sessionUser.equals("oracle") && sessionPassword.equals("1234")) {
			out.println(sessionUser + "�� �α����� ȯ���մϴ�.");
		} else {
	        out.println("�α��ο� �����߽��ϴ�. ����� �̸��� ��й�ȣ�� Ȯ�����ּ���.");
	        response.sendRedirect("session_login.html");
		}
	%>
	
	<br />
	<a href=sessionget.jsp>���� ���� Ȯ���ϱ�</a>
	
</body>
</html>