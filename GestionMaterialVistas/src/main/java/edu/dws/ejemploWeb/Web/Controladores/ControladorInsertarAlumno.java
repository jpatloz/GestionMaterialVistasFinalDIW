package edu.dws.ejemploWeb.Web.Controladores;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.Web.servicios.Consultas;
import edu.dws.ejemploWeb.aplicacion.DTO.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnosServicios;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadoresServicios;

/*
 * Controlador para la inserción de alumnos
 */

@Controller
public class ControladorInsertarAlumno {

	// Inyectamos el servicio
	@Autowired
	Consultas consulta;

	ADaoServicioImpl aDao = new ADaoServicioImpl();

	// Utilizamos el método Post y ModelAttribute para enviar la información al formulario de la vista
	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoInsertado") GestionAlumnosDTO alumnoInsertado) {

		// Utilizamos el id del ordenador que hemos añadido en el DTO
		long id = alumnoInsertado.getId_ordenador();

		// Pasamos el alumno a DAO
		GestionAlumnos gestionAlumnos = aDao.GestionAlumnosDTOADAO(alumnoInsertado);

		// Añadimos los valores de md_uuid y md_date antes de insetarlos
		gestionAlumnos.setMd_uuid(UUID.randomUUID().toString());
		gestionAlumnos.setMd_date(Calendar.getInstance());

		// LLamamos a la consulta para que busque los id de ordenador
		GestionOrdenadores gestionOrdenadores = consulta.buscarOrdenadorPorId(id);

		// Se mete el ordenador que hemos recogido antes por el id
		gestionAlumnos.setOrdenadores(gestionOrdenadores);

		// LLamamos a la consulta de inserción
		consulta.insertarUnaMatricula(gestionAlumnos);
		return new ModelAndView("alumnoInsertado");
	}
}
