package edu.dws.ejemploWeb.Web.Controladores;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import edu.dws.ejemploWeb.Web.servicios.Consultas;
import edu.dws.ejemploWeb.Web.servicios.ConsultasUsuario;
import edu.dws.ejemploWeb.aplicacion.DTO.ADaoServicioImpl;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosTODTO;
import edu.dws.ejemploWeb.aplicacion.DTO.UsuarioDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.UsuarioTODTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dal.Usuario;

@Controller
public class ControladorRegistroUsuarios {

	// Inyectamos el servicio
	@Autowired
	ConsultasUsuario consulta;

	// Creamos un map para almacenar la clave alumnos y en el valor la lista de
	// alumnos
	Map<String, Object> miModelo = new HashMap<String, Object>();

	ADaoServicioImpl aDao = new ADaoServicioImpl();
	UsuarioTODTO aDto = new UsuarioTODTO();

	// Utilizamos el método Post y ModelAttribute para enviar la información al
	// formulario de la vista
	@RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("usuarioInsertado") UsuarioDTO usuarioInsertado) {
		try {

			// Pasamos el alumno a DAO
			Usuario usuario = aDao.UsuariosDTOADAO(usuarioInsertado);

			if (Long.toString(usuario.getId()).isEmpty() || usuario.getNombre().isEmpty()
					|| usuario.getApellidos().isEmpty() || usuario.getNombreUsuario().isEmpty()
					|| usuario.getPassword().isEmpty()) {
				miModelo.put("Mensaje", "Los campos no pueden ser nulos");
				return new ModelAndView("registro", "miModelo", miModelo);
			} else {
				// LLamamos a la consulta de inserción
				consulta.registrar(usuario);
				miModelo.put("Mensaje", "El registro se ha completado correctamente");
			}
			return new ModelAndView("login", "miModelo", miModelo);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(@ModelAttribute("usuarioLogueado") UsuarioDTO usuarioDTO) {
	    try {
	    	
	    	Usuario usuario = aDao.UsuariosDTOADAO(usuarioDTO);
	        
	    	consulta.verificarCredenciales(usuario.getNombreUsuario(), usuario.getPassword());
	    	
	        if (usuario != null) {
	        	
	        	miModelo.put("Mensaje", "Has iniciado sesión");
				return new ModelAndView("../index", "miModelo", miModelo);
	        } else {
	        	miModelo.put("Mensaje", "EL usuario o contraseña son incorrectos");
				return new ModelAndView("login", "miModelo", miModelo);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}
}

