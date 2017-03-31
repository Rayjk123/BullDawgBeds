<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign Up</title>
	</head>
	<body>
		<h1>Bulldawg Bed Register Form</h1>
		<p>A user must be a UGA student to create an accoount. Please use your uga email when you sign up.</p>
		
		<form action="Servlet" method="post">
			Name: <input type="text" name="name"/> <br/> 
			Email: <input type="text" name="email"/> <br/> 
			Password: <input type="password" name="password"/> <br/> 
			<input type ="submit" name = "register" value ="Register">
		</form>
	</body>
</html>