<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<title>Login</title>
</head>
<body>
	<h3>Enter your username and password please:</h3>
	<form method="get" action="LoginServlet">
		<label>username<input name="username"></label> <br>
		<label>password<input type="password" name="password"></label> <br>
		<button type="submit" name="submit" value="login">Log in</button>
		<button type="submit" name="submit" value="register">Register</button>
	<h3>To login as guest:	</h3>
		<button type="submit" name="submit" value="guest">Guest</button>
	</form>


</body>
</html>