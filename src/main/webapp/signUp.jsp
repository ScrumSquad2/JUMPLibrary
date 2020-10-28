
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JUMP Online Library</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>
	<%-- <div class="container"> --%>
	
			<div class="jumbotron jumbotron-fluid ">
				<div class="container">
					<h1 class="text-center"  style="margin-bottom:50px ">Sign-up Page</h1>
					<p class="lead text-center">Welcome! Please choose patron or librarian for signup.</p>
				</div>
				
			</div>
	<%-- <div> --%>
	<div class="container" >
			<div class="text-center">
			<div class="btn-group-vertical" style="margin-bottom:10px; border-radius:10px ">

					
					<a class="btn btn-primary btn-lg" href="patronSignup.jsp" style="margin-bottom:50px; border-radius:10px " role="button">Patron Signup </a>

					<a class="btn btn-primary btn-lg" href="librarianSignup.jsp" style="margin-bottom:50px; border-radius:10px " role="button">Librarian Signup </a>
		
				
          	</div>
			</div>
	</div>
	
</body>
</html>