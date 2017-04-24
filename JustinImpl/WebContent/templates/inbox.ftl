<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bulldawg Beds</title>
		<link href="form.css" type="text/css" rel="stylesheet" />
	</head>
	
	<body>
		<h1>Bulldawg Beds Inbox</h1>

		<div id = "form">
			<#list messageList as read>
			<ul>
				<li>${read.message}</li>
			</ul>
			</#list>
		</div>
	</body>	
</html>