<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lease Your Apartment</title>
		<link href="form.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<h1>Lease your apartment</h1>
		
		<div id = "form">
		<p></p>
		<form action="Servlet" method="post">
			Name of apartment: <input type="text" name="name"/> <br/> 
			Email: <input type="text" name="email"/> <br/> 
			Address: <input type="text" name="address"/> <br/> 
			Location: <select name="location">
					  			<option value="north">North</option>
					 			<option value="south">South</option>
					 			<option value="east">East</option>
					  			<option value="west">West</option>
			          </select><br/> 
			Price: <input type="text" name="price"/> <br/> 
			Beds: <select name="beds">
					  			<option value="one">1</option>
					 			<option value="two">2</option>
					 			<option value="three">3</option>
					  			<option value="four">4</option>
							</select><br/>
			Semester:  <select name="semester">
					  			<option value="fall">fall</option>
					 			<option value="spring">spring</option>
					 			<option value="summer">summer</option>
							</select><br/>

			<p></p>
			<input id = "button" type ="submit" name = "leaseIt" value ="Submit">
			<p></p>
		</form>
		
		</div>
	</body>
</html>