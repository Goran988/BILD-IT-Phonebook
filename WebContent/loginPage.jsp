<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<title>Login</title>
</head>
<body>
<p id="loged">
			Loged in as:
			<c:out value="${user.username }" />
		</p>
	<div class="searchPerson">
		<h2 class="login">Enter your username and password please:</h2>
		<form method="get" action="LoginServlet">
			<label>Username</label><br> <input name="username"> <br>
			<label>Password</label><br> <input type="password"
				name="password"> <br> <br>
			<button type="submit" class="btn btn-primary" name="submit"
				value="login">Log in</button>
			<button type="submit" class="btn btn-primary" name="submit"
				value="register">Register</button>
			<h2>To login as guest:</h2>
			<button type="submit"  class="btn btn-primary" name="submit" value="guest">Guest</button>
			
			<h3><c:out value="${sessionScope.message }"/></h3>
			
			
		</form>
	</div>


</body>
</html>