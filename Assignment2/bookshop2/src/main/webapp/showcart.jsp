<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Author</th>
				<th>Subject</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cart" items="${cb.cart}">
				<tr>
					<td><c:out value="${cart.id}"/></td> 
					<td><c:out value="${cart.name}"/></td>
					<td><c:out value="${cart.author}"/></td>
					<td><c:out value="${cart.subject}"/></td>
					<td><c:out value="${cart.price}"/></td>
				</tr>

			</c:forEach>
		</tbody>
	
	</table>

<a href="logout.jsp">Log out</a>
</body>
</html>