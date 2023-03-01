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
@Table(name= "ord_tch_gestion", schema= "dlk_gmt_alu_ord")
public class GestionOrdenadores {
	
	//ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ordenador", unique=true, nullable=false)
	private long id_ordenador;
	@Column(name="md_uuid",nullable=false)
	private String md_uuid;
	@Column(name="md_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar md_date;
	@Column(name="modelo",nullable=false)
	private String modelo;
	@Column(name="marca",nullable=false)
	private String marca;
	@OneToOne(mappedBy="ordenadores")
	GestionAlumnos alumno;
	
	//GETTERS Y SETTERS

	public long getId_ordenador() {
		return id_ordenador;
	}
	public void setId_ordenador(long id_ordenador) {
		this.id_ordenador = id_ordenador;
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
		return "GestionOrdenadores [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime()
				+ ", modelo=" + modelo + ", marca=" + marca + ", alumno=" + alumno + "]";
	}

}