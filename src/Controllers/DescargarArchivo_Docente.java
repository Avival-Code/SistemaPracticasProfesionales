package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class DescargarArchivo_Docente implements Initializable {
    @FXML
    Label lbNombre;
    @FXML
    Label lbApellidos;
    @FXML
    Label lbCedulaProfesional;
    @FXML
    Label lbNombreEstudiante;
    @FXML
    TableView tbvArchivosSubidos;
    @FXML
    TableColumn tcNombreArchivo;
    @FXML
    TableColumn tcDescripcion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
