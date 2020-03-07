<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-light bg-dark">
	   <span class="navbar-header " >
	      <h1>
	        <a class="nav-header" 
	        	href="<c:url value='/pages/home.jsp' /> ">
	        	Controle Patrimonial 
	        </a>
	      </h1> 
	   </span>
	</nav>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
			
</body>
</html>


