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
	
		// Creamos una instancia de nuestro servicio consukltas para hacer el insert
		@Autowired
		Consultas consulta;
		
		ADaoServicioImpl aDao = new ADaoServicioImpl();
		GestionOrdenadoresTODTO aDto = new GestionOrdenadoresTODTO();
		
		@RequestMapping(value = "/guardarOrdenadorPorIdAlumno", method = RequestMethod.POST)
		public ModelAndView guardarPcPorIdAlumno(@ModelAttribute("id") GestionAlumnosDTO id, Model model) {
			GestionAlumnos gestionAlumnos = aDao.GestionAlumnosDTOADAO(id);
			GestionOrdenadores gestionOrdenadores = consulta.buscarOrdenadorPorIdAlumno(gestionAlumnos.getId_alumno());
			GestionOrdenadoresDTO gestionOrdenadoresDTO = aDto.gestionOrdenadoresTODTO(gestionOrdenadores);
			model.addAttribute("ordenador", gestionOrdenadoresDTO);
			return new ModelAndView("ordenadorEncontrado");
		}
}
