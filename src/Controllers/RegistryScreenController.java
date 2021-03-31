package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Utilities.ScreenChanger;

public class RegistryScreenController {
    private ScreenChanger screenChanger = new ScreenChanger();

    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField usernameField;

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

    public void ShowLoginScreen( MouseEvent mouseEvent ) {
        screenChanger.showLoginScreen( mouseEvent, errorText );
    }
}