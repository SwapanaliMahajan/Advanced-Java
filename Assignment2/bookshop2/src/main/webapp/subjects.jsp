<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects</title>
</head>
<body>
	<jsp:useBean id="sb" class="com.sunbeam.beans.SubjectBean"/>
	${sb.fetchSubjects()}
	<form method="post" action="books.jsp">
		<c:forEach var="subj" items="${sb.subjectList}">
			<input type="radio" name="subject" value="${subj}"/> ${subj} <br/>
		</c:forEach>
		<input type="submit" value="Show Books"/>
	    <a href="showcart.jsp">Show Cart</a>
	</form>
</body>
</html>

