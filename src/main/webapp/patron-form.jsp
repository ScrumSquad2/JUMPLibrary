<%@ include file="patronHeader.jsp"%>

<div class="container">
	<c:if test="${message != null }">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<c:out value="${ message }" />
		</div>
	</c:if>
	<br>

	<h1 class="display-3">Update Profile</h1>

	<br>

	<form action="updatePatron" method="post" onsubmit="validate()">

		<input type="hidden" name="patronId"
			value="<c:out value='${ patron.patronId }'/>">

		<h2>General Information</h2>
		<div class="form-group">
			<label for="firstName">First Name</label> <input type="text"
				name="firstName" id="firstName" class="form-control" required
				value="<c:out value='${ patron.firstName }'/>">
		</div>

		<div class="form-group">
			<label for="lastName">Last Name</label> <input type="text"
				name="lastName" id="lastName" class="form-control" required
				value="<c:out value='${ patron.lastName }'/>">
		</div>

		<div class="form-group">
			<label for="userName">User Name</label> <input type="text"
				name="userName" id="userName" class="form-control" required
				value="<c:out value='${ patron.userName }'/>">
		</div>

		<br> <br>
		<h2>Change New Password</h2>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				name="password" id="password" class="form-control" required />
		</div>
		<div class="form-group">
			<label for="new-password">New Password</label> <input type="password"
				name="new-password" id="new-password" class="form-control" />
		</div>
		<div class="form-group">
			<label for="confirm-password">Confirm New Password</label> <input
				type="password" name="confirm-password" id="confirm-password"
				class="form-control" />
			<p style="color: red" id="validate-status"></p>
		</div>


		<input type="submit" value="Save" class="btn btn-primary">

	</form>

</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>

<script type="text/javascript">

		const isAlert = document.getElementsByClassName('alert');
		if (isAlert.length > 0) {
			$(".alert").fadeTo(2000, 500).slideUp(200, function() {
		    	$(this).alert('close');
			});
		}
		
		$(document).ready(function() {
			$("#confirm-password").keyup(validate);
		});

		function validate() {
			const password1 = $("#new-password").val();
			const password2 = $("#confirm-password").val();

			if (password1.localeCompare(password2)) {
				$("#validate-status").text("please match the password");
				event.preventDefault();
			} else {
				$("#validate-status").text("");
			}
		}
	</script>


<%@ include file="footer.jsp"%>
