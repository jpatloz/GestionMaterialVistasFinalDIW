package edu.dws.ejemploWeb.aplicacion.DTO;

import javax.persistence.Column;

public class UsuarioDTO {
	
	//ATRIBUTOS
	
	private long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String nombreUsuario;
	private String password;
	private long rol;
	
	//CONSTRUCTORES
	
	public UsuarioDTO(long id, String nombre, String apellidos, String email, String nombreUsuario, String password, long rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
	}
	
	public UsuarioDTO(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public UsuarioDTO() {
		super();
	}

	//GETTERS Y SETTERS
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getRol() {
		return rol;
	}
	public void setRol(long rol) {
		this.rol = rol;
	}
	
	
}
