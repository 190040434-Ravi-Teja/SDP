<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HMS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
tbody{
    order: 1px solid black;
}
nav ul li{
padding-right:60px;
}
.navigation_bar{
width:100%;
}
demo{
font-weight:bold;
}
ul {
 list-style-type: none;
 margin: 0;
 padding: 0;
 overflow: hidden;
 background-color: #3aa8ec;
}
 
li {
 float: left;
}
 
li a{
 display: block;
 color: white;
 font-size:large;
 text-align: center;
 padding: 15px 10px;
 font-weight:bold;
 text-decoration: none;
}
 
li a:hover {
 background-color: #0a67fd;
 color:white;
 text-decoration:none;
}
.container{
  border: 5px outset;
  background-color: rgb(122, 206, 236); 
  height:450px;
  width:700px;
  border-radius:15px;
  border-color:black;
}
.talkbubble {
      width: 140px;
      height: 100px;
      background: rgb(248, 244, 244);
      position: relative;
      -moz-border-radius: 10px;
      -webkit-border-radius: 10px;
      border-radius: 10px;
      text-align:center;
      box-shadow: 8px 8px 8px rgba(5, 5, 5, 0.25);
      cursor: pointer;
     transition: all 0.1s ease-in;
    }
.talkbubble:hover {
  box-shadow: none;
  color: #777;
}
 
.talkbubble:active {
  box-shadow: inset 0 2px 5px rgba(0, 0, 0, 0.25);
}
a{
    padding-left:300px;
}
.bg-img{
    background-image: url("/HospitalManagementSystem/resources/homebackground.jpg");
    height:100%;
    top:0;
}
</style>
</head>
<body>
	<div class="bg-img">
		<div class="navigation_bar"
			class="navbar navbar-expand-sm bg-primary navbar-dark">
			<ul>
				<li><a href="home">Hospital Management System</a></li>
				<li style="float: right;"><a href="logout"><i
						class="fa fa-sign-in" aria-hidden="true" style="color: white;"></i>&nbsp;Logout</a></li>
			</ul>
		</div>
		</nav>

		<br>
<div style="width:50%;margin-left:5%; font-size:larger;font-weight:bolder;">
	<c:if test="${not empty homepagemessage}">
        <p class="alert alert-success">${homepagemessage}</p>
	</c:if>
</div>

		<div class="container">
			<br>
			<h2 align="center" style="color: white;">Welcome</h2>
			<br>
			<br>
			<table>
				<tr>
					<a href="patient" style="color: rgb(33, 202, 224);">
						<div class="talkbubble"
							style="position: absolute; left: 400px; top: 250px;">
							<br>
							<b>Enroll<br> Patient
							</b>
						</div>
					</a>
					<a href="physician" style="color: rgb(33, 202, 224);">
						<div class="talkbubble"
							style="position: absolute; left: 600px; top: 250px;">
							<br>
							<b>Add<br> Physician
							</b>
						</div>
					</a>
					<a href="searchPhysician" style="color: rgb(33, 202, 224);">
						<div class="talkbubble"
							style="position: absolute; left: 800px; top: 250px;">
							<br>
							<b>Search<br> Physician
							</b>
						</div>
					</a>
				</tr>
				<a href="diagnosis" style="color: rgb(33, 202, 224);">
					<div class="talkbubble"
						style="position: absolute; left: 500px; top: 420px;">
						<br>
						<b>Patient <br>Diagnosis Details
						</b>
					</div>
				</a>
				<a href="patientHistory" style="color: rgb(33, 202, 224);">
					<div class="talkbubble"
						style="position: absolute; left: 700px; top: 420px;">
						<br>
						<b>View<br> Patient Details
						</b>
					</div>
				</a>
				</tr>
			</table>
		</div>
		<br><br>
	</div>
	
</body>
</html>