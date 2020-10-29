<%@ include file= "librarianHeader.jsp" %>

	<div class="container">
	
		<br>
		<h1 class="display-3">Patron List</h1>
		<br>
		
		<table class="table table-striped">
		
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
			
				<c:forEach var="patron" items="${allPatrons}">
				
					<tr>
						<td>
							<c:out value="${ patron.patronId }"/>
						</td>
						<td>
							<c:out value="${ patron.firstName }"/>
						</td>
						<td>
							<c:out value="${ patron.lastName }"/>
						</td>
						<td>
							<c:out value="${ patron.userName }"/>
						</td>
						<td>
							<c:choose>
								<c:when test="${ patron.accountFrozen == true }">Frozen</c:when>
								<c:otherwise>Not Frozen</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="<c:out value ="${ patron.accountFrozen == true ? 'unfreezePatron': 'freezePatron'}"/>
							?patronId=<c:out value='${ patron.patronId }' />">
								<button class="btn btn-primary">
									<c:choose>
										<c:when test="${ patron.accountFrozen == true }">Unfreeze</c:when>
										<c:otherwise>Freeze</c:otherwise>
									</c:choose>
								</button>
							</a>
						</td>
					</tr>
				
				</c:forEach>
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>