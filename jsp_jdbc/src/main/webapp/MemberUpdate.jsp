<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.java.daotoex.MemberDTO"%>
<%@page import="com.java.daotoex.MemberDAO"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String pw = request.getParameter("password");
    String phone1 = request.getParameter("tel1");
    String phone2 = request.getParameter("tel2");
    String phone3 = request.getParameter("tel3");
    String gender = request.getParameter("gender");
    
    MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
    
	MemberDAO memberDAO = new MemberDAO();
	ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
	
	for(int i = 0; i < dtos.size();i++) {
		MemberDTO dto = dtos.get(i);
		
		String name = dto.getName();
		String id = dto.getId();
		String pw = dto.getPw();
		String phone = dto.getPhone1() + " - " + dto.getPhone2() + " - " + dto.getPhone3();
		String gender = dto.getGender();
		
		out.println("이름: " + name + ", 아이디: " + id + ", 비밀번호: " + pw + ", 연락처: " + phone + ", 성별: " + gender + "<br/>");
%>

  <% if (result) { 
	  	out.println
     } else { %>
        <p>회원 정보 업데이트에 실패했습니다.</p>
    <% } %>
    
</body>
</html>

</body>
</html>