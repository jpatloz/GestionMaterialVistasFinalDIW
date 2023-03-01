package edu.dws.ejemploWeb.aplicacion.DTO;

import java.util.ArrayList;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;

/*
 * Clase que usaremos para recoger los datos de alumno y de la lista que contiene todos los alumnos para usarlo en el controlador
 */

public class GestionAlumnosTODTO {

	public static GestionAlumnosDTO gestionAlumnosTODTO(GestionAlumnos gestionAlumnos) {
		GestionAlumnosDTO gestionAlumnosDTO = new GestionAlumnosDTO(gestionAlumnos.getId_alumno(),
				gestionAlumnos.getMd_date(), gestionAlumnos.getNombre_alumno(), gestionAlumnos.getApellidos_alumno(),
				gestionAlumnos.getNum_telefono(), gestionAlumnos.getOrdenadores());
		return gestionAlumnosDTO;
	}

	public static ArrayList<GestionAlumnosDTO> listaGestionAlumnosDTO(ArrayList<GestionAlumnos> gestionALumnos) {
		ArrayList<GestionAlumnosDTO> listaAlumnos = new ArrayList<GestionAlumnosDTO>();
		for (GestionAlumnos gestionALum : gestionALumnos) {
			listaAlumnos.add(gestionAlumnosTODTO(gestionALum));
		}
		return listaAlumnos;
	}

}
