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
import edu.dws.ejemploWeb.aplicacion.DTO.GestionOrdenadoresDTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

/*
 * Controlador para la inserción de ordenadores
 */

@Controller
public class ControladorInsertarOrdenador {

	// Inyectamos el servicio
	@Autowired
	Consultas consulta;

	// Instanciamos nuestra clase aDao para poder interactuar con la base de datos
	ADaoServicioImpl aDao = new ADaoServicioImpl();

	// Utilizamos el método Post y ModelAttribute para enviar la información al formulario de la vista
	@RequestMapping(value = "/guardarOrdenador", method = RequestMethod.POST)
	public ModelAndView guardarOrdenador(
			@ModelAttribute("ordenadorInsertado") GestionOrdenadoresDTO ordenadorInsertado) {

		// Pasamos de DTO a DAO
		GestionOrdenadores gestionOrdenadores = aDao.GestionOrdenadoresDTOADAO(ordenadorInsertado);

		// Añadimos los valores de md_uuid y md_date antes de insertarlos
		gestionOrdenadores.setMd_uuid(UUID.randomUUID().toString());
		gestionOrdenadores.setMd_date(Calendar.getInstance());

		// Realizamos la consulta
		consulta.insertarUnOrdenador(gestionOrdenadores);
		return new ModelAndView("ordenadorInsertado");
	}
}
