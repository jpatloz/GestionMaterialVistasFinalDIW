<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Encontrar Alumno</title>
</head>
<body>
<h1>Buscar Alumno</h1>
	<form:form method="POST" action="guardarAlumnoPorIdOrdenador"
		modelAttribute="idOrd">
		<table>
			<tr>
				<td><form:label path="id_ordenador">Id</form:label></td>
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