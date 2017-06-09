<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="windows-1251">
	<title>index</title>
	<style type="text/css">
		@import url("../../style.css");
	</style>
</head>

<body>
<div class="container" align="center">
	<h1 class="well">Login Form</h1>
	<div class="col-lg-12 well">
		<div class="row">
			<br>
			<form action="./Controller" method="POST">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-sm-6 form-group">Login
							<input type="hidden" name="page" value="LIST_COURSE_TEACHER">
							<input type="text" placeholder="First name" name="login"  class="form-control">
						</div>
						<br>
						<div class="col-sm-6 form-group">
							<label>Password</label>
							<input type="password" placeholder="Password" name="password"  class="form-control">
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-lg btn-info">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
