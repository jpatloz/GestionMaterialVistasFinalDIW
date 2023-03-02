<%@ include file="/vistas/cabecera.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1> Mensaje del controlador: <c:out value="${miModelo.Mensaje}" /></h1>

	<br>
	<br>
	<button type="button" onclick="history.back()">Volver</button>
</body>
</html>