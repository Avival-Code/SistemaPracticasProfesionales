/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 27 - mar - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para la entidad ArchivoConsulta.
 */
package Database;

import Entities.ArchivoConsulta;

import java.util.List;

public interface ArchivosConsultaDAOInterface {
    boolean Create( ArchivoConsulta archivo );
    List< ArchivoConsulta > ReadAll();
    ArchivoConsulta Read( int idArchivo );
    boolean Update( ArchivoConsulta archivo );
    boolean Delete( int idArchivo );
}
