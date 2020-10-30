<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Patron Sign Up Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- 
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<style>
body {
	color: #fff;
	background: #3598dc;
	font-family: 'Roboto', sans-serif;
}

.form-control {
	height: 41px;
	background: #f2f2f2;
	box-shadow: none !important;
	border: none;
}

.form-control:focus {
	background: #e2e2e2;
}

.form-control, .btn {
	border-radius: 3px;
}

.signup-form {
	width: 390px;
	margin: 10% auto;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form h2 {
	color: #333;
	font-weight: bold;
	margin-top: 0;
}

.signup-form hr {
	margin: 0 -30px 20px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .row div:first-child {
	padding-right: 10px;
}

.signup-form .row div:last-child {
	padding-left: 10px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: #3598dc;
	border: none;
	min-width: 140px;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: #2389cd !important;
	outline: none;
}

.signup-form a {
	color: #fff;
	text-decoration: underline;
}

.signup-form a:hover {
	text-decoration: none;
}

.signup-form form a {
	color: #3598dc;
	text-decoration: none;
}

.signup-form form a:hover {
	text-decoration: underline;
}

.signup-form .hint-text {
	padding-bottom: 15px;
	text-align: center;
}
</style>
</head>
<body>

	<div class="container">
		<c:if test="${message != null }">
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<c:out value="${ message }" />
			</div>
		</c:if>
		<div class="signup-form">
			<form action="<%= request.getContextPath() %>/patron/addPatron" method="post" onsubmit="validate()">
				<h2>Sign Up as Patron</h2>
				<p>Please fill in this form to create an account!</p>
				<hr>
				<div class="form-group">
					<div class="row">
						<div class="col-xs-6">
							<input type="text" class="form-control" name="firstName"
								placeholder="First Name" required="required">
						</div>
						<div class="col-xs-6">
							<input type="text" class="form-control" name="lastName"
								placeholder="Last Name" required="required">
						</div>
					</div>
				</div>
				<div class="form-group">
					<input class="form-control" name="userName" placeholder="username"
						required="required">
				</div>
				<div class="form-group">
					<input id="password" type="password" class="form-control"
						name="password" placeholder="Password" required="required">
				</div>
				<div class="form-group">
					<input id="confirm_password" type="password" class="form-control"
						name="confirm_password" placeholder="Confirm Password"
						required="required">
					<p style="color: red" id="validate-status"></p>
				</div>
				<%-- <div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
		</div> --%>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg">Sign
						Up</button>
				</div>
			</form>
			<div class="hint-text">
				Already have an account? <a href="<%=request.getContextPath()%>">Login
					here</a>
			</div>
		</div>
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
		
		$(document).ready(function() {
			$("#confirm_password").keyup(validate);
		});

		function validate() {
			const password1 = $("#password").val();
			const password2 = $("#confirm_password").val();

			if (password1.localeCompare(password2)) {
				$("#validate-status").text("please match the password");
				event.preventDefault();
			} else {
				$("#validate-status").text("");
			}
		}
	</script>
</body>
</html>