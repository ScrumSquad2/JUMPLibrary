<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

	<div class="container">

		<br>

				<h1 class="display-3">Add Profile</h1>

		<br>

				<form action="patron/addPatron" method="post">
			
			<div class="form-group">
				<label for="firstName">First Name</label>
				<input type="text" name="firstName" id="firstName" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="lastName">Last Name</label>
				<input type="text" name="lastName" id="lastName" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="userName">User Name</label>
				<input type="text" name="userName" id="userName" class="form-control" required>
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" class="form-control" required/>
			</div>
			
			
			<input type="submit" value="Save" class="btn btn-primary">
		
		</form>
	
	</div>


<%@ include file= "footer.jsp" %>