package edu.dws.ejemploWeb.aplicacion.DTO;

import java.util.ArrayList;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;

/*
 * Clase que usaremos para recoger los datos de alumno y
 * de la lista que contiene todos los alumnos con los datos que queremos
 * @author Jmenabc
 */
public class GestionAlumnosTODTO {

	public static GestionAlumnosDTO gestionAlumnosTODTO(GestionAlumnos gestionALumnos) {
		GestionAlumnosDTO gestionALumnosDTO = new GestionAlumnosDTO(gestionALumnos.getId_alumno(),
				gestionALumnos.getMd_date(),gestionALumnos.getNombre_alumno(), gestionALumnos.getApellidos_alumno(),
				gestionALumnos.getNum_telefono(),gestionALumnos.getOrdenadores());
		return gestionALumnosDTO;
	}

	public static ArrayList<GestionAlumnosDTO> listaGestionAlumnosDTO(ArrayList<GestionAlumnos> gestionALumnos) {
		ArrayList<GestionAlumnosDTO> listaAlumnos = new ArrayList<GestionAlumnosDTO>();
		for (GestionAlumnos gestionALum : gestionALumnos) {
			listaAlumnos.add(gestionAlumnosTODTO(gestionALum));
		}
		return listaAlumnos;
	}

}
