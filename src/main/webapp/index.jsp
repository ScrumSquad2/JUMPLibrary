<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JUMP Online Library</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>

	<div class="container">

		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-8">Welcome to JUMP Online Library</h1>
			</div>
		</div>

<!-- 		<form action="patron" method="post" >
		
			<div class="form-group">
				<label for="email">Email Address</label> 
				<input type="email" class="form-control" id="email" name="email" required>
			</div>
			
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password" class="form-control" id="pw" name="pw" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Login as Patron</button>
			<button onclick="window.location.href='signUp.jsp' ;" type="button" class="btn btn-secondary">Sign Up</button>
			<br><br>
			
		</form> -->
		
		<form action="patron/loginPatron" method="post" >
			<div class="form-group">
				<label for="userName">User Name</label> 
				<input autocapitalize="off" autocorrect="off" type="text" class="form-control" id="userName" name="userName" required>
			</div>
			
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="password" class="form-control" id="password" name="password" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Login as Patron</button>
			<button onclick="window.location.href='signUp.jsp' ;" type="button" class="btn btn-secondary">Sign Up</button>
			<br><br>
			
		</form>
		
				<form action="servlet/test" method="post" >
		
			<div class="form-group">
				<label for="email">Email Address</label> 
				<input type="email" class="form-control" id="email" name="email" required>
			</div>
			
			<div class="form-group">
				<label for="pw">Password</label> 
				<input type="password" class="form-control" id="pw" name="pw" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Login as Librarian</button>
		</form>

	</div>

</body>
</html>
