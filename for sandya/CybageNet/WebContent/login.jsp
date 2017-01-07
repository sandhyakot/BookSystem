<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>

<link rel="stylesheet" href="css/style.css">
</head>

<body>
<header>
   <h1 >Welcome to CybageNet</h1><h5 >Book Management System</h5><br> 
  
</header>
<h2 style="color: red" align="center">${requestScope.msg }</h2>  <!-- Status of login --> 
<h2 style="color: blue;" align="center">${requestScope.registerMsg }</h2> <!-- Status of Registration -->

	<div class="container">     
		<section id="content">
		
			<form action="Validator" method="post">
				<h1>Login Form</h1>
				<div>
					<input type="text" placeholder="EmployeeId/Username" required="" name="empid" />
				</div>
				<div>
					<input type="password" placeholder="Password" required=""
						name="password" />
				</div>
				<div>
					<input type="submit" value="Log in" /> 
					<a  href="http://localhost:8080/CybageNet/Register.jsp">Register</a>
				</div>
			</form>
			<!-- form -->

		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>


</html>