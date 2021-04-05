/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 4 - abr - 2021
 * Descripción:
 * Clase encargada de manejar los eventos de la pantalla
 * EscogerProyectos_Estudiante.
 */
package Controllers;


import Database.ProyectoDAO;
import Entities.Proyecto;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SelectProjectsController implements Initializable {
    private ScreenChanger screenChanger = new ScreenChanger();
    private ProyectoDAO proyectos = new ProyectoDAO();
    private List< Proyecto > listaProyectos = new ArrayList< Proyecto >();

    @FXML
    private Text nameText;

    @FXML
    private Text lastNameText;

    @FXML
    private Text matriculaText;

    @FXML
    private Text projectText;

    @FXML
    private Text projectDetails;

    @FXML
    private Text errorText;

    @FXML
    private TableView< Proyecto > availableProjectsTable;

    @FXML
    private TableView< Proyecto > selectedProjectsTable;

    @FXML
    private TableColumn< Proyecto, String > availableProjectName;

    @FXML
    private TableColumn< Proyecto, String > availableProjectKey;

    @FXML
    private TableColumn< Proyecto, String > availableTotalSpace;

    @FXML
    private TableColumn< Proyecto, String > availableOrganization;

    @FXML
    private TableColumn< Proyecto, String > chosenName;

    @FXML
    private TableColumn< Proyecto, String > chosenKey;

    @FXML
    private TableColumn< Proyecto, String > chosenOrganization;

    @FXML
    private Button returnButton;

    @FXML
    private Button deleteProjectButton;

    @FXML
    private Button sendSelectedProjectsButton;

    @FXML
    private Button selectProjectButton;

    @FXML
    public void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        availableProjectName.setCellValueFactory( new PropertyValueFactory<>( "nombre" ) );
        availableProjectKey.setCellValueFactory( new PropertyValueFactory<>( "idProyecto" ) );
        availableTotalSpace.setCellValueFactory( new PropertyValueFactory<>( "numEstudiantesRequeridos" ) );

        chosenName.setCellValueFactory( new PropertyValueFactory<>( "nombre" ) );
        chosenKey.setCellValueFactory( new PropertyValueFactory<>( "idProyecto" ) );

        listaProyectos = proyectos.ReadAll();
        for( Proyecto proyecto : listaProyectos ) {
            availableProjectsTable.getItems().add( proyecto );
        }
    }

    public void SelectProject() {

    }

    public void RemoveProject() {

    }

    public void SendSelection() {

    }
}