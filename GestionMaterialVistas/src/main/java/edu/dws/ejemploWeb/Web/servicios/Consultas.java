package edu.dws.ejemploWeb.Web.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosDTO;
import edu.dws.ejemploWeb.aplicacion.DTO.GestionAlumnosTODTO;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;
import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnosServicios;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;
import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadoresServicios;
import edu.dws.ejemploWeb.aplicacion.dal.Usuario;
import edu.dws.ejemploWeb.aplicacion.dal.UsuarioServicios;


@Service
public class Consultas{
	
		//Invocamos los servicios para inyectarlos en las consultas
		@Autowired
		GestionAlumnosServicios gas;
		@Autowired
		GestionOrdenadoresServicios gos;
	
		GestionAlumnosTODTO aDto = new GestionAlumnosTODTO();
		
		//CONSULTAS DE GESTIÓN ALUMNOS
	
		//Consulta para insertar un alumno con su ordenador asignado
		
		public void insertarUnaMatricula(GestionAlumnos gestionAlumnos) {
			try {
				gas.save(gestionAlumnos);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		//Consulta para coger el ordenador por id 
		
		public GestionOrdenadores buscarOrdenadorPorId(long id) {
			try {
			GestionOrdenadores gestionOrdenadores = gos.findById(id).get(); //Se usa el get para coger el objeto ordenador
			return gestionOrdenadores;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
	
		// Consulta para buscar todos los alumnos
	
		public List<GestionAlumnosDTO> buscarAlumnos() {
			try {
			ArrayList<GestionAlumnos> listaGestionALumnos = (ArrayList<GestionAlumnos>) gas.findAll();
			ArrayList<GestionAlumnosDTO> listaGestionAlumnosDTO = aDto.listaGestionAlumnosDTO(listaGestionALumnos);
			return listaGestionAlumnosDTO;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
	    }
		
		//Consulta para eliminar a un alumno
		
		public void eliminarUnAlumno(long id) {
			try {
			gas.deleteById(id);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		//Consulta para buscar un alumno por id de ordenador
		
		public GestionAlumnos buscarAlumnoPorIdOrdenador(long idOrd) {
			try {
			GestionOrdenadores ordenadores = gos.findById(idOrd).get();
			GestionAlumnos alumno = ordenadores.getAlumno();
			return alumno;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		//CONSULTAS DE GESTIÓN ORDENADORES
		
		//Consulta para buscar un ordenador por id de alumno
		
		public GestionOrdenadores buscarOrdenadorPorIdAlumno(long id) {
			try {
			GestionAlumnos alumnos = gas.findById(id).get();
			GestionOrdenadores ordenadores = alumnos.getOrdenadores();
			return ordenadores;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}

		//Consulta para insertar un ordenador
		
		public void insertarUnOrdenador(GestionOrdenadores gestionOrdenadores) {
			try {
			gos.save(gestionOrdenadores);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
}
