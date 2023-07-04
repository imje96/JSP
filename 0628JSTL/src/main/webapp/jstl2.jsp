<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	파라미터 전송 :

	<!-- set/out 사용 예 -->
	<c:set var="VarName" value="홍길동"/>
	VarName : <c:out value="${VarName }" />
	<br/>
	
	<!--  remove 사용 예 -->
	<c:remove var="VarName"/>
	VarName 제거 후: <c:out value="${VarName}" />
	<hr/>

	<!--  catch 사용 예 -->
   <c:catch var="error">
      <%=2/0 %>
   </c:catch>
   <c:out value="${error }"/>
   <br/>
   <hr>

	<!-- if 사용 예 -->
	<c:if test="${1+2 == 3 }">
		1 + 2 = 3
	</c:if><br/>
	<c:if test="${1+2 != 3 }">
		1 + 2 != 3
	</c:if><br/>
	<hr/>
	
	<!-- choose 사용 예 -->
   <c:set var="varName" value="홍길순"/>
   <c:choose>
      <c:when test="${varName == '홍길동' }"> when: 홍길동</c:when>
      <c:otherwise>when: 다른사람</c:otherwise>
   </c:choose>
   <br/><hr>   
   
   	<!-- forEach 사용 예 -->
   <c:forEach var="fEach" begin="0" end="30" step="3">
      ${fEach }
   </c:forEach>
   <br/><hr>
   
   <%List<String> fruits = new ArrayList<String>();
   
      fruits.add("사과");
      fruits.add("배");
      fruits.add("바나나");
      fruits.add("감");
      fruits.add("귤");
      
      pageContext.setAttribute("aFruits", fruits);
   %>
   <ul>
   <c:forEach var="result" items="${aFruits }">
      <li>${result }</li>
   </c:forEach>
   </ul>
   <br/><hr>
   
   <%
      pageContext.setAttribute("aEach", "홍길동, 홍순이, 홍길이");
   %>
   <ul>
   <c:forEach var="result" items="${aEach }">
      <li>${result }</li>
   </c:forEach>
   </ul>
	

	<c:redirect url="exl.jsp">
		<c:param name="name" value="홍길동" />
	</c:redirect>
	<hr/>

</body>
</html>