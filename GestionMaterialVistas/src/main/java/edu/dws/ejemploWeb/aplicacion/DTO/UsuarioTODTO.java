package edu.dws.ejemploWeb.aplicacion.DTO;

import edu.dws.ejemploWeb.aplicacion.dal.Usuario;

public class UsuarioTODTO {

	public static UsuarioDTO usuarioTODTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getApellidos(),
				usuario.getEmail() ,usuario.getNombreUsuario(), usuario.getPassword(), usuario.getRol());
		return usuarioDTO;
	}
}
