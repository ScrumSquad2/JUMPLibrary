<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patron Portal</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	
		<a class="navbar-brand" href="<%= request.getContextPath() %>/patron/logoutPatron">Logout</a>

			<div class="navbar-nav">
					
				<a class="nav-item nav-link" href="<%= request.getContextPath() %>/patron/listAllBooks">Book Catalogue</a>
				
				<a class="nav-item nav-link" href="<%= request.getContextPath() %>/patron/listCurrent">Current Books</a>
				
				<a class="nav-item nav-link" href="<%= request.getContextPath() %>/patron/listReturned">History</a>
					
				<a class="nav-item nav-link" href="<%= request.getContextPath() %>/patron/displayProfile">Profile</a>
				
			</div>

	</nav>
