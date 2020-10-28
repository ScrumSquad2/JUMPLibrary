<%@ include file= "patronHeader.jsp" %>

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
					<th>Availability</th>
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
						
						<c:choose>
						<c:when test="${ book.rented == false }">
						<td>
							<c:out value="AVAILABLE"/>
						</td>
						</c:when>
						
						<c:otherwise>
						<td>
							<c:out value="RENTED OUT"/>
						</td>
						</c:otherwise>
						</c:choose>
						
						<c:choose>
						<c:when test="${ book.rented == false }">
						<td>
							<a href="addCheckout?isbn=<c:out value='${ book.isbn }' />">
								<button class="btn btn-primary">Check Out</button>
							</a>
						</td>
						</c:when>
						</c:choose>
					</tr>
				
				</c:forEach>
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>
