<%@ include file="/vistas/cabecera.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Men� para la Gesti�n Escolar</title>
</head>
<body>
	<h1>GESTI�N ESCOLAR</h1>
	<ul>
		<li><a href="<c:url value="insertarAlumnos" />">Insertar Alumno</a><br></li>
		<li><a href="<c:url value="insertarOrdenadores" />">Insertar Ordenador</a><br></li>
		<li><a href="<c:url value="buscarOrdenadorPorIdAlumno" />">Buscar ordenador por id de alumno</a><br></li>
		<li><a href="<c:url value="buscarAlumnoPorIdOrdenador" />">Buscar alumno por id de ordenador</a><br></li>
		<li><a href="<c:url value="buscarTodosLosAlumnos" />">Listado de todos los alumnos</a></li>
	</ul>
</body>
</html>