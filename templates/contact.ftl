<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Contact Us</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<h1>Contact Us Form</h1>
		
		<form action="Servlet" method="post">
			Name: <input type="text" name="name"/> <br/> 
			Email: <input type="text" name="email"/> <br/> 
			Message: <br/><textarea name="message" rows="14" cols="50"></textarea><br/>
			<input type ="submit" name = "contactButton" value ="Submit">
		</form>
	</body>
</html>