/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 28 - mar - 2021
 * Descripción:
 * Data Access Object para la registrar, eliminar y obtener
 * proyectos seleccionados por Estudiantes.
 */
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object para la registrar, eliminar y obtener
 * proyectos seleccionados por Estudiantes.
 */
public class ProyectosSeleccionadosDAO implements ProyectosSeleccionadosDAOInterface{

    /**
     * Registra los proyectos seleccionados por un Estudiante en la base
     * de datos.
     * @param Matricula la matrícula del Estudiante
     * @param idProyectos la lista de proyectos seleccionados por el Estudiante
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Create( String Matricula, List< Integer > idProyectos ) {
        boolean wasCreated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        for( int i = 0; i < idProyectos.size(); i++ ) {
            try {
                String query = "INSERT INTO ProyectosSeleccionados( Matricula, IDProyecto ) " +
                        "VALUES ( ?, ? );";
                PreparedStatement statement = connection.GetConnection().prepareStatement( query );
                statement.setString( 1, Matricula );
                statement.setInt( 2, idProyectos.get( i ) );
                statement.executeUpdate();
                wasCreated = true;
            } catch( Exception exception ) {
                exception.printStackTrace();
            }
        }
        connection.StartConnection();
        return wasCreated;
    }

    /**
     * Regresa una lista con todos los IDProyectos asociados a una matrícula
     * @param Matricula la matrícula del estudiante
     * @returnuna lista de IDProyectos
     */
    @Override
    public List< Integer > Read( String Matricula ) {
        List< Integer > proyectos = new ArrayList<>();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "SELECT * FROM ProyectosSeleccionados WHERE Matricula = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.executeUpdate();
            ResultSet result = statement.getResultSet();

            while( result.next() ) {
                proyectos.add( result.getInt( 1 ) );
            }

            result.close();
            statement.close();
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return proyectos;
    }

    /**
     * Elimina los proyectos seleccionados asociados a la matrícula introducida
     * @param Matricula la matrícula de un estudiante
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Delete( String Matricula ) {
        boolean deleted = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "DELETE FROM ProyectosSeleccionados WHERE Matricula = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, Matricula );
            statement.executeUpdate();
            deleted = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return deleted;
    }
}