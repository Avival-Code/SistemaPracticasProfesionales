/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Data Access Object para la entidad Estudiante. Se
 * encarga de realizar varias funciones relacionadas con Estudiantes
 * en la base de datos.
 */
package Database;

import Entities.Estudiante;
import Entities.UsuarioUV;
import Enumerations.EstadoEstudiante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object para la entidad Estudiante. Se
 * encarga de realizar varias funciones relacionadas con Estudiantes
 * en la base de datos.
 */
public class EstudianteDAO implements EstudianteDAOInterface{
    private UsuarioUVDAO usuarios = new UsuarioUVDAO();

    /**
     * Crea un nuevo estudiante en la base de datos.
     * @param estudiante el Estudiante que se desea crear en la base de datos
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Create( Estudiante estudiante ) {
        boolean wasCreated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            usuarios.Create( new UsuarioUV( estudiante.GetID(), estudiante.GetNombres(), estudiante.GetApellidos(),
                                            estudiante.GetUsuario(), estudiante.GetContrasena(), estudiante.GetCorreo(),
                                            estudiante.GetTelefono() ) );
            String query = "INSERT INTO Estudiante( Matricula, IDUsuario, NRC, Estado ) VALUES( ?, ?, ?, ? );";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, estudiante.GetMatricula() );
            statement.setInt( 2, estudiante.GetID() );
            statement.setString( 3, estudiante.GetNrc() );
            statement.setInt( 4, estudiante.GetEstado().ordinal() );
            statement.executeQuery();

            wasCreated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
        return wasCreated;
    }

    /**
     * Regresa una lista con todos los estudiantes en la base de datos.
     * @return lista de estudiantes
     */
    @Override
    public List< Estudiante > ReadAll() {
        List< Estudiante > estudiantes = new ArrayList<>();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Statement statement = connection.GetConnection().createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM Estudiantes;" );
            List< UsuarioUV > usuariosTemp = usuarios.ReadAll();

            while( result.next() )
            {
                UsuarioUV usuarioTemp = usuarios.Read( Integer.toString( result.getInt( 1 ) ) );
                estudiantes.add( new Estudiante( usuarioTemp, result.getString( 0 ), result.getString( 2 ),
                                                 EstadoEstudiante.values()[ result.getInt( 3 ) ] ) );
            }

            result.close();
            statement.close();
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return estudiantes;
    }

    /**
     * Regresa un estudiante de la base de datos. Utiliza la matrícula
     * del estudiante para buscarlo en la base de datos.
     * @param matricula la matrícula del Estudiante deseado
     * @return estudiante con la información de base de datos.
     */
    @Override
    public Estudiante Read( String matricula ) {
        Estudiante estudiante = new Estudiante();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "SELECT * FROM Estudiante WHERE matricula = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1,  matricula );
            statement.executeQuery();
            ResultSet result = statement.getResultSet();

            if( result.next() ) {
                int idUsuario = result.getInt( 1 );
                String nrc = result.getString( 2 );
                EstadoEstudiante estado = EstadoEstudiante.values()[ result.getInt( 3 ) ];

                UsuarioUV usuario = usuarios.Read( Integer.toString( idUsuario ) );
                estudiante = new Estudiante( usuario, matricula, nrc, estado );
            }
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return estudiante;
    }

    /**
     * Actualiza la información de un estudiante en la base de datos.
     * @param estudiante la versión actualizada del Estudiante
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Update( Estudiante estudiante ) {
        boolean updated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "UPDATE Estudiante SET NRC = ?, estado = ? WHERE Matricula = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, estudiante.GetNrc() );
            statement.setInt( 2, estudiante.GetEstado().ordinal() );
            statement.setString( 3, estudiante.GetMatricula() );
            statement.executeQuery();

            usuarios.Update( new UsuarioUV( estudiante.GetID(), estudiante.GetNombres(), estudiante.GetApellidos(),
                                            estudiante.GetUsuario(), estudiante.GetContrasena(), estudiante.GetCorreo(),
                                            estudiante.GetTelefono() ) );

            updated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return updated;
    }

    /**
     *Elimina un estudiante de la base de datos utilizando la matrícula introducida.
     * @param matricula la matrícula del Estudiante que se desea eliminar
     * @return booleano indica éxito o fracaso
     */
    @Override
    public boolean Delete( String matricula ) {
        boolean deleted = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Estudiante estudiante = Read( matricula );
            String query = "DELETE FROM Estudiante WHERE Matricula = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1,  matricula );
            statement.executeQuery();
            usuarios.Delete( Integer.toString( estudiante.GetID() ) );

            deleted = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return deleted;
    }
}
