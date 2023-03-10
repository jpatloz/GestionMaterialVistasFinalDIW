package edu.dws.ejemploWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioServicios extends CrudRepository<Usuario, Long>{
	
	public Usuario findByNombreUsuarioAndPassword(String nombreUsuario, String password);
}
