<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
	<div class="searchPerson">
		<h1>Enter your search:</h1>
		<form method="get" action="SearchUser">
			<label>First name</label> <input name="firstName"> <br>
			<br> <label>Last name</label> <input name="lastName"> <br>
			<br>
			<button type="submit" name="submit">search</button>
			<br>
		</form>
	</div>
</body>
</html>