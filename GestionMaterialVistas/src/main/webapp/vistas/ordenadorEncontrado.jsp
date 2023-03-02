<%@ include file="/vistas/cabecera.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordenador</title>
</head>
<body>
	<h1>Ordenador</h1>
	<b>Id: </b>
	<p>${ordenador.id_ordenador}</p>
	<b>Modelo: </b>
	<p>${ordenador.modelo}</p>
	<b>Marca: </b>
	<p>${ordenador.marca}</p>
	<br>
	<br>
		<p>
            <c:out value="${miModelo.Mensaje}" />
        </p>

	<br>
	<br>
	<button type="button" onclick="history.back()">Volver</button>
</body>
</html>