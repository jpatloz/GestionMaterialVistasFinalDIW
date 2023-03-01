<%@ include file="/vistas/cabecera.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordenador encontrado</title>
</head>
<body>
	<h1>Ordenador encontrado</h1>
	<b>Id: </b>
	<p>${ordenador.id_ordenador}</p>
	<b>Modelo: </b>
	<p>${ordenador.modelo}</p>
	<b>Marca: </b>
	<p>${ordenador.marca}</p>

	<br>
	<br>
	<button type="button" onclick="history.back()">Volver</button>
</body>
</html>