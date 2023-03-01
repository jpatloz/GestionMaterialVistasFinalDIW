package edu.dws.ejemploWeb.Web.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.Web.servicios.Consultas;
import edu.dws.ejemploWeb.aplicacion.DTO.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosTODTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresDTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

@Controller
public class ControladorBuscarAlumnoPorIdOrdenador {

	// Inyectamos el servicio
	@Autowired
	Consultas consulta;

	ADaoServicioImpl aDao = new ADaoServicioImpl();
	GestionAlumnosTODTO aDto = new GestionAlumnosTODTO();

	// Utilizamos el método Post y ModelAttribute para enviar la información al formulario de la vista
	@RequestMapping(value = "/guardarAlumnoPorIdOrdenador", method = RequestMethod.POST)
	public ModelAndView guardarAlumnoPorIdPortatil(@ModelAttribute("idOrd") GestionOrdenadoresDTO idOrd, Model model) {

		// Pasamos a dao
		GestionOrdenadores gestionOrdenadores = aDao.GestionOrdenadoresDTOADAO(idOrd);

		// LLamamos a la consulta para buscar el ordenador por id de alumno
		GestionAlumnos gestionAlumnos = consulta.buscarAlumnoPorIdOrdenador(gestionOrdenadores.getId_ordenador());

		// Una vez recogida la información, pasamos a DTO para enviarlo a la vista
		GestionAlumnosDTO gestionAlumnosDTO = aDto.gestionAlumnosTODTO(gestionAlumnos);
		model.addAttribute("alumno", gestionAlumnosDTO);
		return new ModelAndView("alumnoEncontrado");
	}
}
