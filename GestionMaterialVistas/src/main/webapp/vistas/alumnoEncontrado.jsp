<%@ include file="/vistas/cabecera.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alumno</title>
</head>
<body>
	<h1>Alumno</h1>
	<b>Id: </b><p>${alumno.id_alumno}</p>
	<b>Nombre: </b><p>${alumno.nombre_alumno}</p>
	<b>Apellidos: </b><p>${alumno.apellidos_alumno}</p>
	
	<br>
	<br>
		<p>
            Mensaje del controlador: 
            <c:out value="${miModelo.Mensaje}" />
        </p>
	<br>
	<br>
	<button type="button" onclick="history.back()">Volver</button>
</body>
</html>