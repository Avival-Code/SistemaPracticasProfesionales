/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 27 - mar - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para la entidad InformeProblema.
 */
package Database;

import Entities.InformeProblema;

import java.util.List;

public interface InformeProblemaDAOInterface {
    boolean Create( InformeProblema informe );
    List< InformeProblema > ReadAll();
    InformeProblema Read( int identificador );
    boolean Update( InformeProblema informe );
    boolean Delete( int identificador );
}
