<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda del ordenador por id de alumno</title>
</head>
<body>
	<h1>Buscar Ordenador</h1>
	<form:form method="POST" action="guardarOrdenadorPorIdAlumno"
		modelAttribute="id">
		<table>
			<tr>
				<td><form:label path="id_alumno">Id</form:label></td>
				<td><form:input path="id_alumno" /></td>
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