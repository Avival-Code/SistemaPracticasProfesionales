package Controllers;

import Enumerations.TipoSector;
import Entities.OrganizacionVinculada;
import Utilities.OutputMessages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarOrganizacion_Coordinador implements Initializable {
    private OrganizacionVinculada organizacionVinculada = new OrganizacionVinculada();
    private OutputMessages outputMessages = new OutputMessages();

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
    private TextField tfDireccion;

    @FXML
    private TextField tfCorreoElectronico;

    @FXML
    private TextField tfTelefono;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Text errorText;

    @FXML
    private Text successText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
        DatosRegistro();
        RegistrarOrganizacion();
         */
    }

    /**
     * Intenta crear un Estudiante en la base de datos y coloca
     * el mensaje correspondiente en caso de éxito o fracaso.
     */
    /*
    private void RegistrarOrganizacion() {
        if( organizacionVinculada.Create (new OrganizacionVinculada()) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistroExitoso() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }

    private OrganizacionVinculada DatosRegistro(){
        return new OrganizacionVinculada ( tfNombre.getText(), tfDireccion.getText(), TipoSector.Publico,
                tfCorreoElectronico.getText(), tfTelefono.getText() );
    }

   */
}