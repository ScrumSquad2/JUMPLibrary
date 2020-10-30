<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JUMP Online Library</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<c:if test="${message != null }">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<c:out value="${ message }" />
			</div>
		</c:if>
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-8">Welcome to JUMP Online Library</h1>
			</div>
		</div>
		<br>
		<c:choose>
			<c:when test="${ librarian != true }">
				<h1 class="display-3">Patron Sign In</h1>
			</c:when>

			<c:otherwise>
				<h1 class="display-3">Librarian Sign In</h1>
			</c:otherwise>
		</c:choose>

		<br>
		<c:choose>
			<c:when test="${ librarian == true }">
				<form
					action="<%=request.getContextPath()%>/librarian/loginLibrarian"
					method="POST">
			</c:when>
			<c:otherwise>
				<form action="<%=request.getContextPath()%>/patron/loginPatron"
					method="POST">
			</c:otherwise>
		</c:choose>
		<div class="form-group">
			<label for="userName">User Name</label> <input autocapitalize="off"
				autocorrect="off" type="text" class="form-control" id="userName"
				name="userName" required>
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="password" name="password" required>
		</div>

		<button type="submit" class="btn btn-primary">Log In</button>
		<c:if test="${ librarian != true }">
			<button onclick="window.location.href='patronSignup.jsp' ;"
				type="button" class="btn btn-secondary">Sign Up</button>
		</c:if>
		<br> <br>

		<div style="padding: 1em 1em">
			<c:choose>
				<c:when test="${ librarian != true }">
						Not a Patron? <a href="<%=request.getContextPath()%>/patronSignin">Sign
						In</a> as Librarian	
			</c:when>
				<c:otherwise>
						Not a Librarian? <a
						href="<%=request.getContextPath()%>/librarianSignin">Sign In</a> as Patron
			</c:otherwise>
			</c:choose>
		</div>
		</form>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		const isAlert = document.getElementsByClassName('alert');
		if (isAlert.length > 0) {
			$(".alert").fadeTo(2000, 500).slideUp(200, function() {
				$(this).alert('close');
			});
		}
	</script>
</body>
</html>
