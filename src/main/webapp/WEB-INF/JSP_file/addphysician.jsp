<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	padding-right: 50px;
}

.navigation_bar {
	width: 100%;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #189df0;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	font-size: large;
	text-align: center;
	padding: 10px 5px;
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
			<li><a href='physician' style="background-color: #548cff;">Add
					Physician</a></li>
			<li><a href='searchPhysician'>Search Physician </a></li>
			<li><a href='diagnosis'>Patient Diagnosis Details</a></li>
			<li><a href='patientHistory'>View Patient History</a></li>
			<li style="float: right;"><a href="logout"><i
					class="fa fa-sign-in" aria-hidden="true" style="color: white;"></i>&nbsp;Logout</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">



		<h1 align="center">Add Physician Details</h1>
		<form:form modelAttribute="physician" action="savePhysician">



			<div class="form-group">
				<form:label path="firstName">First Name:*</form:label>
				<form:input class="form-control" path="firstName" />
				<form:errors cssClass="error_message" path="firstName"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name:*</form:label>
				<form:input class="form-control" path="lastName" />
				<form:errors cssClass="error_message" path="lastName"></form:errors>
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


			<div class="form-group">
				<form:label path="educationalQualifications">Educational Qualifications:*</form:label>
				<form:select id="EducationalQualifications" class="form-control"
					path="educationalQualifications">
					<form:option value="">--Select Educational Qualifications--</form:option>
					<form:option value="M.B.B.S">M.B.B.S</form:option>
					<form:option value="Ph.D">Ph.D</form:option>
					<form:option value="MD(Doctor of Medicine)">MD(Doctor Of Medicine)</form:option>
					<form:option value="JD(Juris Doctor)">JD(Juris Doctor)</form:option>
				</form:select>
				<form:errors cssClass="error_message"
					path="educationalQualifications"></form:errors>
			</div>

			<div class="form-group">
				<form:label path="yearsOfExperience">Years Of Experience:*</form:label>
				<form:select id="YearsOfExperience" class="form-control"
					path="yearsOfExperience">
					<form:option value="">--Select Years Of Experience--</form:option>
					<form:option value="Fresher">Fresher</form:option>
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
					<form:option value="8">8</form:option>
					<form:option value="9">9</form:option>
					<form:option value="10">10</form:option>
					<form:option value="10+">10+</form:option>
				</form:select>
				<form:errors cssClass="error_message" path="yearsOfExperience"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="state">State:*</form:label>
				<form:select id="State" class="form-control" path="state">
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
					<form:option value="Uttarkhand">Uttarakhand</form:option>
					<form:option value="WB">West Bengal</form:option>
				</form:select>
				<form:errors cssClass="error_message" path="state"></form:errors>
			</div>




			<div class="form-group">
				<form:label path="insurancePlan">Insurance Plan:*</form:label>
				<form:input class="form-control" path="insurancePlan" />
				<form:errors cssClass="error_message" path="insurancePlan"></form:errors>
			</div>



			<div class="form-group" align="center">
				<input type="submit" class="btn btn-primary" value="Submit">
				<input type="reset" class="btn btn-primary" value="reset">

			</div>
		</form:form>
	</div>
</body>
</html>