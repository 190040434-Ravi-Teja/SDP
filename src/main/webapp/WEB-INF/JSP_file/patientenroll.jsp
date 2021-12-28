
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HMS</title>
<!-- <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
nav ul li{
padding-right:50px;
}
.navigation_bar{
	width:100%;
}
ul {
 list-style-type: none;
 margin: 0;
 padding: 0;
 overflow: hidden;
 background: #3aa8ec;
}
 
li {
 float: left;
}
 
li a{
 display: block;
 color: white;
 font-size:medium;
 text-align: center;
 padding: 10px 12px;
 font-weight:bold;
 text-decoration: none;
}
 
li a:hover {
 background-color: #0161fa;
 color:white;
 text-decoration: none;
}

.error_message{
color:red;
}
</style>
</head>
<body>
<div class="navigation_bar" class="navbar navbar-expand-sm bg-primary navbar-dark">
    <ul>
     
     <li ><a href="home">Hospital Management System</a></li>
     <li><a href='patient' style="background-color:#548cff;">Enroll Patient</a></li>
     <li><a href='physician'>Add Physician</a></li>
     <li><a href='searchPhysician'>Search Physician </a></li>
     <li><a href='diagnosis'>Patient Diagnosis Details</a></li>
     <li><a href='patientHistory'>View Patient History</a></li>
     <li style="float:right;"><a href="logout"><i class="fa fa-sign-in" aria-hidden="true" style="color:white;"></i>&nbsp;Logout</a></li>
    </ul>
    </div>
<div class="container">
<form:form action="enrollPatient" modelAttribute="patient" >
 <h1 align="center">Patient Registration Form</h1>
<div class="form-group">
    <form:label path="firstName">First Name:*</form:label>
     <form:input class="form-control" path="firstName"/>
     <form:errors path="firstName" cssClass="error_message" /><br/>
</div>
<div class="form-group">
       <form:label path="lastName">Last Name:*</form:label>
       <form:input class="form-control"  path="lastName"/>
       <form:errors path="lastName" cssClass="error_message" /><br/>
</div>
<div class="form-group">
        <form:label path="email">Email:*</form:label>
        <form:input class="form-control" path="email"/>
        <form:errors path="email" cssClass="error_message" /><br/>
</div>
<div class="form-group">
        <form:label path="password">Password:*</form:label>
        <form:password class="form-control" path="password"/>
        <form:errors path="password" cssClass="error_message" /><br/>
</div>
<div class="form-group">
        <form:label class="custom-control-label" path="gender">Gender:*</form:label><br>
        <form:radiobutton class="custom-control-input" path="gender" value="male"/>Male&nbsp;&nbsp;
        <form:radiobutton class="custom-control-input" path="gender" value="female"/>Female&nbsp;&nbsp;
        <form:radiobutton class="custom-control-input"  path="gender" value="other"/>Other<br>
        <form:errors path="gender" cssClass="error_message" /><br/>
</div>
<div class="form-group">
       <form:label path="state">State:*</form:label>
       <select id="state" class="form-control" name="state">
       <option value="">--Select State--</option>
       <option value="AndhraPradesh">Andhra Pradesh</option>
       <option value="ArunachalPradesh">Arunachal Pradesh</option>
       <option value="Assam">Assam</option>
       <option value="Bihar">Bihar</option>
       <option value="Chattisgarh">Chattisgarh</option>
       <option value="Goa">Goa</option>
       <option value="Gujarat">Gujarat</option>
       <option value="Haryana">Haryana</option>
       <option value="HimachalPradesh">Himachal Pradesh</option>
       <option value="Jharkand">Jharkand</option>
       <option value="Karnataka">Karnataka</option>
       <option value="Kerala">Kerala</option>
       <option value="MadhyaPradesh">Madhya Pradesh</option>
       <option value="Maharasthra">Maharashtra</option>
       <option value="Manipur">Manipur</option>
       <option value="Meghalaya">Meghalaya</option>
       <option value="Mizoram">Mizoram</option>
       <option value="Nagaland">Nagaland</option>
       <option value="Odisha">Odisha</option>
       <option value="Punjab">Punjab</option>
       <option value="Rajasthan">Rajasthan</option>
       <option value="Sikkim">Sikkim</option>
       <option value="TamilNadu">Tamilnadu</option>
       <option value="Telangana">Telangana</option>
       <option value="Tripura">Tripura</option>
       <option value="UttarPradesh">Uttar Pradesh</option>
       <option value="Uttarkhand">Uttarkhand</option>
       <option value="WB">West Bengal</option>
     </select>
     <form:errors path="state" cssClass="error_message" /><br/>
</div>
<div class="form-group">
    <form:label path="dob">Date of Birth:*</form:label>
    <form:input type="date" class="form-control" path= "dob"/>
    <form:errors path="dob" cssClass="error_message" /><br/>
</div>
<div class="form-group">
     <form:label path="contactNumber">Contact Number:*</form:label>
     <form:input type="tel" class="form-control"  path="contactNumber"/>
     <form:errors path="contactNumber" cssClass="error_message" /><br/>
</div>
<div class="form-group">
   <form:label path="insurance">Insurance Plan:*</form:label>
   <form:input class="form-control" path="insurance"/>
   <form:errors path="insurance" cssClass="error_message" /><br/>
</div>
<div class="form-group">
    <input type="submit" class="btn btn-primary btn-block" value="Submit">
</div>
</form:form>
</div><br><br>
<!-- <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
</body>
</html>