package Database;

import Entities.Proyecto;

import java.util.List;

public interface ProyectoDAOInterface {
    boolean Create( Proyecto usuario );
    List< Proyecto > ReadAll();
    Proyecto Read( String idProyecto );
    boolean Update( Proyecto usuario );
    boolean Delete( String idProyecto );
}
