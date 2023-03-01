package edu.dws.ejemploWeb.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestionAlumnosServicios extends CrudRepository<GestionAlumnos, Long>{

}
