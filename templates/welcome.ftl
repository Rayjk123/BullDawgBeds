<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bulldawg Beds</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
	</head>
	
	
	
	<body>
		<div id ="wrapper">
			<div id ="header">
				<h1>Bulldawgs Beds</h1>
				
				<div id ="headerButtons">
					<form action="Servlet" method="post">
					<table>
						<tr><td>Signed in as ${email}</td></tr>
					</table>
					</form>
				</div>
			</div>
	
	
			<div id ="description">
				<p>Student housing for students by students!</p>
			</div>
			
			<div id ="menubar">
				<form action="Servlet" method="post">
					<ul>
	                    <li>
							<select name="location">
					  			<option value="north">North</option>
					 			<option value="south">South</option>
					 			<option value="east">East</option>
					  			<option value="west">West</option>
							</select>
	                    </li>
	                     <li>
							<select name="bedNumber">
					  			<option value="one">1</option>
					 			<option value="two">2</option>
					 			<option value="three">3</option>
					  			<option value="four">4</option>
							</select>
	                    </li>
	                     <li>
							<select name="date">
					  			<option value="fall">Fall</option>
					 			<option value="spring">Spring</option>
					 			<option value="summer">Summer</option>
							</select>
	                    </li>
	                    <li>
	                    	<input type="submit" name ="search" value="Submit"/>
	                   	</li>
	                </ul>
				</form>
			</div>
			
			<div id="slideshow">
			</div>
			
			<div id="footer">
				<table>
					<tr>
						<td><input type="submit" name ="support" value="Contact Us"/></td>
						<td><a href="https://validator.w3.org"><img src="http://cobweb.cs.uga.edu/~mehdi/teaching/4300/images/w3c-html.png" alt="w3c validator"></a></td>
						<td><a href="https://jigsaw.w3.org/css-validator/"><img src="http://cobweb.cs.uga.edu/~mehdi/teaching/4300/images/w3c-css.png" alt="w3c css validator"></a></td>
						<td><input type="submit" name ="about" value="About Us"/></td>
       				</tr>
				</table>
			</div>
		</div>
	</body>
</html>