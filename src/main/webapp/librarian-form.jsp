<%@ include file= "librarianHeader.jsp" %>

	<div class="container">
		
		<br>

				<h1 class="display-3">Update Profile</h1>

		<br>

				<form action="updateLibrarian" method="post">

				<input type="hidden" name="librarianId" value="<c:out value='${ librarian.librarianId }'/>">
			
			<div class="form-group">
				<label for="userName">User Name</label>
				<input type="text" name="userName" id="userName" class="form-control" required 
					value="<c:out value='${ librarian.userName }'/>">
			</div>
			
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" class="form-control" required/>
			</div>
			
			
			<input type="submit" value="Save" class="btn btn-primary">
		
		</form>
	
	</div>


<%@ include file= "footer.jsp" %>
