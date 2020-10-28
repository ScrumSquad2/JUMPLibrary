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
						
						<c:when test="${ book.rented == FALSE }">
						<td>
							<c:out value="AVAILABLE"/>
						</td>
						</c:when>
						
						<c:otherwise>
						<td>
							<c:out value="RENTED OUT"/>
						</td>
						</c:otherwise>
						
						
						<c:when test="${ book.rented == FALSE }">
						<td>
							<a href="addCheckout?id=<c:out value='${ patron.patronId }' />">
								<button class="btn btn-primary">Check Out</button>
							</a>
						</td>
						</c:when>
					</tr>
				
				</c:forEach>
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>
