<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
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
	<c:if test="${param.AddReview eq 'AddReview'}">

			<jsp:useBean id="bookReview" class="beans.BookReviewBean"
				scope="session" />
			<jsp:setProperty name="bookReview" property="bookId"
				value="${book1.bookId}" />
			<jsp:setProperty name="bookReview" property="empId"
				value="${sessionScope.emp.empId}" />
			<jsp:setProperty name="bookReview" property="review"
				value="${param.review}" />

		${sessionScope.bookReview.addBookReviews()}
		</c:if>

	<jsp:useBean id="book1" class="beans.BookBean" scope="session" />
	<jsp:setProperty property="*" name="book1" />

	<table border="1" align="center">
		<tr>
			<th>Book ID</th>
			<th>Name</th>
			<th>Author</th>
			<th>Category</th>
			<th>Price</th>

		</tr>



		<tr align="center">

			<form align="center" action="Review.jsp" method="post">

				<td><input type="text" name="bookId" value="${book1.bookId}"
					readonly /></td>
				<td><input type="text" name="bookName"
					value="${book1.bookName}" readonly /></td>
				<td><input type="text" name="author" value="${book1.author}"
					readonly /></td>
				<td><input type="text" name="category"
					value="${book1.category}" readonly /></td>
				<td><input type="text" name="price" value="${book1.price}"
					readonly /></td>

			</form>
		</tr>
	</table>

	<c:set var="list1" value="${sessionScope.book1.bookReviews}"
		scope="page" />

	<c:if test="${ not empty list1}">
		<u>
			<h2 align="center">Review of ${param.bookName }Book :</h2>
		</u>
		<table border="1" align="center" width="800">
			<c:forEach var="review" items="${list1}">

				<tr>
					<td align="justify"><h3>${ review }</h3></td>

				</tr>

			</c:forEach>
		</table>
	</c:if>


	<c:if test="${empty list1}">
		<h2 style="color: red" align="center">Review of ${param.bookName }Book
			is Not Available</h2>
	</c:if>
	<div class="container">
		<section id="content">
		<form action="Review.jsp" method="post">


			<input type="text" placeholder="Enter Review" required=""
				name="review" /> <input type="submit" value="AddReview"
				name="AddReview" />

		</form>
		
</body>
</html>