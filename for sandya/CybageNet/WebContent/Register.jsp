<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Register Form</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>
<h2 style="color: red" align="center">${requestScope.registerMsg}</h2> <!-- Status of registration -->

	<div class="container">
		<section id="content">
		<form action="Register" method="post">
			<h1>Register Form</h1>
			<div>
				<input type="text" placeholder="Employee Id" required=""
					name="empid" />
			</div>
			<div>
				<input type="password" placeholder="Password" required=""
					name="password" />
			</div>
			<div>
				<input type="text" placeholder="Name" required="" name="name" />
			</div>
			<div>
				<input type="text" placeholder="Department" required=""
					name="department" />
			</div>
			<div>
				<input type="submit" value="Register" />
			</div>
		</form>
		<!-- form --> </section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
</html>