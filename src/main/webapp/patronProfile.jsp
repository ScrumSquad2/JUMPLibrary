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
						<td>
							<c:out value="${ patron.accountFrozen }"/>
						</td>
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