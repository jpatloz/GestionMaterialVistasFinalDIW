<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Formulario</title>
</head>
<body>
	<h1>Nuevo Alumno</h1>
	<form:form method="POST" action="guardarAlumno"
		modelAttribute="alumnoInsertado">
		<table>
			<tr>
				<td><form:label path="nombre_alumno">Nombre</form:label></td>
				<td><form:input path="nombre_alumno" /></td>
			</tr>
			<tr>
				<td><form:label path="apellidos_alumno">Apellidos</form:label></td>
				<td><form:input path="apellidos_alumno" /></td>
			</tr>
			<tr>
				<td><form:label path="num_telefono">Número de teléfono</form:label></td>
				<td><form:input path="num_telefono" /></td>
			</tr>
			<tr>
				<td><form:label path="id_ordenador">Id del ordenador</form:label></td>
				<td><form:input path="id_ordenador" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	<button type="button" onclick="history.back()">Volver</button>
</body>
</html>