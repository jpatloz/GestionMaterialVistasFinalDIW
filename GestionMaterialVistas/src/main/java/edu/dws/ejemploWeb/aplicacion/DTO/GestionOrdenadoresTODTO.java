package edu.dws.ejemploWeb.aplicacion.DTO;

import edu.dws.ejemploWeb.aplicacion.dal.GestionOrdenadores;

/*
 * Clase que usaremos para recoger los datos del ordenador que
 * queremos
 * @author Jmenabc
 */
public class GestionOrdenadoresTODTO {

	public static GestionOrdenadoresDTO gestionOrdenadoresTODTO(GestionOrdenadores gestionOrdenadores) {
		GestionOrdenadoresDTO gestionOrdenadoresDTO = new GestionOrdenadoresDTO(gestionOrdenadores.getId_ordenador(),
				gestionOrdenadores.getMd_date(), gestionOrdenadores.getModelo(), gestionOrdenadores.getMarca());
		return gestionOrdenadoresDTO;
	}

}
