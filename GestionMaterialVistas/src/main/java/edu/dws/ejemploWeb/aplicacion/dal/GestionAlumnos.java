package edu.dws.ejemploWeb.aplicacion.dal;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //Se indica que es una entidad para que se construya en la base de datos
@Table(name = "alu_tch_gestion", schema = "dlk_gmt_alu_ord")
public class GestionAlumnos {

	// ATRIBUTOS

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno", unique = true, nullable = false)
	private long id_alumno;
	@Column(name = "md_uuid", nullable = false)
	private String md_uuid;
	@Column(name = "md_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar md_date;
	@Column(name = "nombre_alumno", nullable = false)
	private String nombre_alumno;
	@Column(name = "apellidos_alumno", nullable = false)
	private String apellidos_alumno;
	@Column(name = "num_telefono", nullable = false)
	private String num_telefono;
	@OneToOne
	GestionOrdenadores ordenadores;

	// GETTERS Y SETTERS

	public long getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(long id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getMd_uuid() {
		return md_uuid;
	}

	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
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

	public GestionOrdenadores getOrdenadores() {
		return ordenadores;
	}

	public void setOrdenadores(GestionOrdenadores ordenadores) {
		this.ordenadores = ordenadores;
	}

	// TOSTRING

	@Override
	public String toString() {
		return "GestionAlumnos [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime() + ", nombre_alumno="
				+ nombre_alumno + ", apellidos_alumno=" + apellidos_alumno + ", num_telefono=" + num_telefono
				+ ", ordenadores=" + ordenadores + "]";
	}
}
