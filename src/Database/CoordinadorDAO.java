/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Data Access Object para la entidad Coordinador. Se
 * encarga de realizar varias funciones relacionadas con Coordinadores
 * en la base de datos.
 */
package Database;

import Entities.Coordinador;
import java.util.List;

public class CoordinadorDAO implements CoordinadorDAOInterface{
    private UsuarioUVDAO usuarios = new UsuarioUVDAO();

    @Override
    public boolean Create(Coordinador coordinador) {
        return false;
    }

    @Override
    public List<Coordinador> ReadAll() {
        return null;
    }

    @Override
    public Coordinador Read(String numeroPersonal) {
        return null;
    }

    @Override
    public boolean Update(Coordinador coordinador) {
        return false;
    }

    @Override
    public boolean Delete(String numeroPersonal) {
        return false;
    }
}
