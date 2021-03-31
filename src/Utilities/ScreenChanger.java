package Utilities;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ScreenChanger {
    private OutputMessages outputMessages = new OutputMessages();
    private String loginScreen = "../Resources/LoginScreen.fxml";
    private String registryScreen = "../Resources/RegistryScreen.fxml";

    public void showLoginScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, loginScreen );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.LoginScreenMissing() );
        }
    }

    public void showRegistryScreen( MouseEvent mouseEvent, Text errorText ) {
        try {
            SetScene( mouseEvent, registryScreen );
        } catch( IOException exception ) {
            errorText.setText( outputMessages.RegistryScreenMissing() );
        }
    }

    private void SetScene( MouseEvent mouseEvent, String resourceName ) throws IOException {
        try {
            Parent newView = FXMLLoader.load( getClass().getResource( resourceName ) );
            Scene sceneView = new Scene( newView );
            Stage window = ( Stage )( ( Node )mouseEvent.getSource() ).getScene().getWindow();
            window.setScene( sceneView );
            window.show();
        } catch( IOException exception ) {
            throw exception;
        }
    }
}