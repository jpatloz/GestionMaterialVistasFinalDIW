package edu.dws.ejemploWeb.aplicacion.DTO;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

/*
 * Clase que implementa los metodos de nuestra interfaz aDao 
 */

public class ADaoServicioImpl implements ADaoServicio {

	public GestionAlumnos GestionAlumnosDTOADAO(GestionAlumnosDTO gestionAlumnosDTO) {
		GestionAlumnos gestionAlumnos = new GestionAlumnos();
		if (gestionAlumnosDTO != null) {
			gestionAlumnos.setId_alumno(gestionAlumnosDTO.getId_alumno());
			gestionAlumnos.setNombre_alumno(gestionAlumnosDTO.getNombre_alumno());
			gestionAlumnos.setApellidos_alumno(gestionAlumnosDTO.getApellidos_alumno());
			gestionAlumnos.setNum_telefono(gestionAlumnosDTO.getNum_telefono());
			gestionAlumnos.setOrdenadores(gestionAlumnosDTO.getOrdenadores());
		}
		return gestionAlumnos;
	}

	public GestionOrdenadores GestionOrdenadoresDTOADAO(GestionOrdenadoresDTO gestionOrdenadoresDTO) {
		GestionOrdenadores gestionOrdenadores = new GestionOrdenadores();
		if (gestionOrdenadoresDTO != null) {
			gestionOrdenadores.setId_ordenador(gestionOrdenadoresDTO.getId_ordenador());
			gestionOrdenadores.setMd_date(gestionOrdenadoresDTO.getMd_date());
			gestionOrdenadores.setMarca(gestionOrdenadoresDTO.getMarca());
			;
			gestionOrdenadores.setModelo(gestionOrdenadoresDTO.getModelo());
		}
		return gestionOrdenadores;
	}

}
