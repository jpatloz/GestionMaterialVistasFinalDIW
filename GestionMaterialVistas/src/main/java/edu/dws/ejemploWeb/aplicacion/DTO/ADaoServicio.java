package edu.dws.ejemploWeb.aplicacion.DTO;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

/*
 * Interfaz que contiene los metodos para pasar de DTO a DAO
*/

public interface ADaoServicio {

	public GestionAlumnos GestionAlumnosDTOADAO(GestionAlumnosDTO gestionAlumnosDTO);

	public GestionOrdenadores GestionOrdenadoresDTOADAO(GestionOrdenadoresDTO gestionOrdenadoresDTO);
}
