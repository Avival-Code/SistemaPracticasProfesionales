package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GestionarOrganizacion_Coordinador implements Initializable {
    @FXML
    private Label lbNombres;

    @FXML
    private Label lbApellidos;

    @FXML
    private Label lbNoTrabajador;

    @FXML
    private Button btnGestionarOrganizaciones;

    @FXML
    private Button btnGestionarProyectos;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField tfBuscar;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView tbOrganizaciones;

    @FXML
    private TableColumn clnOrganizaciones;

    @FXML
    private Button btnConsultarOrganizacion;

    @FXML
    private Button btnRegistrarOrganizacion;

    @FXML
    private Button btnEliminarOrganizacion;

    @FXML
    private Button btnModificarOrganizacion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}