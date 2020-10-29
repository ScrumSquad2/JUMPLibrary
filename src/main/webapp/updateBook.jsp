<%@ include file= "librarianHeader.jsp" %>

	<div class="container">
		
		<br>

				<h1 class="display-3">Update Books</h1>

		<br>

				<form action="updateBook" method="post">

				<input type="hidden" name="isbn" value="<c:out value='${ book.isbn }'/>">
				<input type="hidden" name="addedToLibrary" value="<c:out value='${ book.addedToLibrary }'/>">
				<input type="hidden" name="rented" value="<c:out value='${ book.rented }'/>">
				
			<div class="form-group">
				<label for="title">title</label>
				<input type="text" name="title" id="title" class="form-control" required 
					value="<c:out value='${ book.title }'/>">
			</div>
			
			<div class="form-group">
				<label for="desc">Description</label>
				<input type="text" name="desc" id="desc" class="form-control" required
				value="<c:out value='${ book.desc }'/>">
			</div>
			
			
			<input type="submit" value="Save" class="btn btn-primary">
		
		</form>
	
	</div>


<%@ include file= "footer.jsp" %>
