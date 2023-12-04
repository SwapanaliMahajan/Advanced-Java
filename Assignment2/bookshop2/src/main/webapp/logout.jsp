<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<h1>Thank you for Visiting our Book Shop </h1>
<%session.invalidate();%> 
<a href="fc=?page=index">Login again !!!!</a>
</body>
</html>