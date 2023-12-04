<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
	<jsp:useBean id="bb" class="com.sunbeam.beans.BooksBean"/>
	<jsp:setProperty name="bb" property="subject" param="subject" />
	${bb.fetchBooks()}
	
	<form method="post" action="addcart.jsp">
		<c:forEach var="b" items="${bb.bookList}">
			<input type="checkbox" name="book" value="${b.id}"/> ${b.name} <br/>
		</c:forEach>
		<input type="submit" value="Add Cart"/>
	</form>	
</body>
</html>
