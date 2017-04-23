<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bulldawg Beds</title>
		<link href="index.css" type="text/css" rel="stylesheet" />
	</head>
	
	<body>
		<div>
			<div class ="HeaderBacking">
				<h1 class = "BullDawgBeds">Bulldawg Beds</h1>
				
				
					<form action="Servlet" method="post">
					<table>
						<tr>
							<td><input type="submit" name ="leaseMyApartment" value="Lease your apartment"/></td>
							<td><input type="submit" name ="checkMessages" value="Inbox"/></td>
							<td class = "Welcome">Welcome <br> ${loginName}!</td>
						</tr>
					</table>
					</form>
			</div>
	
	
			<div id ="wrapper">
				<p class = "SHFSBS">Student housing for students by students!</p>
			</div>
			
            <div>
	                    	<a href="searchPage.html">
	                    	<input type="submit" name ="search" value="Search for Apartments"/>
                            </a>
	                  
        </div>
			
			<div id="slideshow">
				<p><img src ="images/img1.png" alt="apartment" title="apartment"></p>
			</div>
			
			<div id="footer">
				<form action="Servlet" method="post">
				<table>
					<tr>
						<td><input type="submit" name ="contact" value="Contact Us"/></td>
						<td><input type="submit" name ="about" value="About Us"/></td>
       				</tr>
				</table>
				</form>
			</div>
		</div>
	</body>
</html>