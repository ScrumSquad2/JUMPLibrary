<%@ include file= "patronHeader.jsp" %>

	<div class="container">
	
		<br>
		<h1 class="display-3">Book Return</h1>
		<br>
		
		<table class="table table-striped">
		
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Checked out Date</th>
					<th>Due Date</th>
					<th>Return Date</th>
				</tr>
			</thead>
			
			<tbody>
				
					<tr>
						<td>
							<c:out value="${ checkout.isbn }"/>
						</td>
						<td>
							<c:out value="${ checkout.checkoutDate }"/>
						</td>
						<td>
							<c:out value="${ checkout.dueDate }"/>
						</td>
						<td>
							<c:out value="${ checkout.returnedDate }"/>
						</td>
												
						<c:when test="${ checkout.returnedDate != null }">
						<td>
							<a href="addCheckout?id=<c:out value='${ checkout.checkoutID }' />">
								<button class="btn btn-primary">Return</button>
							</a>
						</td>
						</c:when>
					</tr>
	
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>