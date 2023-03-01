package edu.dws.ejemploWeb.aplicacion.DTO;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

	@Component
	public class GestionAlumnosDTO {
		
		//ATRIBUTOS
		private long id_alumno;
		private Calendar md_date;
		private String nombre_alumno;
		private String apellidos_alumno;
		private String num_telefono;
		private long id_ordenador;
		GestionOrdenadores ordenadores;
		
		
		//CONSTRUCTORES
		
		//Constructor vacío
		
		public GestionAlumnosDTO() {
			super();
		}
		
		//Constructor para los alumnos
		
		public GestionAlumnosDTO(long id_alumno, Calendar md_date, String nombre_alumno,
				String apellidos_alumno, String num_telefono, GestionOrdenadores ordenadores) {
			super();
			this.id_alumno = id_alumno;
			this.md_date = md_date;
			this.nombre_alumno = nombre_alumno;
			this.apellidos_alumno = apellidos_alumno;
			this.num_telefono = num_telefono;
			this.ordenadores = ordenadores;
		}
		
		//GETTERS Y SETTERS
		
		public long getId_alumno() {
			return id_alumno;
		}

		public void setId_alumno(long id_alumno) {
			this.id_alumno = id_alumno;
		}
		
		public Calendar getMd_date() {
			return md_date;
		}

		public void setMd_date(Calendar md_date) {
			this.md_date = md_date;
		}
		public String getNombre_alumno() {
			return nombre_alumno;
		}
		public void setNombre_alumno(String nombre_alumno) {
			this.nombre_alumno = nombre_alumno;
		}
		public String getApellidos_alumno() {
			return apellidos_alumno;
		}
		public void setApellidos_alumno(String apellidos_alumno) {
			this.apellidos_alumno = apellidos_alumno;
		}
		public String getNum_telefono() {
			return num_telefono;
		}
		public void setNum_telefono(String num_telefono) {
			this.num_telefono = num_telefono;
		}
		
		public long getId_ordenador() {
			return id_ordenador;
		}

		public void setId_ordenador(long id_ordenador) {
			this.id_ordenador = id_ordenador;
		}
		
		public GestionOrdenadores getOrdenadores() {
			return ordenadores;
		}
		public void setOrdenadores(GestionOrdenadores ordenadores) {
			this.ordenadores = ordenadores;
		}
		
		//TOSTRING
		
		@Override
		public String toString() {
			return "Alumno: " + "md_date=" + md_date + ", nombre_alumno=" + nombre_alumno 
					+ ", apellidos_alumno=" + apellidos_alumno+ ", num_telefono=" + num_telefono + 
					", ordenadores=" + ordenadores + "]";
		}
}