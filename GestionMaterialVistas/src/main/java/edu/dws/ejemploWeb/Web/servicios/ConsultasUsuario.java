package edu.dws.ejemploWeb.Web.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.Usuario;
import edu.dws.ejemploWeb.aplicacion.dal.UsuarioServicios;

@Service
public class ConsultasUsuario {
	
	@Autowired
	private UsuarioServicios us;
	
	public void registrar(Usuario usuario){
		try {
			us.save(usuario);
		}catch(Exception e) {
			System.out.println(e);
		}
    }
	
	public void verificarCredenciales(String nombreUsuario, String password) {
		us.findByNombreUsuarioAndPassword(nombreUsuario, password);
	}
}
