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
<script>
        function myFunction(){

        	var x=document.getElementById("myInput").value;
                   if(x=="Card"){
                   document.getElementById("demo").innerHTML="<br><b>"+x+"</b>" +"<b> Number:*</b>"+"<br><input type='number' id='card_number' class='form-control' oninput='putCardNumberValue()' required > ";
                   }
                   else{
                	   document.getElementById("demo").innerHTML=" "; 
                   }
            }
        function putCardNumberValue(){
        	var x=document.getElementById("card_number").value;
            document.getElementById("card_number_hidden").value=x; 
                   
            }
        function check_card_number(){
        	var x=document.getElementById("card_number").value;
            document.getElementById("card_number_hidden").value=x; 
            if(x.length != 16){
            	document.getElementById("cardNumberErrormessage").innerHTML="Card number must contain 16 digits";
            	return false;
            }
            else{
            	document.getElementById("cardNumberErrormessage").innerHTML="";
            	return true;
            }
                   
            }
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

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
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
     <li><a href='diagnosis' style="background-color:#548cff;">Patient Diagnosis Details</a></li>
     <li><a href='patientHistory'>View Patient History</a></li>
     <li style="float:right;"><a href="logout"><i class="fa fa-sign-in" aria-hidden="true" style="color:white;"></i>&nbsp;Logout</a></li>
    </ul>
</div>
 <div class="container">
<form:form action="addDiagnosis" modelAttribute="diagnosis" method="post" onsubmit="return check_card_number()">
 <h1 align="center">Patient Diagnosis Details</h1>
 <c:if test="${not empty message}">
   <p class="alert alert-danger">${message}</p>
	</c:if>
 <div class="form-group">
    <form:label path="patientId">Patient Id:*</form:label>
     <form:input class="form-control" path="patientId"/>
     <form:errors cssClass="error_message" path="patientId"></form:errors>
</div>

<div class="form-group">
        <form:label path="symptoms">Symptoms:*</form:label>
        <form:input class="form-control" path="symptoms"/>
        <form:errors cssClass="error_message" path="symptoms"></form:errors>
</div>
<div class="form-group">
    <form:label path="diagnosisProvided">Diagnosis Provided:*</form:label>
    <form:input class="form-control" path="diagnosisProvided"/>
    <form:errors cssClass="error_message" path="diagnosisProvided"></form:errors>
</div>
<div class="form-group">
        <form:label path="administeredBy">Administrated By:*</form:label>
        <form:input class="form-control" path="administeredBy"/>
        <form:errors cssClass="error_message" path="administeredBy"></form:errors>
</div>
<div class="form-group">
    <form:label path="dateOfDiagnosis">Date of Diagnosis:*</form:label>
    <form:input type="date" class="form-control" path= "dateOfDiagnosis"/>
    <form:errors cssClass="error_message" path="dateOfDiagnosis"></form:errors>
</div>
<div class="form-group">
    <form:label class="custom-control-label" path="followUpRequired">Follow-up Required:</form:label>
    <form:radiobutton class="custom-control-input" path="followUpRequired" value="Yes"/>Yes
    <form:radiobutton class="custom-control-input" path="followUpRequired" value="No"/>No
    <%-- <form:errors cssClass="error_message" path="followupReguired"></form:errors> --%>
</div>
<div class="form-group">
    <form:label path="dateOfFollowUp">Date of Follow up:</form:label>
    <form:input type="date" class="form-control" path= "dateOfFollowUp"/>
    <%-- <form:errors cssClass="error_message" path="dateOfFollowup"></form:errors> --%>
</div>
<div class="form-group">
       <form:label path="modeOfPayment">Mode of Payment:*</form:label>
       
           <form:select  class="form-control" path="modeOfPayment" id="myInput" oninput="myFunction()">
            <form:option value="">--Select Option--</form:option>
            <form:option value="Card">Card</form:option>
            <form:option value="Cash">Cash</form:option>
      </form:select>
       <form:errors cssClass="error_message" path="modeOfPayment"></form:errors>
       <p id="demo"></p> 
       <form:hidden path="cardNumber" id="card_number_hidden" value=""/>
       <p style="color:red;" id="cardNumberErrormessage"></p>
</div>
<div class="form-group">
    <form:label path="billAmount">Bill Amount:*</form:label>
    <form:input type="text" class="form-control" path= "billAmount"/>
    <form:errors cssClass="error_message" path="billAmount"></form:errors>
</div>
<div class="form-group">
    <input type="submit" class="btn btn-primary btn-block" value="Submit">
</div>
</form:form>
</div><br><br>
</body>

</html>  