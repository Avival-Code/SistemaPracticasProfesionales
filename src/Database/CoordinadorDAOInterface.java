/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 26 - mar - 2021
 * Descripción:
 * Interfaz con los métodos necesarios para implementar
 * el patrón de Data Access Object para la entidad Coordinador.
 */
package Database;

import Entities.Coordinador;
import java.util.List;

public interface CoordinadorDAOInterface {
    boolean Create( Coordinador coordinador );
    List< Coordinador > ReadAll();
    Coordinador Read( String numeroPersonal );
    boolean Update( Coordinador coordinador );
    boolean Delete( String numeroPersonal );
}
