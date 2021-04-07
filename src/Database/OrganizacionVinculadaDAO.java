package Database;

import Entities.Estudiante;
import Entities.OrganizacionVinculada;
import Entities.UsuarioUV;
import Enumerations.EstadoEstudiante;
import Enumerations.TipoSector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrganizacionVinculadaDAO implements OrganizacionVinculadaDAOInterface{
    @Override
    public boolean Create( OrganizacionVinculada organizacion ) {
        boolean wasCreated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "INSERT INTO OrganizacionVinculada( IDResponsableProyecto, IDProyecto, Nombre, Direccion, " +
                    "Sector, Telefono, CorreoElectronico ) VALUES ( ?, ?, ?, ?, ?, ?, ? );";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setInt( 1, organizacion.getIdResponsable() );
            statement.setInt( 2, organizacion.getIdProyecto() );
            statement.setString( 3, organizacion.getNombre() );
            statement.setString( 4, organizacion.getDireccion() );
            statement.setInt( 5, organizacion.getSector().ordinal() );
            statement.setString( 6, organizacion.getTelefono() );
            statement.setString( 7, organizacion.getCorreo() );
            statement.executeUpdate();
            wasCreated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StartConnection();
        return wasCreated;
    }

    @Override
    public List< OrganizacionVinculada > ReadAll() {
        List< OrganizacionVinculada > organizaciones = new ArrayList<>();
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            Statement statement = connection.GetConnection().createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM OrganizacionVinculada;" );

            while( result.next() )
            {
                organizaciones.add( new OrganizacionVinculada( result.getString( 3 ),
                        result.getString( 4 ), TipoSector.values()[ result.getInt( 5 ) ],
                        result.getString( 6 ), result.getString( 7 ),
                        result.getInt( 1 ), result.getInt( 2 ) ) );
            }

            result.close();
            statement.close();
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return organizaciones;
    }

    @Override
    public OrganizacionVinculada Read( int idProyecto ) {
        OrganizacionVinculada organizacion = null;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "SELECT * FROM OrganizacionVinculada WHERE IDProyecto = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setInt( 1,  idProyecto );
            statement.executeQuery();
            ResultSet result = statement.getResultSet();

            if( result.next() ) {
                organizacion = new OrganizacionVinculada( result.getString( 3 ),
                        result.getString( 4 ), TipoSector.values()[ result.getInt( 5 ) ],
                        result.getString( 6 ), result.getString( 7 ),
                        result.getInt( 1 ), result.getInt( 2 ) );
            }
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return organizacion;
    }

    @Override
    public boolean Update( OrganizacionVinculada organizacion ) {
        boolean updated = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "UPDATE OrganizacionVinculada SET Nombre = ?, Direccion = ?, " +
                    "Sector = ?, Telefono = ?, CorreoElectronico = ? WHERE IDProyecto = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setString( 1, organizacion.getNombre() );
            statement.setString( 2, organizacion.getDireccion() );
            statement.setInt( 3, organizacion.getSector().ordinal() );
            statement.setString(  4, organizacion.getTelefono() );
            statement.setString( 5, organizacion.getCorreo() );
            statement.setInt( 6, organizacion.getIdProyecto() );
            statement.executeUpdate();

            updated = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return updated;
    }

    @Override
    public boolean Delete( int idProyecto ) {
        boolean deleted = false;
        MySqlConnection connection = new MySqlConnection();
        connection.StartConnection();

        try {
            String query = "DELETE FROM OrganizacionVinculada WHERE IDProyecto = ?;";
            PreparedStatement statement = connection.GetConnection().prepareStatement( query );
            statement.setInt( 1,  idProyecto );
            statement.executeUpdate();

            deleted = true;
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        connection.StopConnection();
        return deleted;
    }
}
