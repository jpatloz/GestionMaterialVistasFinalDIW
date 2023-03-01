package edu.dws.ejemploWeb.Web.Controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.ejemploWeb.Web.servicios.Consultas;
import edu.dws.ejemploWeb.aplicacion.DTO.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresDTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

@Controller
public class ControladorInsertarOrdenador {
	
	// Creamos una instancia de nuestro servicio consukltas para hacer el insert
	
		@Autowired
		Consultas consulta;
		//Instanciamos nuestra clase aDao para poder subir los datos a bbdd
		ADaoServicioImpl aDao = new ADaoServicioImpl();

		@RequestMapping(value = "/guardarOrdenador", method = RequestMethod.POST)
		public ModelAndView guardarOrdenador(@ModelAttribute("ordenadorInsertado") GestionOrdenadoresDTO ordenadorInsertado){
			GestionOrdenadores gestionOrdenadores = aDao.GestionOrdenadoresDTOADAO(ordenadorInsertado);
			gestionOrdenadores.setMd_uuid(UUID.randomUUID().toString());
			gestionOrdenadores.setMd_date(Calendar.getInstance());
			consulta.insertarUnOrdenador(gestionOrdenadores);
			return new ModelAndView("ordenadorInsertado");
		}
}
