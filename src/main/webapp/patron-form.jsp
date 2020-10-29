<%@ include file= "patronHeader.jsp" %>
	<script type="text/javascript">

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
	
	<div class="container">
		
		<br>

				<h1 class="display-3">Update Profile</h1>

		<br>

				<form action="updatePatron" method="post" onsubmit="validate()">

				<input type="hidden" name="patronId" value="<c:out value='${ patron.patronId }'/>">
			
			<h2>General Information</h2>
			<div class="form-group">
				<label for="firstName">First Name</label>
				<input type="text" name="firstName" id="firstName" class="form-control" required
					value="<c:out value='${ patron.firstName }'/>">
			</div>
			
			<div class="form-group">
				<label for="lastName">Last Name</label>
				<input type="text" name="lastName" id="lastName" class="form-control" required 
					value="<c:out value='${ patron.lastName }'/>">
			</div>
			
			<div class="form-group">
				<label for="userName">User Name</label>
				<input type="text" name="userName" id="userName" class="form-control" required 
					value="<c:out value='${ patron.userName }'/>">
			</div>
		
			<br> <br>
			<h2>Change New Password</h2>
			<div class="form-group">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" class="form-control" required/>
			</div>
			<div class="form-group">
				<label for="new-password">New Password</label>
				<input type="password" name="new-password" id="new-password" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="confirm-password">Confirm New Password</label>
				<input type="password" name="confirm-password" id="confirm-password" class="form-control"/>
				<p style="color: red" id="validate-status"></p>		
			</div>
			
			
			<input type="submit" value="Save" class="btn btn-primary">
		
		</form>
	
	</div>


<%@ include file= "footer.jsp" %>
