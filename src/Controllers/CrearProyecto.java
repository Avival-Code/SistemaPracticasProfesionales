/*
 * Autor: Alan AdaiR Morgado Morales
 * Versión: 1.0
 * Fecha Creación: 03 - abril - 2021
 * Descripción:
 * Clase que se encarga de manejar las acciones de la pantalla
 * CrearProyecto del sistema de prácticas profesionales.
 */

package Controllers;

import Enumerations.EstadoProyecto;
import Database.ProyectoDAO;
import Entities.Proyecto;
import Database.ResponsableProyectoDAO;
import Entities.ResponsableProyecto;
import Utilities.InputValidator;
import Utilities.OutputMessages;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.time.LocalDate;


public class CrearProyecto {
    //private ScreenChanger screenChanger = new ScreenChanger();
    private InputValidator inputValidator = new InputValidator();
    private OutputMessages outputMessages = new OutputMessages();
    private ProyectoDAO proyecto = new ProyectoDAO();
    private ResponsableProyectoDAO responsableProyecto = new ResponsableProyectoDAO();

    @FXML
    Label lbNombre;

    @FXML
    Label lbApellidos;

    @FXML
    Label lbNumeroPersonal;

    @FXML
    Text successText;

    @FXML
    Text errorText;

    @FXML
    private TextField nombreProyectoField;

    @FXML
    private TextField descripcionProyectoField;

    @FXML
    private TextField estudiantesRequeridosField;

    @FXML
    private TextField nombresResponsableField;

    @FXML
    private TextField apellidosResponsableField;

    @FXML
    private  TextField telefonoResponsableField;

    @FXML
    private TextField correoResponsableField;

    @FXML
    private Button registerButton;

    @FXML
    private Button returnButton;


    /**
     * Realiza el registro de un nuevo ResponsableProyecto en la base de datos.
     */
    public void HandleProjectRegistration(MouseEvent mouseEvent) {
        CheckProjectFields();
        CheckResponsableProjectFields();
        if( inputValidator.IsProjectInformationValid(GetProyecto()) && inputValidator.IsResponsableProjectInformationValid( GetResponsableProyecto()))  {
            RegisterNewResponsableProject();
            RegisterNewProject();
        }
    }

    /**
     * Intenta crear un ResponsableProyecto en la base de datos y coloca
     * el mensaje correspondiente en caso de éxito o fracaso.
     */
    private void RegisterNewResponsableProject() {
        if( responsableProyecto.Create( GetResponsableProyecto() ) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistrationSuccessfull() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }

    /**
     * Intenta crear un Proyecto en la base de datos y coloca
     * el mensaje correspondiente n caso de éxito o fracaso.
     */
    private void RegisterNewProject() {
        if( proyecto.Create( GetProyecto() ) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistrationSuccessfull() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }

    /**
     * Comprueba que los campos de registro de Proyecto tengan informacion y coloca
     * el mensaje correspondiente en caso de fracaso.
     */
    private void CheckProjectFields() {
        if(nombreProyectoField.getText() != "" && descripcionProyectoField.getText() != "" && estudiantesRequeridosField.getText() != "" ){
            CheckProjectInput();
        }else{
            errorText.setText(outputMessages.EmptyFields());
            successText.setText("");
        }
    }

    /**
     * Comprueba que los campos de registro del ResponsableProyecto tengan informacion y coloca
     * el mensaje correspondiente en caso de fracaso.
     */
    private void CheckResponsableProjectFields() {
        if(nombresResponsableField.getText() != "" && apellidosResponsableField.getText() != "" && telefonoResponsableField.getText() != "" && correoResponsableField.getText() != "" ){
            CheckResponsableInput();
        }else{
            errorText.setText(outputMessages.EmptyFields());
            successText.setText("");
        }
    }

    /**
     * Revisa que toda la información introducida del proyecto
     * sea valida.
     */
    private void CheckProjectInput() {
        CheckNames();
        CheckRequiredStudents();
    }

    /**
     * Revisa que toda la información introducida del reponsable proyecto
     * sea valida.
     */
    private void CheckResponsableInput() {
        CheckNames();
        CheckLastNames();
        CheckTelephone();
        CheckEmail();
    }

    /**
     * Revisa que el numero estudiantes requeridos es valido
     */
    private void CheckRequiredStudents() {
        if( !inputValidator.RequiredNumberValid( estudiantesRequeridosField.getText() ) ) {
            errorText.setText(outputMessages.InvalidFields());
            successText.setText("");
        }
    }

    /**
     * Revisa que los nombres introducidos sean validos.
     */
    private void CheckNames() {
        if( !inputValidator.AreNamesValid( nombresResponsableField.getText() ) ) {
            errorText.setText( outputMessages.InvalidNames() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que los apellidos introducidos sean validos.
     */
    private void CheckLastNames() {
        if( !inputValidator.AreLastNamesValid( apellidosResponsableField.getText() ) ) {
            errorText.setText( outputMessages.InvalidLastNames() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el teléfono introducido sea valido.
     */
    private void CheckTelephone() {
        if( !inputValidator.IsTelephoneValid( telefonoResponsableField.getText() ) ) {
            errorText.setText( outputMessages.InvalidTelephone() );
            successText.setText( "" );
        }
    }

    /**
     * Revisa que el correo electrónico introducido sea valido.
     */
    private void CheckEmail() {
        if( !inputValidator.IsEmailValid( correoResponsableField.getText() ) ) {
            errorText.setText( outputMessages.InvalidEmail() );
            successText.setText( "" );
        }
    }

    /**
     * Crea una instancia de Proyecto utilizando la información
     * introducida por el usuario en todos los campos de texto.
     * @return una instancia de Proyecto
     */
    private Proyecto GetProyecto() {
        String numeroEstudiantesRequeridos = estudiantesRequeridosField.getText();
        int estudiantesRequeridos = Integer.parseInt(numeroEstudiantesRequeridos);
        LocalDate currentDate = LocalDate.now();
        return new Proyecto( 0, nombreProyectoField.getText(), descripcionProyectoField.getText(), estudiantesRequeridos, 0,
                currentDate.toString(), EstadoProyecto.Disponible);
    }

    /**
     * Crea una instancia del ResponsableProyecto utilizando la información
     * introducida por el usuario en todos los campos de texto.
     * @return una instancia de ResponsableProyecto
     */
    private ResponsableProyecto GetResponsableProyecto() {
        return new ResponsableProyecto( 0, nombresResponsableField.getText(), apellidosResponsableField.getText(),
                telefonoResponsableField.getText(), correoResponsableField.getText());
    }

}
