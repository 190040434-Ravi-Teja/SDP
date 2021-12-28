<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>HMS</title>
<style>

	body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  background-image: url("/HospitalManagementSystem/resources/background_image.png");
  
  height:90%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
.container {
  padding-top: 10%;
  position: absolute;
  right: 70px;
  margin: 20px;
  max-width: 500px;
  padding: 16px;
  background-color: white;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 10px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

.btn {
  background-color:#52b0eb;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.head { 
    background-color: #0067A5;
    color: white;
    text-align: center;
    height: 50px;
    font-size: 30px;
}
#cssmenu {
  background: #3aa8ec;
  width: auto;
}
#cssmenu ul li {
  display: inline-block;
  padding: 0;
  margin: 0;
}
.btn:hover {
  opacity: 1;
}
.error_message{
color:red;
margin-bottom:10px;
}
#message_box{
font-size:large;
font-weight:bolder;
}
</style>
</head>
<body>
	<div id='cssmenu'>
    <ul>
      <li><h4 style="font-weight:bolder;">Hospital Management System</h4></li>
    </ul>
    </div>

<div class="bg-img">
	<form:form action="login" modelAttribute="administrator" class="container" method="post">
 	<h1>Administrator Login</h1>
 	<c:if test="${not empty message}">
   <p class="alert alert-danger">${message}</p>
	</c:if>
 	
<div class="form-group">
    <form:label path="username">Administrator Name:*</form:label>
     <form:input class="form-control" path="username" placeholder="Enter Username"/>
     <form:errors path="username" cssClass="error_message" /><br/>
</div>

<div class="form-group">
        <form:label path="password">Password:*</form:label>
        <form:password class="form-control" path="password" placeholder="Enter Password"/>
        <form:errors path="password" cssClass="error_message" /><br/>
</div>
<div class="form-group">
    <input type="submit" class="btn btn-primary btn-block" value="Submit">
</div>
</form:form>
</div>
</body>
</html>