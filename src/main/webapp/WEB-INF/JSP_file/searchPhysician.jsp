<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HMS</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
nav ul li {
	padding-right: 60px;
}

.navigation_bar {
	width: 100%;
}

demo {
	font-weight: bold;
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

li a {
	display: block;
	color: white;
	font-size: large;
	text-align: center;
	padding: 15px 10px;
	font-weight: bold;
	text-decoration: none;
}

li a:hover {
	background-color: #0161fa;
	color: white;
	text-decoration: none;
}

.error_message {
	color: red;
}
</style>
</head>
<body>
	<div class="navigation_bar"
		class="navbar navbar-expand-sm bg-primary navbar-dark">
		<ul>
			<li><a href="home">Hospital Management System</a></li>
			<li><a href='patient'>Enroll Patient</a></li>
			<li><a href='physician'>Add Physician</a></li>
			<li><a href='searchPhysician' style="background-color: #548cff;">Search
					Physician </a></li>
			<li><a href='diagnosis'>Patient Diagnosis Details</a></li>
			<li><a href='patientHistory'>View Patient History</a></li>
			<li style="float: right;"><a href="logout"><i
					class="fa fa-sign-in" aria-hidden="true" style="color: white;"></i>&nbsp;Logout</a></li>
		</ul>
	</div>
	</nav>



	<div class="container">

		<h1 align="center">Physician Search</h1>

		<c:if test="${not empty physicianMessage}">
			<p class="alert alert-danger">${physicianMessage}</p>
		</c:if>



		<form:form modelAttribute="searchPhysician"
			action="saveSearchPhysician">



			<div class="form-group">
				<form:label path="state">State:*</form:label>
				<form:select id="state" class="form-control" path="state">
					<form:option value="">--Select State--</form:option>
					<form:option value="AndhraPradesh">Andhra Pradesh</form:option>
					<form:option value="ArunachalPradesh">Arunachal Pradesh</form:option>
					<form:option value="Assam">Assam</form:option>
					<form:option value="Bihar">Bihar</form:option>
					<form:option value="Chattisgarh">Chattisgarh</form:option>
					<form:option value="Goa">Goa</form:option>
					<form:option value="Gujarat">Gujarat</form:option>
					<form:option value="Haryana">Haryana</form:option>
					<form:option value="HimachalPradesh">Himachal Pradesh</form:option>
					<form:option value="Jharkand">Jharkand</form:option>
					<form:option value="Karnataka">Karnataka</form:option>
					<form:option value="Kerala">Kerala</form:option>
					<form:option value="MadhyaPradesh">Madhya Pradesh</form:option>
					<form:option value="Maharasthra">Maharashtra</form:option>
					<form:option value="Manipur">Manipur</form:option>
					<form:option value="Meghalaya">Meghalaya</form:option>
					<form:option value="Mizoram">Mizoram</form:option>
					<form:option value="Nagaland">Nagaland</form:option>
					<form:option value="Odisha">Odisha</form:option>
					<form:option value="Punjab">Punjab</form:option>
					<form:option value="Rajasthan">Rajasthan</form:option>
					<form:option value="Sikkim">Sikkim</form:option>
					<form:option value="TamilNadu">Tamilnadu</form:option>
					<form:option value="Telangana">Telangana</form:option>
					<form:option value="Tripura">Tripura</form:option>
					<form:option value="UttarPradesh">Uttar Pradesh</form:option>
					<form:option value="Uttarkhand">Uttarkhand</form:option>
					<form:option value="WB">West Bengal</form:option>
				</form:select>
				<form:errors cssClass="error_message" path="state"></form:errors>
			</div>





			<div class="form-group">
				<form:label path="insurancePlan">Plan:</form:label>
				<form:input class="form-control" path="insurancePlan" />
				<form:errors cssClass="error_message" path="insurancePlan"></form:errors>
			</div>





			<div class="form-group">
				<form:label path="department">Department:*</form:label>
				<form:select id="Department" class="form-control" path="department">
					<form:option value="">--Select Department--</form:option>
					<form:option value="Anatomy">Anatomy</form:option>
					<form:option value="Anaesthesiology">Anaesthesiology</form:option>
					<form:option value="Cardiologist">Cardiologist</form:option>
					<form:option value="Gynecologist">Gynecologist</form:option>
					<form:option value="Ophthalmology">Ophthalmology</form:option>
					<form:option value=" Orthopedics"> Orthopedics</form:option>
					<form:option value="Paediatrics">Paediatrics</form:option>
					<form:option value="Pathology">Pathology</form:option>
					<form:option value="peditrician">Peditrician</form:option>
					<form:option value="Psychiatry">Psychiatry</form:option>
					<form:option value="pulmonologist">Pulmonologist</form:option>
					<form:option value="Physiology">Physiology</form:option>
				</form:select>
				<form:errors cssClass="error_message" path="department"></form:errors>
			</div>
			<div class="form-group" align="center">
				<input type="submit" class="btn btn-primary" value="Search">
				<input type="Reset" class="btn btn-primary" value="Reset">
			</div>
		</form:form>
	</div>
</body>
</html>