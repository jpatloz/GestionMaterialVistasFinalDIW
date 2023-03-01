<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear ordenador</title>
</head>
<body>
<h1>Nuevo Ordenador</h1>
	<form:form method="POST" action="guardarOrdenador"
		modelAttribute="ordenadorInsertado">
		<table>
			<tr>
				<td><form:label path="marca">Marca</form:label></td>
				<td><form:input path="marca" /></td>
			</tr>
			<tr>
				<td><form:label path="modelo">Modelo</form:label></td>
				<td><form:input path="modelo" /></td>
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