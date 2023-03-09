<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Iniciar sesión</h1>
	<form:form method="POST" action="login"
		modelAttribute="usuarioLogueado">
		<table>
			<tr>
				<td><form:label path="nombreUsuario">Nombre de usuario</form:label></td>
				<td><form:input path="nombreUsuario" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Contraseña</form:label></td>
				<td><form:input path="password" required="required" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
		<p>
            <c:out value="${miModelo.Mensaje}" />
        </p>
</body>
</html>