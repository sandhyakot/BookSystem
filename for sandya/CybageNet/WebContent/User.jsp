<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="css/style.css">
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
		<form  action="User.jsp" method="post">

			<div>
				<input type="text" placeholder="Enter Book Name" required=""
					name="bookName" /> 
					<input type="submit" value="Search"
					name="SearchBook" />
			</div>

		</form>
		</section>
	</div>
	<c:if test="${param.SearchBook eq 'Search'}">



		<jsp:setProperty property="*" name="book" />

		<c:set var="list" value="${sessionScope.book.bookDetails}"
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

						<form align="center" action="Review.jsp" method="post">

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
							<td align="center"><input type="submit" value="ViewReviews"
								name="ViewReviews" /></td>

						</form>

					</tr>

				</c:forEach>
			</table>


		</c:if>

		<c:if test="${empty list}">
			<h2 style="color: red" align="center">${param.bookName }Bookis
				Not Available</h2>
		</c:if>
	</c:if>



</body>
</html>