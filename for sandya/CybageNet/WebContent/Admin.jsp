<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="css/style.css">
</head>
<jsp:useBean id="book1" class="beans.BookBean" scope="session" />
<body>
<header>
	<h1>Welcome to CybageNet</h1>
	<h5>Book Management System</h5>
	<br>
	<h2>Welcome ${sessionScope.emp.empName}</h2>
	<h2 align="right"><a href="logout.jsp" >Logout</a></h2>
					
	</header>
	
	<c:if test="${sessionScope.emp eq null }">
	
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container">
	
	
	
		<section id="content">
		<form action="ViewBook.jsp"  method="post">
			<input type="submit" formaction="InsertBook.jsp" value="Insert Book" name="btn" />
		    <input	type="submit" value="ViewBook" name="viewBook">
		    <input	type="submit" value="OnlineUsers" name="onlineUsers" formaction="Admin.jsp">
		</form>
		<!-- form -->
		</section>
		<!-- content -->
	</div>
	
	<c:if test="${param.onlineUsers eq 'OnlineUsers'}">
 <h1 align="center"> Online Users : ${sessionScope.counter.activeSessionNumber}</h1>
	</c:if>
</body>
</html>