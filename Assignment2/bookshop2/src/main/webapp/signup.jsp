<%@ page import="com.sunbeam.beans.RegistrationBean" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
     <jsp:useBean id="rd" class="com.sunbeam.beans.RegistrationBean"/>
     <jsp:setProperty property="*" name="rb"/>
     ${rb.registerUser()}
     User Registered: ${rb.count} <br/>n<br/>
     <a href="fc?page=index">Sign In</a>

</body>
</html>