<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Patron</title>
</head>

<body>

	<div class="container">

		<%-- if doing an update, a product object will be passed to this jsp --%>
		<%-- if doing an insert, nothing will be passed to this jsp --%>

		<br>
		<c:choose>
			<c:when test="${ account != null }">
				<h1 class="display-3">Update Account</h1>
			</c:when>

			<c:otherwise>
				<h1 class="display-3">New Account</h1>
			</c:otherwise>

		</c:choose>
		<br>

		<form method="POST" action="${ account != null ? 'update' : 'insert' }">
			<c:if test="${ account != null }">
				<input type="hidden" name="id"
					value="<c:out value='${ account.id }'/>">
			</c:if>
			<div class="form-group">
				<label for="firstName">FirstName</label> <input type="text" id="firstName"
					name="firstName" class="form-control" required/>
			</div>
						<div class="form-group">
				<label for="lastName">LastName</label> <input type="text" id="lastName"
					name="lastName" class="form-control" required/>
			</div>
						<div class="form-group">
				<label for="userName">UserName</label> <input type="text" id="userName"
					name="userName" class="form-control" required/>
			</div>
						<div class="form-group">
				<label for="password">Password</label> <input type="password" id="password"
					name="password" class="form-control" required/>
			</div>

			<input class="btn btn-primary" type="submit" value="submit">
		</form>


	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>