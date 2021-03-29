/*
* Autor:Christian Felipe de Jesus Avila Valdes
* Versión: 1.0
* Fecha Creación: 22 - mar - 2021
* Descripción:
* Clase Utilizada como punto de entrada de la aplicación.
*/
package sample;

import Entities.Estudiante;
import Enumerations.EstadoEstudiante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Database.EstudianteDAO;

public class Main extends Application {

    @Override
    public void start( Stage primaryStage ) throws Exception{
        Parent root = FXMLLoader.load( getClass().getResource("../Resources/LoginScreen.fxml") );
        primaryStage.setTitle( "" );
        primaryStage.setScene( new Scene( root, 300, 400 ) );
        primaryStage.show();
    }


    public static void main( String[] args ) {
        EstudianteDAO estudiantes = new EstudianteDAO();
        estudiantes.Create( new Estudiante( 12, "Christian", "Avila Valdes", "Avival", "123456789", "avival@gmail.com",
                "2288446633", "S18012142", "23145", EstadoEstudiante.RegistroPendiente ) );
        launch( args );
    }
}
