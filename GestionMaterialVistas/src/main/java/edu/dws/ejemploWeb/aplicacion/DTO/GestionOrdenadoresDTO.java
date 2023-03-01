package edu.dws.ejemploWeb.aplicacion.DTO;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;

@Component
public class GestionOrdenadoresDTO {
	
	//ATRIBUTOS
	private long id_ordenador;
	private Calendar md_date;
	private String modelo;
	private String marca;
	GestionAlumnos alumno;
		
	//CONSTRUCTORES
		
	//Constructor vacío
		
	public GestionOrdenadoresDTO() {
	super();
	}
		
	//Constructor para los ordenadores
		
	public GestionOrdenadoresDTO(long id_ordenador, Calendar md_date, String modelo, String marca) {
		super();
		this.id_ordenador = id_ordenador;
		this.md_date = md_date;
		this.modelo = modelo;
		this.marca = marca;
	}
		
	//GETTERS Y SETTERS

	public long getId_ordenador() {
		return id_ordenador;
	}

	public void setId_ordenador(long id_ordenador) {
		this.id_ordenador = id_ordenador;
	}
	
	public Calendar getMd_date() {
		return md_date;
	}

	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public GestionAlumnos getAlumno() {
		return alumno;
	}
	public void setAlumno(GestionAlumnos alumno) {
		this.alumno = alumno;
	}
		
	//TOSTRING
		
	@Override
	public String toString() {
		return "Ordenador: " + "id_ordenador" + id_ordenador + "md_date=" + md_date + ", modelo=" + modelo + ", marca=" + marca 
				+ ", alumno=" + alumno + "]";
	}
	
}

