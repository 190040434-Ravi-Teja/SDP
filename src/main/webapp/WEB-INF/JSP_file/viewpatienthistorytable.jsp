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
    <script type="text/javascript">$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
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
</nav>
      <br><h1 align="center">Patient Details</h1><br>
      <c:if test="${not empty message}">
   <p class="alert alert-danger">${message}</p>
	</c:if>
      <div class="container" align="center">
      
<table id="example" class="table table-bordered table-primary" style="width:1000px;">
    <tbody>
        <tr>
        	<th>Diagnosis Id</th>
	        <th>Patient Id</th>
	        <th>Symptoms</th>
	        <th>Administered by</th>
	        <th>Date of Diagnosis</th>
	        <th>View</th>
      </tr>
      
      <c:forEach items="${patientList}" var="patient">
    	<tr>
      		<td><c:out value="${patient.diagnosisId}"></c:out></td>
      		<td><c:out value="${patient.patientId}"></c:out></td>
      		<td><c:out value="${patient.symptoms}"></c:out></td>
      		<td><c:out value="${patient.administeredBy}"></c:out></td>
      		<td><c:out value="${patient.dateOfDiagnosis}"></c:out></td>
            <td><a href="viewPatientDetail?id=${patient.diagnosisId}"> View</a></td>
    	</tr>
  		</c:forEach>
      
    
</tbody>
  </table>
  </div>
</body>
</html>