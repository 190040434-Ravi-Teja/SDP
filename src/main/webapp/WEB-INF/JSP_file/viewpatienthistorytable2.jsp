<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>HMS</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
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
 background-color: #0161fa;
 color:white;
 text-decoration:none;
}
.error_message{
    color:red;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
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
</nav>
      <br><h1 align="center">Patient Details</h1><br>
      
<table class="table table-bordered table-primary" align="center" style="width:800px;">
    <tbody>
        <tr align="center">
         <td ><b>Patient Id </b></td>
         <td><c:out value="${patient.patientId}"></c:out></td>
       </tr>
       <tr align="center">
         <td><b>Diagnosis Id </b></td>
         <td><c:out value="${patient.diagnosisId}"></c:out></td>	
       </tr>
       <tr align="center">
         <td><b>Symptoms</b></td>
         <td><c:out value="${patient.symptoms}"></c:out></td>
        </tr>
        <tr align="center">
         <td><b>Diagnosis Provided</b></td>
         <td><c:out value="${patient.diagnosisProvided}"></c:out></td>
      </tr>
      <tr align="center" >
         <td><b>Administered by</b></td>
         <td><c:out value="${patient.administeredBy}"></c:out></td>	
      </tr>
      <tr align="center">
         <td><b>Date of Diagnosis</b></td>
        <td><c:out value="${patient.dateOfDiagnosis}"></c:out></td>
      </tr>
      <c:if test="${patient.followUpRequired } != null">
      	<tr align="center">
        <td><b>Follow-up Required</b></td>
        <td><c:out value="${patient.followUpRequired}"></c:out></td>
    	</tr>	
      </c:if>
      
     <c:if test="${patient.dateOfFollowUp } != null"> 
     <tr align="center" >
        <td><b>Date of Follow up</b></td>
        <td><c:out value="${patient.dateOfFollowUp}"></c:out></td>
     </tr>
     </c:if>
     <tr align="center">
        <td><b>Bill Amount</b></td>
        <td><c:out value="${patient.billAmount}"></c:out></td>	
     </tr>
     <tr align="center">
        <td><b>Payment Mode</b></td>
        <td><c:out value="${patient.modeOfPayment}"></c:out></td>	
     </tr>
</tbody>
  </table>
</body>
</html>