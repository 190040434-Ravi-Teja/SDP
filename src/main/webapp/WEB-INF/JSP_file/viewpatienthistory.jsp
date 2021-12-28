<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HMS</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
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
 background-color: #0161fa;
 color:white;
 text-decoration:none;
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
     <li><a href='patient'>Enroll Patient</a></li>
     <li><a href='physician'>Add Physician</a></li>
     <li><a href='searchPhysician'>Search Physician </a></li>
     <li><a href='diagnosis'>Patient Diagnosis Details</a></li>
     <li><a href='patientHistory' style="background-color:#548cff;">View Patient History</a></li>
     <li style="float:right;"><a href="logout"><i class="fa fa-sign-in" aria-hidden="true" style="color:white;"></i>&nbsp;Logout</a></li>
		</ul>
	</div>
 <div class="container">
	<form:form action="viewPatientHistory" modelAttribute="patientHistory" method="post" >
 <h1 align="center">View Patient History</h1>
 <c:if test="${not empty message}">
   <p class="alert alert-danger">${message}</p>
	</c:if>
<div class="form-group">
    <form:label path="patientId">Patient Id:*</form:label>
     <form:input class="form-control" path="patientId"/>
    <form:errors cssClass="error_message" path="patientId"></form:errors>
</div>
<div class="form-group">
       <form:label path="firstName">First Name:*</form:label>
       <form:input class="form-control"  path="firstName"/>
     <form:errors cssClass="error_message" path="firstName"></form:errors>
</div>
<div class="form-group">
        <form:label path="lastName">Last Name:*</form:label>
        <form:input class="form-control" path="lastName"></form:input>
      <form:errors cssClass="error_message" path="lastName"></form:errors>
</div>
<div class="form-group" align="center">
    <input type="Submit" class="btn btn-primary" value="Submit">
</div>
</form:form>
</div>
</body>
</html>