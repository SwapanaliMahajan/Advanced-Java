<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty name="lb" property="*" />
	${lb.authenticate()}
	<c:choose>
		<c:when test="${lb.status}">
			<%--<jsp:forward page="subjects.jsp"/>--%>
			<c:redirect url="subjects.jsp"/>
		</c:when>
		<c:otherwise>
			Invalid email or password. <br/>
			<a href="index.jsp">Login Again</a>
		</c:otherwise>
	</c:choose>	
</body>
</html>

