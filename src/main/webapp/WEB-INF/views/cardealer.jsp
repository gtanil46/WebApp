<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container col-md-4">
	<form method="post" action="/login">
		<fieldset class="form-group">
			<label>User Name</label> <input name="username" type="text"
				class="form-control" required /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password"
				class="form-control" required /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Type</label> <select class="form-control" name="type">
				<option value="admin">Admin</option>
				<option value="customer">Customer</option>
			</select> <BR />
		</fieldset>
		<input name="login" type="submit" value="Login"
			class="btn btn-success" /> <BR /> <Br /> <input
			formaction="/register" name="register" type="submit"
			value="New user? Register" class="btn btn-danger" /> <BR />
	</form>
	<BR />
	<p style="color: red;">${alert}</p>
</div>

<%@ include file="../common/footer.jspf"%>