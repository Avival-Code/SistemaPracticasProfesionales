/*
 * Autor: Dan Javier Olvera Villeda
 * Versión: 1.0
 * Fecha Creación: 30 - mar - 2021
 * Descripción:
 * Clase encargada de manejar los eventos de la pantalla
 * Principal_Docente.
 */
package Controllers;

import Database.DocenteDAO;
import Database.EstudianteDAO;
import Entities.Docente;
import Entities.Estudiante;
import Utilities.ScreenChanger;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sample.LoginSession;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Principal_Docente implements Initializable {

    private EstudianteDAO estudianteDAO = new EstudianteDAO();
    private ObservableList< Estudiante > grupo;

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

    public void irPantallaDescargarArchivos( MouseEvent mouseEvent ) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
        setUsuario();
        recuperarGrupo();

    }

    public void recuperarGrupo() {
        String nrc = LoginSession.GetInstance().GetDocente().GetNrc();
        grupo = (ObservableList<Estudiante>) estudianteDAO.ReadByGroup( nrc );
    }

    public void setUsuario() {
        lbNombre.setText( LoginSession.GetInstance().GetDocente().GetNombres() );
        lbApellidos.setText( LoginSession.GetInstance().GetDocente().GetApellidos() );
        lbCedulaProfesional.setText( LoginSession.GetInstance().GetDocente().GetNumeroPersonal() );
    }

    public void Logout() {
        LoginSession.GetInstance().Logout();

    }


}
