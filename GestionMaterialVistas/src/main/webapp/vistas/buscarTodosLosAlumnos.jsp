<%@ include file="/vistas/cabecera.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Alumnos</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
<!-- Esta librería es necesaria importarla para usar el script de jquery necesario para la confirmación activa -->
</head>
<body>
<table>
  <thead>
    <tr>
      <th>Nombre</th>
      <th>Apellidos</th>
      <th>Id</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${miModelo.alumnos}" var="alumno">
      <tr>
        <td>${alumno.nombre_alumno}</td>
        <td>${alumno.apellidos_alumno}</td>
        <td>${alumno.id_alumno}</td>
        <td>
           <button onclick="eliminarAlumno(${alumno.id_alumno})">Eliminar</button>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
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

<script>
function eliminarAlumno(id) {
	  if (confirm("¿Está seguro de que desea eliminar este alumno?")) {
	    $.ajax({
	      url: "eliminarAlumno?id_alumno=" + id,
	      type: "GET",
	      data: { id_alumno: id },
	      success: function() {
	        // Recargar la página para mostrar la lista actualizada de alumnos
	        location.reload();
	      },
	      error: function(){
	        alert("Ha ocurrido un error al eliminar el alumno.");
	      }
	    });
	  }
	}
</script>

