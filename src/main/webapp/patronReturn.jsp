<%@ include file="patronHeader.jsp"%>

<div class="container">


	<br>
	<c:choose>
		<c:when test="${ isHistory != true }">
	<h1 class="display-3">Current Books</h1>
		</c:when>
		<c:otherwise>
	<h1 class="display-3">History</h1>
		</c:otherwise>

	</c:choose>
	<br>
	<div style="overflow: scroll; height: 675px;">
	<table class="table table-striped">

		<thead>
			<tr>
				<th>ISBN</th>
				<th>Checked out Date</th>
				<th>Due Date</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="checkout" items="${bookCheckouts}">
				<tr>
					<td><c:out value="${ checkout.isbn }" /></td>
					<td><c:out value="${ checkout.checkoutDate }" /></td>
					<td><c:out value="${ checkout.dueDate }" /></td>
					<td><c:out value="${ checkout.returnedDate }" /></td>
					<c:if test="${ isHistory != true }">
					<td><a
						href="returnCheckout?id=<c:out value='${ checkout.id }' />">
							<button class="btn btn-primary">Return</button>
					</a></td>
					</c:if>
					<%-- 						<c:when test="${ checkout.returnedDate != null }">
						<td>
							<a href="addCheckout?id=<c:out value='${ checkout.checkoutID }' />">
								<button class="btn btn-primary">Return</button>
							</a>
						</td>
						</c:when> --%>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	</div>

</div>

<%@ include file="footer.jsp"%>
