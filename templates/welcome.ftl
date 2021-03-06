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
				<h1>Bulldawg Beds</h1>
				
				<div id ="headerButtons">
					<form action="Servlet" method="post">
					<table>
						<tr>
							<td><input type="submit" name ="leaseMyApartment" value="Lease your apartment"/></td>
							<td><input type="submit" name ="checkMessages" value="Inbox"/></td>
							<td>Welcome ${loginName}!</td>
						</tr>
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
	                    <li>Location
							<select name="location">
					  			<option value="north">North</option>
					 			<option value="south">South</option>
					 			<option value="east">East</option>
					  			<option value="west">West</option>
							</select>
	                    </li>
	                     <li>Beds
							<select name="bedNumber">
					  			<option value="one">1</option>
					 			<option value="two">2</option>
					 			<option value="three">3</option>
					  			<option value="four">4</option>
							</select>
	                    </li>
	                     <li>Date
							<select name="date">
					  			<option value="fall">Fall</option>
					 			<option value="spring">Spring</option>
					 			<option value="summer">Summer</option>
							</select>
	                    </li>
	                    <li>Price
							<select name="price">
					  			<option value="range1">$200-399</option>
					 			<option value="range2">$400-699</option>
					 			<option value="range3">$700-899</option>
					 			<option value="range4">$900+</option>
							</select>
	                    </li>
	                    <li>
	                    	<input type="submit" name ="search" value="Search"/>
	                   	</li>
	                </ul>
				</form>
			</div>
			
			<div id="slideshow">
				<p><img src ="images/img1.png" alt="apartment" title="apartment"></p>
			</div>
			
			<div id="footer">
				<form action="Servlet" method="post">
				<table>
					<tr>
						<td><input type="submit" name ="contact" value="Contact Us"/></td>
						<!--<td><a href="https://validator.w3.org"><img src="http://cobweb.cs.uga.edu/~mehdi/teaching/4300/images/w3c-html.png" alt="w3c validator"></a></td>
						<td><a href="https://jigsaw.w3.org/css-validator/"><img src="http://cobweb.cs.uga.edu/~mehdi/teaching/4300/images/w3c-css.png" alt="w3c css validator"></a></td> -->
						<td><input type="submit" name ="about" value="About Us"/></td>
       				</tr>
				</table>
				</form>
			</div>
		</div>
	</body>
</html>