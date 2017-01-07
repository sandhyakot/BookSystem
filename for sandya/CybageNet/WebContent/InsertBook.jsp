<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Book</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function getConfirmation() {
		var retVal = confirm("Do you want to continue ?");
		if (retVal == true) {
			
			return true;
		} else {
			
			return false;
		}
	}
	
</script>
</head>
<jsp:useBean id="book" class="beans.BookBean" scope="session" />
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
		<form action="InsertBook.jsp" method="post" onsubmit=" return getConfirmation();">
	
			<div>
				<input type="text" placeholder="Enter Book Name" required="" name="bookName" />
				 <input type="text"	placeholder="Enter Book Price" required="" name="price"  /> 
				<input	type="text" placeholder="Enter Author Name" required="" name="author" />
				 <input type="text"	placeholder="Enter Book Category" required="" name="category" />
				  <input type="submit" value="Insert" name="insertBtn" />
			</div>
		</form>
		</section>
	</div>
	<c:if test="${param.insertBtn eq 'Insert'}">

		<jsp:setProperty property="*" name="book" />
           ${sessionScope.book.insertBook()}
           <c:redirect url="Admin.jsp" > </c:redirect>
			</c:if>



</body>
</html>