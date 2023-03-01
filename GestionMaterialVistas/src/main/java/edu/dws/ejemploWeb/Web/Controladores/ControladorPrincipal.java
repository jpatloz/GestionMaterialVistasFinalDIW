package edu.dws.ejemploWeb.Web.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresDTO;

/*
 * En este controlador se definirán todas las vistas redirigidas por el index
 */

@Controller
public class ControladorPrincipal {

	// Formulario para insertar alumnos
	@RequestMapping(value = "/insertarAlumnos")
	public String insertarAlumnos(Model modelo) {

		// Creamos una instancia de alumnos DTO
		GestionAlumnosDTO gestionAlumnosDTO = new GestionAlumnosDTO();
		modelo.addAttribute("alumnoInsertado", gestionAlumnosDTO);
		return "insertarAlumnos";
	}

	// Listado de alumnos
	@RequestMapping(value = "/buscarTodosLosAlumnos")
	public ModelAndView buscarTodosLosAlumnos() {
		return new ModelAndView("buscarTodosLosAlumnos");
	}

	// Formulario para insertar ordenadores
	@RequestMapping(value = "/insertarOrdenadores")
	public String insertarOrdenadores(Model modelo) {

		// Creamos una instancia de ordenadores DTO
		GestionOrdenadoresDTO ordenadorInsertado = new GestionOrdenadoresDTO();
		modelo.addAttribute("ordenadorInsertado", ordenadorInsertado);
		return "insertarOrdenadores";
	}

	// Listado de ordenador por id de alumno
	@RequestMapping(value = "/buscarOrdenadorPorIdAlumno")
	public String buscarOrdenadorPorIdAlumno(Model modelo) {

		// Creamos una instancia de alumnos DTO
		GestionAlumnosDTO gestionAlumnosDTO = new GestionAlumnosDTO();
		modelo.addAttribute("id", gestionAlumnosDTO);
		return "buscarOrdenadorPorIdAlumno";
	}

	// Listado de alumnos por id de ordenador
	@RequestMapping(value = "/buscarAlumnoPorIdOrdenador")
	public String buscarAlumnoPorIdOrdenador(Model modelo) {

		// Creamos una instancia de ordenadores DTO
		GestionOrdenadoresDTO gestionOrdenadoresDTO = new GestionOrdenadoresDTO();
		modelo.addAttribute("idOrd", gestionOrdenadoresDTO);
		return "buscarAlumnoPorIdOrdenador";
	}
}
