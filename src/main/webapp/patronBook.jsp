<%@ include file= "patronHeader.jsp" %>

	<div class="container">
	
		<br>
		<h1 class="display-3">Book Catalogue</h1>
		<br>
		<div style="overflow: scroll; height: 675px;">
		<table class="table table-striped">
		
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Title</th>
					<th>Description</th>
					<th>Status</th>
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
							<c:out value="RENTED"/>
						</td>
						</c:otherwise>
						</c:choose>
						
						<c:choose>
						<c:when test="${ book.rented == false && patron.accountFrozen == false }">
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
		
	</div>

<%@ include file= "footer.jsp" %>
