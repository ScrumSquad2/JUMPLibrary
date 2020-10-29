<%@ include file= "librarianHeader.jsp" %>

	<div class="container">
	
		<br>
		<h1 class="display-3">Book List</h1>
		<br>
		
		<table class="table table-striped">
		
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Title</th>
					<th>Description</th>
					<th>Status</th>
					<th>Added Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
			
				<c:forEach var="book" items="${allBooks}">
				
					<tr>
						<td>
							<c:out value="${ book.isbn }"/>
						</td>
						<td>
							<c:out value="${ book.title }"/>
						</td>
						<td>
							<c:out value="${ book.desc }"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${ book.rented == true }">Rented</c:when>
								<c:otherwise>Available</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:out value="${ product.addedToLibrary }"/>
						</td>
						<td>
							<a href="edit?id=<c:out value='${ product.isbn }' />">
								<button class="btn btn-primary">Edit</button>
							</a>
						</td>
					</tr>
				
				</c:forEach>
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>
