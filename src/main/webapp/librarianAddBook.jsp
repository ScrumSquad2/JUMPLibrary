<%@ include file= "librarianHeader.jsp" %>

	<div class="container">
	
		<br>
		<h1 class="display-3">Add Book</h1>
		<br>
		
		<form action="librarian/addBook" method="post" >
			<div class="form-group">
				<label for="isbn">ISBN</label> 
				<input autocapitalize="off" autocorrect="off" type="text" class="form-control" id="isbn" name="isbn" required>
			</div>
			
			<div class="form-group">
				<label for="title">Title</label> 
				<input autocapitalize="off" autocorrect="off" type="text" class="form-control" id="title" name="title" required>
			</div>
			
			<div class="form-group">
				<label for="desc">Description</label> 
				<input autocapitalize="off" autocorrect="off" type="text" class="form-control" id="desc" name="desc" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<br><br>
			
		</form>

	</div>

<%@ include file= "footer.jsp" %>