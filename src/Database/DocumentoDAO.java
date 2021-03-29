/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 28 - mar - 2021
 * Descripción:
 * Data Access Object para la entidad Documento. Se
 * encarga de realizar varias funciones relacionadas con Documento
 * en la base de datos.
 */
package Database;

import Entities.Documento;

import java.util.List;

public class DocumentoDAO implements DocumentoDAOInterface {
    @Override
    public boolean Create(Documento documento) {
        return false;
    }

    @Override
    public List<Documento> ReadAll() {
        return null;
    }

    @Override
    public Documento Read(String idDocumento) {
        return null;
    }

    @Override
    public boolean Update(Documento documento) {
        return false;
    }

    @Override
    public boolean Delete(String idDocumento) {
        return false;
    }
}
