package edu.dws.ejemploWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Interfaz que contiene la implementación de CrudRepository
 */

@Repository
public interface GestionAlumnosServicios extends CrudRepository<GestionAlumnos, Long>{

}
