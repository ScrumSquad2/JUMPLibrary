<%@ include file="librarianHeader.jsp"%>

<div class="container">

	<br>
	<h1 class="display-3">Book Catalog</h1>
	<br>

	<form method="post"
		action="<%=request.getContextPath()%>/librarian/searchBooks">
		<div class="form-row align-items-center">
			<button type="submit" class="btn col-auto">
				<i class="fa fa-search"></i>
			</button>
			<input style="border-style: solid; margin-left: 1em;" type="text"
				class="col-sm-10" name="search-books" id="search-books"
				placeholder="Enter Title or ISBN">
		</div>
	</form>
	
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
					<td><c:out value="${ book.isbn }" /></td>
					<td><c:out value="${ book.title }" /></td>
					<td><c:out value="${ book.desc }" /></td>
					<td><c:choose>
							<c:when test="${ book.rented == true }">Rented</c:when>
							<c:otherwise>Available</c:otherwise>
						</c:choose></td>
					<td><c:out value="${ book.addedToLibrary }" /></td>
					<td><a href="editBook?isbn=<c:out value='${ book.isbn }' />">
							<button class="btn btn-primary">Edit</button>
					</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

</div>

<%@ include file="footer.jsp"%>
