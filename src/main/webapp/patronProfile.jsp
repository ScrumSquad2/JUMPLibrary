<%@ include file= "patronHeader.jsp" %>

	<div class="container">
		
		<table class="table table-striped">
		
		<br>
		
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Status</th>
				</tr>
			</thead>
			
			<tbody>
				
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
	
						<c:choose>
						<c:when test="${ patron.accountFrozen == false }">
						<td>
							<c:out value="Approved"/>
						</td>
						</c:when>
						<c:otherwise>
						<td>
							<c:out value="Pending approval"/>
						</td>
						</c:otherwise>
						</c:choose>
						
						<td>
							<a href="<%=request.getContextPath()%>/patron/editPatron?id=<c:out value='${ patron.patronId }' />">
								<button class="btn btn-primary">Update</button>
							</a>
						</td>
					</tr>
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>
