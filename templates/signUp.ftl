<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign Up</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<h1>Bulldawg Beds Registration Form</h1>
		<p>Please use your UGA email.</p>
		
		<#if notValidEmail??>
		<p>Error! Please use a valid @uga.edu email!</p>
		</#if>
		
		<#if duplicateEmail??>
		<p>Error! The email you used to register already exists in the database!</p>
		</#if>
		
		<form action="Servlet" method="post">
			Name: <input type="text" name="name"/> <br/> 
			Email: <input type="text" name="email"/> <br/> 
			Password: <input type="password" name="password"/> <br/> 
			<input type ="submit" name = "register" value ="Register">
		</form>
	</body>
</html>