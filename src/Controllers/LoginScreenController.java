package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import Utilities.ScreenChanger;


public class LoginScreenController {
    private ScreenChanger screenChanger = new ScreenChanger();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Text register;

    @FXML
    private Text recoverPassword;

    @FXML
    private Text errorText;

    public void ShowRegistryScreen( MouseEvent mouseEvent ) {
        screenChanger.showRegistryScreen( mouseEvent, errorText );
    }
}

