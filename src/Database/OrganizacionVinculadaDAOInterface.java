package Database;

import Entities.OrganizacionVinculada;

import java.util.List;

public interface OrganizacionVinculadaDAOInterface {
    boolean Create( OrganizacionVinculada organizacion );
    List< OrganizacionVinculada > ReadAll();
    OrganizacionVinculada Read( int idProyecto );
    boolean Update( OrganizacionVinculada organizacion );
    boolean Delete( int idProyecto );
}
