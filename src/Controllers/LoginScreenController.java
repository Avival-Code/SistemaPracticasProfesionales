/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 3 - mar - 2021
 * Descripción:
 * Clase encargada de manejar los eventos de la pantalla
 * IniciarSesión.
 */
package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import Utilities.ScreenChanger;

/**
 * Clase encargada de manejar los eventos de la pantalla
 * IniciarSesión.
 */
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

    /**
     * Cambia la pantalla de IniciarSesión a la pantalla Registro_Estudiante
     * @param mouseEvent el evento de mouse que inicia el cambio
     */
    public void ShowRegistryScreen( MouseEvent mouseEvent ) {
        screenChanger.showRegistryScreen( mouseEvent, errorText );
    }
}

