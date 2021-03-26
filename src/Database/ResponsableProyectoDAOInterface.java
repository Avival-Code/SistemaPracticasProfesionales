package Database;

import Entities.ResponsableProyecto;
import java.util.List;

public interface ResponsableProyectoDAOInterface {
    boolean Create(ResponsableProyecto responsable );
    List< ResponsableProyecto > ReadAll();
    ResponsableProyecto Read( String idResponsable );
    boolean Update( ResponsableProyecto responsable );
    boolean Delete( String idResponsable );
}
