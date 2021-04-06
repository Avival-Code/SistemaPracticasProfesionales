package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Principal_Coordinador implements Initializable {
    @FXML
    private Label lbNombres;

    @FXML
    private Label lbApellidos;

    @FXML
    private Label lbNoTrabajador;

    @FXML
    private Button btnRegresar;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfDescripcion;

    @FXML
    private TextField tfEstudiantesRequeridos;

    @FXML
    private DatePicker dpFechaRegistro;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnContinuar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}