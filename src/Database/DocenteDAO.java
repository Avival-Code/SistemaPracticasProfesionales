/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Data Access Object para la entidad Docente. Se
 * encarga de realizar varias funciones relacionadas con Docentes
 * en la base de datos.
 */
package Database;

import Entities.Docente;
import Entities.Estudiante;
import Entities.UsuarioUV;
import Enumerations.EstadoEstudiante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object para la entidad Docente. Se
 * encarga de realizar varias funciones relacionadas con Docentes
 * en la base de datos.
 */
public class DocenteDAO  implements DocenteDAOInterface{
    private UsuarioUVDAO usuarios = new UsuarioUVDAO();

    /**
     * Crea un docente en la base de datos.
     * @param docente el docente que se desea crear
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Create( Docente docente ) {
        boolean wasCreated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            usuarios.Create( new UsuarioUV( docente.GetID(), docente.GetNombres(), docente.GetApellidos(),
                    docente.GetUsuario(), docente.GetContrasena(), docente.GetCorreo(),
                    docente.GetTelefono() ) );
            String query = "INSERT INTO Docente( NumeroPersonal, IDUsuario, NRC ) VALUES( ?, ?, ? );";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, docente.GetNumeroPersonal() );
            statement.setInt( 2, docente.GetID() );
            statement.setString( 3, docente.GetNrc() );
            statement.executeQuery();

            wasCreated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
        return wasCreated;
    }

    /**
     * Regresa una lista con todos los docentes en la base de datos
     * @return una lista de docentes
     */
    @Override
    public List< Docente > ReadAll() {
        List< Docente > docentes = new ArrayList<>();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Statement statement = connection.GetConnection().createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM Estudiantes;" );
            List< UsuarioUV > usuariosTemp = usuarios.ReadAll();

            while( result.next() )
            {
                UsuarioUV usuarioTemp = usuarios.Read( Integer.toString( result.getInt( 1 ) ) );
                docentes.add( new Docente( usuarioTemp, result.getString( 0 ), result.getString( 2 ) ) );
            }

            result.close();
            statement.close();
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return docentes;
    }

    /**
     * Regresa un docente de la base de datos. Utiliza el numero de personal
     * introducido para la búsqueda.
     * @param numeroPersonal el número de personal del docente deseado
     * @return la instancia del docente
     */
    @Override
    public Docente Read( String numeroPersonal ) {
        Docente docente = new Docente();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "SELECT * FROM Docente WHERE NumeroPersonal = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1,  numeroPersonal );
            statement.executeQuery();
            ResultSet result = statement.getResultSet();

            if( result.next() ) {
                int idUsuario = result.getInt( 1 );
                String nrc = result.getString( 2 );

                UsuarioUV usuario = usuarios.Read( Integer.toString( idUsuario ) );
                docente = new Docente( usuario, numeroPersonal, nrc );
            }
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return docente;
    }

    /**
     * Actualiza la información de un un docente en la base de datos
     * @param docente el docente con su información actualizada
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Update( Docente docente ) {
        boolean updated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "UPDATE Docente SET NRC = ? WHERE NumeroPersonal = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, docente.GetNrc() );
            statement.setString( 2, docente.GetNumeroPersonal() );
            statement.executeQuery();

            usuarios.Update( new UsuarioUV( docente.GetID(), docente.GetNombres(), docente.GetApellidos(),
                    docente.GetUsuario(), docente.GetContrasena(), docente.GetCorreo(), docente.GetTelefono() ) );

            updated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return updated;
    }

    /**
     * Elimina un docente de la base de datos utilizando el numero personal introducido
     * @param numeroPersonal el numero personal del docente que se desea eliminar
     * @return booleano indicando éxito o fracaso
     */
    @Override
    public boolean Delete(String numeroPersonal) {
        boolean deleted = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Docente docente = Read( numeroPersonal );
            String query = "DELETE FROM Docente WHERE NumeroPersonal = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1,  numeroPersonal );
            statement.executeQuery();
            usuarios.Delete( Integer.toString( docente.GetID() ) );

            deleted = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return deleted;
    }
}