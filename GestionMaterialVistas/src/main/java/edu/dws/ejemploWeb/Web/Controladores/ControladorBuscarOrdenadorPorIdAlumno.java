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
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresTODTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

@Controller
public class ControladorBuscarOrdenadorPorIdAlumno {

	// Inyectamos el servicio
	@Autowired
	Consultas consulta;

	ADaoServicioImpl aDao = new ADaoServicioImpl();
	GestionOrdenadoresTODTO aDto = new GestionOrdenadoresTODTO();

	// Utilizamos el método Post y ModelAttribute para enviar la información al formulario de la vista
	@RequestMapping(value = "/guardarOrdenadorPorIdAlumno", method = RequestMethod.POST)
	public ModelAndView guardarPcPorIdAlumno(@ModelAttribute("id") GestionAlumnosDTO id, Model model) {

		// Pasamos a dao
		GestionAlumnos gestionAlumnos = aDao.GestionAlumnosDTOADAO(id);

		// LLamamos a la consulta para buscar el ordenador por id de alumno
		GestionOrdenadores gestionOrdenadores = consulta.buscarOrdenadorPorIdAlumno(gestionAlumnos.getId_alumno());

		// Una vez recogida la información, pasamos a DTO para enviarlo a la vista
		GestionOrdenadoresDTO gestionOrdenadoresDTO = aDto.gestionOrdenadoresTODTO(gestionOrdenadores);
		model.addAttribute("ordenador", gestionOrdenadoresDTO);
		return new ModelAndView("ordenadorEncontrado");
	}
}
