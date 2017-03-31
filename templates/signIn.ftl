<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign in</title>
		<script src ="scripts/mycode.js"></script>
	</head>
	<body>
	<h1>Sign in</h1>
	
	<#if registerSuccessful??>
	<p>Thanks for registering ${name}!</p>
	</#if>
	
	<#if failedLogin??>
	<p>The email ${email} does not exist in our database. Please try again.</p>
	</#if>

	<p></p>
		<form action="Servlet" method="post">
			Email: <input type="text" name="email"/> <br/> 
			Password: <input type="password" name="password"/> <br/> 
	
			<input type ="submit" name = "login" value ="Login"">
		</form>
	</body>
</html>