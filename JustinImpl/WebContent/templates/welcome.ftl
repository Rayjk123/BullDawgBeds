<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bulldawg Beds</title>
<link href="index.css" type="text/css" rel="stylesheet" />
<script src="sliderengine/jquery.js"></script>
	    <script src="sliderengine/amazingslider.js"></script>
	    <link rel="stylesheet" type="text/css" href="sliderengine/amazingslider-1.css">
	    <script src="sliderengine/initslider-1.js"></script>
</head>

<body>
	<div>
		<div class="HeaderBacking">
			<h1 class="BullDawgBeds">Bulldawg Beds</h1>


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


		<div id="wrapper">
			<p class="SHFSBS">Student housing for students by students!</p>
		</div>

		<div>
			<a href="searchPage.html"> <input type="submit" name="search"
				value="Search for Apartments" />
			</a>

		</div>

		<div id="slideshow">
			<div id="amazingslider-wrapper-1"
		style="display: block; position: relative; max-width: 1500px; margin: 0px auto 56px;">
		<div id="amazingslider-1"
			style="display: block; position: relative; margin: 0 auto;">
			<ul class="amazingslider-slides" style="display: none;">
				<li><img src="images/3.jpg" /></li>
				<li><img src="images/2.jpg" /></li>
				<li><img src="images/1.jpg" /></li>
				<li><img src="images/7.jpg" /></li>
				<li><img src="images/8.jpg" /></li>
			</ul>
			<ul class="amazingslider-thumbnails" style="display: none;">
				<li><img src="images/3-tn.jpg" /></li>
				<li><img src="images/2-tn.jpg" /></li>
				<li><img src="images/1-tn.jpg" /></li>
				<li><img src="images/7-tn.jpg" /></li>
				<li><img src="images/8-tn.jpg" /></li>
			</ul>
		</div>
	</div>
		</div>

		<div id="footer">
			<form action="Servlet" method="post">
				<table>
					<tr>
						<td><input type="submit" name="contact" value="Contact Us" /></td>
						<td><input type="submit" name="about" value="About Us" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>