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
							<c:out value="${ patron.id }"/>
						</td>
						<td>
							<c:out value="${ patron.firstName }"/>
						</td>
						<td>
							<c:out value="${ patron.lastName }"/>
						</td>
						<td>
							<c:out value="${ patron.userame }"/>
						</td>
						<td>
							<c:out value="${ patron.accountFrozen }"/>
						</td>
						<td>
							<a href="updatePatron?id=<c:out value='${ patron.id }' />">
								<button class="btn btn-primary">Update</button>
							</a>
						</td>
					</tr>
				
			</tbody>
		
		</table>
		
	</div>

<%@ include file= "footer.jsp" %>