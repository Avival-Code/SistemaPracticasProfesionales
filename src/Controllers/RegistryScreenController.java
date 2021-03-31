package Controllers;

import Enumerations.EstadoEstudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Database.EstudianteDAO;
import Entities.Estudiante;
import Utilities.ScreenChanger;
import Utilities.InputValidator;
import Utilities.OutputMessages;

public class RegistryScreenController {
    private ScreenChanger screenChanger = new ScreenChanger();
    private InputValidator inputValidator = new InputValidator();
    private OutputMessages outputMessages = new OutputMessages();
    private EstudianteDAO estudiantes = new EstudianteDAO();

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField matriculaField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField nrcField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Text errorText;

    @FXML
    private Text successText;

    public void ShowLoginScreen( MouseEvent mouseEvent ) {
        screenChanger.showLoginScreen( mouseEvent, errorText );
    }

    public void HandleStudentRegistration() {
        CheckUserInput();
        if( inputValidator.IsStudentInformationValid( GetStudent(), confirmPasswordField.getText() ) ) {
            CheckIfStudentExistsAndRegister();
        }
    }

    private void CheckIfStudentExistsAndRegister() {
        if( estudiantes.Read( GetStudent().GetMatricula() ) == null ) {
            RegisterStudent();
        }
        else {
            errorText.setText( outputMessages.StudentAlreadyExists() );
            successText.setText( "" );
        }
    }

    private void RegisterStudent() {
        if( estudiantes.Create( GetStudent() ) ) {
            errorText.setText( "" );
            successText.setText( outputMessages.RegistrationSuccessfull() );
        }
        else {
            errorText.setText( outputMessages.DatabaseConnectionFailed() );
            successText.setText( "" );
        }
    }

    private void CheckUserInput() {
        DoPasswordsMatch();
        CheckPassword();
        CheckMatricula();
        CheckEmail();
        CheckTelephone();
        CheckNRC();
        CheckLastNames();
        CheckNames();
    }

    private void CheckNames() {
        if( !inputValidator.AreNamesValid( nameField.getText() ) ) {
            errorText.setText( outputMessages.InvalidNames() );
            successText.setText( "" );
        }
    }

    private void CheckLastNames() {
        if( !inputValidator.AreLastNamesValid( lastNameField.getText() ) ) {
            errorText.setText( outputMessages.InvalidLastNames() );
            successText.setText( "" );
        }
    }

    private void CheckNRC() {
        if( !inputValidator.IsNRCValid( nrcField.getText() ) ) {
            errorText.setText( outputMessages.InvalidNRC() );
            successText.setText( "" );
        }
    }

    private void CheckEmail() {
        if( !inputValidator.IsEmailValid( emailField.getText() ) ) {
            errorText.setText( outputMessages.InvalidEmail() );
            successText.setText( "" );
        }
    }

    private void CheckTelephone() {
        if( !inputValidator.IsTelephoneValid( phoneField.getText() ) ) {
            errorText.setText( outputMessages.InvalidTelephone() );
            successText.setText( "" );
        }
    }

    private void CheckMatricula() {
        if( !inputValidator.IsMatriculaValid( matriculaField.getText() ) ) {
            errorText.setText( outputMessages.InvalidMatricula() );
            successText.setText( "" );
        }
    }

    private void CheckPassword() {
        if( !inputValidator.IsPasswordValid( passwordField.getText() ) ) {
            errorText.setText( outputMessages.InvalidPassword() );
            successText.setText( "" );
        }
    }

    private void DoPasswordsMatch() {
        if( !inputValidator.DoPasswordsMatch( passwordField.getText(), confirmPasswordField.getText() ) ) {
            errorText.setText( outputMessages.PasswordsDontMatch() );
            successText.setText( "" );
        }
    }

    private Estudiante GetStudent() {
        return new Estudiante( 0, nameField.getText(), lastNameField.getText(), "", passwordField.getText(),
                emailField.getText(), phoneField.getText(), matriculaField.getText(), nrcField.getText(),
                EstadoEstudiante.RegistroPendiente );
    }
}