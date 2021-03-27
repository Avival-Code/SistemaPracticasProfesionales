/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 27 - mar - 2021
 * Descripción:
 * Data Access Object para la entidad InformeProblema. Se
 * encarga de realizar varias funciones relacionadas con InformeProblema
 * en la base de datos.
 */
package Database;

import Entities.InformeProblema;

import java.util.List;

public class InformeProblemaDAO implements InformeProblemaDAOInterface {
    @Override
    public boolean Create( InformeProblema informe ) {
        return false;
    }

    @Override
    public List<InformeProblema> ReadAll() {
        return null;
    }

    @Override
    public InformeProblema Read( int identificador ) {
        return null;
    }

    @Override
    public boolean Update( InformeProblema informe ) {
        return false;
    }

    @Override
    public boolean Delete( int identificador ) {
        return false;
    }
}
