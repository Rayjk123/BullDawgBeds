<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign in</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
		<script src ="scripts/mycode.js"></script>
	</head>
	<body>
	<h1>Bulldawg Beds Sign in</h1>
	
	<#if registerSuccessful??>
	<p>Thanks for registering ${name}!</p>
	</#if>
	
	<#if failedLogin??>
	<p>Erorr! Please make sure to input the correct login information.</p>
	</#if>

	<p></p>
		<form action="Servlet" method="post">
			Email: <input type="text" name="email"/> <br/> 
			Password: <input type="password" name="password"/> <br/> 
	
			<input type ="submit" name = "login" value ="Login">
		</form>
	</body>
</html>