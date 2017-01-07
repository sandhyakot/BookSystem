<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Book</title>
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
	
		<c:if test="${param.removeBookBtn eq 'Remove'}">
	
		    <jsp:setProperty property="*" name="book1" />	
		        ${sessionScope.book1.removeBook()}
		
		</c:if>
		
	
		<c:set var="list" value="${sessionScope.book1.showBooks()}"
			scope="page" />

		<c:if test="${not empty list}">

			<h2>Search Result :</h2>
			<table border="1" align="center">
				<tr>
					<th>Book ID</th>
					<th>Name</th>
					<th>Author</th>
					<th>Category</th>
					<th>Price</th>
					<th>View Reviews</th>
				</tr>

				<c:forEach var="book" items="${list}">

					<tr align="center">

						<form align="center" action="ViewBook.jsp" method="post" onsubmit=" return getConfirmation();">

							<td><input type="text" name="bookId" value="${book.bookId}"
								readonly /></td>
							<td><input type="text" name="bookName"
								value="${book.bookName}" readonly /></td>
							<td><input type="text" name="author" value="${book.author}"
								readonly /></td>
							<td><input type="text" name="category"
								value="${book.category}" readonly /></td>
							<td><input type="text" name="price" value="${book.price}"
								readonly /></td>
							<td align="center"><input type="submit" value="Remove"
								name="removeBookBtn" /></td>

						</form>

					</tr>

				</c:forEach>
			</table>


		</c:if>

		<c:if test="${empty list}">
			<h2 style="color: red" align="center">${param.bookName } book is not available</h2>
		</c:if>
	
	

</body>
</html>