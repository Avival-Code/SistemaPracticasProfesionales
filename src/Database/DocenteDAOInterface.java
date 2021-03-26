/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 26 - mar - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para la entidad Docente.
 */
package Database;

import Entities.Docente;
import java.util.List;

public interface DocenteDAOInterface {
    boolean Create( Docente docente );
    List< Docente > ReadAll();
    Docente Read( String numeroPersonal );
    boolean Update( Docente docente );
    boolean Delete( String numeroPersonal );
}
