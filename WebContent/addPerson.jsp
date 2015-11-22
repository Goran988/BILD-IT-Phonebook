<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<title>add</title>

</head>
<body>
	<div class="pozadina">
		<h3 id="addPerson">Enter data for the person you want to add</h3>
		<br>
		<form method="post" action="AddPerson" id="formregister">
			<div class="forms">
				<label>First name</label> <input name="firstName" size="20">
				<br> <label>Last name</label> <input name="lastName"> <br>
				<label>Phone number</label> <input name="phoneNumber" size="20"
					placeholder="Numbers only, no special characters"> <br>
				<label>Address</label> <input name="address"> <br> <label>Email</label>
				<input name="email" placeholder="random@email"> <br> <label>Date
					of birth</label> <input type="date" name="dateOfBirth"> <br>

			</div>
			<div class="gender">
				<label>Gender</label><br> <br> <label>Male</label> <input
					class="radio" type="radio" name="gender" value="male" checked>
				<label>Female</label> <input class="radio" type="radio"
					name="gender" value="female"> <br>
				<button type="submit" class="btn btn-primary" name="submit">Add</button>
			</div>
		</form>
	</div>

</body>
</html>
