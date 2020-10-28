<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patron Portal</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	
		<a class="navbar-brand" href="<%= request.getContextPath() %>/patron/logoutPatron">Logout</a>

			<div class="navbar-nav">
					
				<a class="nav-item nav-link" href="<%= request.getContextPath() %>/listAllBooks">Book</a>
					
				<a class="nav-item nav-link" href="<%= request.getContextPath() %>/patronProfile.jsp">Profile</a>
				
			</div>

	</nav>
