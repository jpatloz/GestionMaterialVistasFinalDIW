package edu.dws.ejemploWeb.Web.Controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.Web.servicios.Consultas;
import edu.dws.ejemploWeb.aplicacion.DTO.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosTODTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresDTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

@Controller
public class ControladorTodosLosAlumnos {

	// Inyectamos el servicio
	@Autowired
	Consultas consulta;

	// Creamos un map para almacenar la clave alumnos y en el valor la lista de alumnos
	Map<String, Object> miModelo = new HashMap<String, Object>();

	ADaoServicioImpl aDao = new ADaoServicioImpl();
	GestionAlumnosTODTO aDto = new GestionAlumnosTODTO();

	// En este caso usamos el método get porque necesitamos cargar la lista en este controlador, ya que es la función perteneciente a la vista

	@RequestMapping(value = "/buscarTodosLosAlumnos", method = RequestMethod.GET)
	public ModelAndView buscarTodosLosAlumnos() {

		try {
		// Creamos una lista de alumnos
		ArrayList<GestionAlumnosDTO> listaGestionAlumnos = (ArrayList<GestionAlumnosDTO>) consulta.buscarAlumnos();
		miModelo.put("alumnos", listaGestionAlumnos);
		return new ModelAndView("buscarTodosLosAlumnos", "miModelo", miModelo);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping(value = "/eliminarAlumno")
	public ModelAndView eliminarAlumno(@RequestParam long id_alumno) {// Usamos el RequestParam para parametrizar el id
		
		try {
			
		// LLamamos a la consulta para eliminar por id
		consulta.eliminarUnAlumno(id_alumno);
		miModelo.put("Mensaje", "El alumno ha sido borrado");
		return new ModelAndView("buscarTodosLosAlumnos", "miModelo", miModelo);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
