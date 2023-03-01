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

@Controller
public class ControladorInsertarAlumno {

	// Creamos una instancia de nuestro servicio consukltas para hacer el insert
	
	
	@Autowired
	Consultas consulta;
	
	ADaoServicioImpl aDao = new ADaoServicioImpl();

	@RequestMapping(value = "/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumnoInsertado") GestionAlumnosDTO alumnoInsertado) {
		long id = alumnoInsertado.getId_ordenador();
		GestionAlumnos gestionAlumnos = aDao.GestionAlumnosDTOADAO(alumnoInsertado);
		gestionAlumnos.setMd_uuid(UUID.randomUUID().toString());
		gestionAlumnos.setMd_date(Calendar.getInstance());
		GestionOrdenadores gestionOrdenadores = consulta.buscarOrdenadorPorId(id);
		gestionAlumnos.setOrdenadores(gestionOrdenadores);
		consulta.insertarUnaMatricula(gestionAlumnos);
		return new ModelAndView("alumnoInsertado");
	}
}
