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

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements EstudianteDAOInterface{
    private UsuarioUVDAO usuarios = new UsuarioUVDAO();

    @Override
    public boolean Create( Estudiante estudiante ) {
        boolean wasCreated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            usuarios.Create( new UsuarioUV( estudiante.GetID(), estudiante.GetNombres(), estudiante.GetApellidos(),
                                            estudiante.GetUsuario(), estudiante.GetContrasena(), estudiante.GetCorreo(),
                                            estudiante.GetTelefono() ) );
            Statement statement = connection.GetConnection().createStatement();
            String query = "INSERT INTO Estudiante( Matricula, IDUsuario, NRC, Estado ) VALUES( '" +
                           estudiante.GetMatricula() + "', '" + estudiante.GetID() + "', '" +
                           estudiante.GetNrc() + "', " + estudiante.GetEstado() + " );";

            wasCreated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }
        return wasCreated;
    }

    @Override
    public List< Estudiante > ReadAll() {
        List< Estudiante > estudiantes = new ArrayList<>();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Statement statement = connection.GetConnection().createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM Estudiantes;" );
            List< UsuarioUV > usuariosTemp = usuarios.ReadAll();

            for( int i = 0; i < usuariosTemp.size(); i++ )
            {
                result.next();
                estudiantes.add( new Estudiante( usuariosTemp.get( i ), result.getString( 0 ), result.getString( 2 ),
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

    @Override
    public Estudiante Read( String matricula ) {
        Estudiante estudiante = new Estudiante();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Statement statement = connection.GetConnection().createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM Estudiante WHERE matricula = '" + matricula + "';" );

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

    @Override
    public boolean Update( Estudiante estudiante ) {
        boolean updated = false;
        return false;
    }

    @Override
    public boolean Delete( String matricula ) {
        return false;
    }
}
