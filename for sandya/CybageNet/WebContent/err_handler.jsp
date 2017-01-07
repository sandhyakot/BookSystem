<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h1 style="color: black;">Exception details via JSP Page</h1>
		
		<h2 style="color: black;">Exception message : </h2>
		<h2 style="color: red;">${pageContext.exception.message}</h2>
		
		

		
		<h2 style="color: black;"><a href="${pageContext.errorData.requestURI}">Go Back</a></h2>
	
</body>
</html>