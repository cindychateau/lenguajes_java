<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Lenguaje</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/languages/${lenguaje.id}" method="post" modelAttribute="lenguaje">
	        <h1>Editar Lenguaje</h1>
	        <input type="hidden" name="_method" value="put">
	        <div class="form-group">
	            <form:label path="nombre">Nombre</form:label>
	            <form:input path="nombre" class="form-control"/>
	            <form:errors path="nombre" class="text-danger" />
	        </div>
	        <div class="form-group">
	        	<form:label path="creador">Creador</form:label>
	            <form:input path="creador" class="form-control"/>
	            <form:errors path="creador" class="text-danger"/>
	        </div>
	        <div class="form-group">
	        	<form:label path="version">Versión</form:label>
	            <form:input path="version" class="form-control"/>
	            <form:errors path="version" class="text-danger"/>
	        </div>
	        <input type="submit" value="Guardar" class="btn btn-success">
	    </form:form> 
	</div>
</body>
</html>