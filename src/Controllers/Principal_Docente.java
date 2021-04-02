package Controllers;

import Entities.UsuarioUV;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Principal_Docente implements Initializable {

    private UsuarioUV usuarioUV;

    @FXML
    private AnchorPane root;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbApellidos;
    @FXML
    private Label lbCedulaProfesional;
    @FXML
    private TableView tbvGrupo;
    @FXML
    private TableColumn tcMatricula;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcProyectoAsignado;
    @FXML
    private TableView tbvArchivosSubidos;
    @FXML
    private TableColumn tcNombreArchivo;
    @FXML
    private TableColumn tcDescripcion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setUsuario(UsuarioUV usuarioUV) {
        this.usuarioUV = usuarioUV;

        lbNombre.setText( usuarioUV.GetNombres() );
        lbApellidos.setText( usuarioUV.GetApellidos() );
    }


}
