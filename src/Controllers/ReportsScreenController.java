/*
 * Autor: Christian Felipe de Jesus Avila Valdes
 * Versión: 1.0
 * Fecha Creación: 5 - abr - 2021
 * Descripción:
 * Clase encargada de manejar los eventos de la pantalla
 * Reportes_Estudiante.
 */
package Controllers;

import Database.ExpedienteDAO;
import Database.ProyectoDAO;
import Database.ReporteDAO;
import Entities.Expediente;
import Entities.Reporte;
import Enumerations.EstadoProyecto;
import Enumerations.TipoReporte;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import sample.LoginSession;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Clase encargada de manejar los eventos de la pantalla
 * Reportes_Estudiante.
 */
public class ReportsScreenController implements Initializable {
    private FileChooser fileChooser = new FileChooser();
    private ScreenChanger screenChanger = new ScreenChanger();
    private ReporteDAO reportes = new ReporteDAO();
    private ExpedienteDAO expedientes = new ExpedienteDAO();
    private ProyectoDAO proyectos = new ProyectoDAO();

    @FXML
    private Text nameText;

    @FXML
    private Text lastNameText;

    @FXML
    private Text matriculaText;

    @FXML
    private Text projectText;

    @FXML
    private Button returnButton;

    @FXML
    private Button entregarReporte;

    @FXML
    private Text errorText;

    @FXML
    private TableColumn< Reporte, String > nameColumn;

    @FXML
    private TableColumn< Reporte, String > keyColumn;

    @FXML
    private TableColumn< Reporte, String > dateColumn;

    /**
     * Configura los elementos utilizados en la pantalla EscogerProyectos_Estudiante
     * @param url un url sin utilizar
     * @param resourceBundle un conjunto de recursos no utilizados
     */
    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        SetUserInformation();
        SetCellValueFactory();
        ConfigureFileChooser();
        ShowReports();
    }

    /**
     * Coloca la información del usuario actual en los campos de texto
     * nameText, lastNameText y matriculaText
     */
    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().GetNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    /**
     * Configura las columnas de la tabla mostrada en esta pantalla
     */
    private void SetCellValueFactory() {
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "titulo" ) );
        keyColumn.setCellValueFactory( new PropertyValueFactory<>( "idDocumento" ) );
        dateColumn.setCellValueFactory( new PropertyValueFactory<>( "fechaEntrega" ) );
    }

    /**
     * Configura lo que se muestra en el explorador de archivos
     * creado por fileChooser
     */
    private void ConfigureFileChooser() {
        fileChooser.setTitle( "Buscar Reporte..." );
    }

    /**
     * Muestra todos los reportes almacenados en la base de datos del estudiante
     * actual
     */
    private void ShowReports() {

    }

    /**
     * Regresa a la pantalla principal de estudiante
     * @param mouseEvent el evento que invocó el método
     */
    @FXML
    public void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }

    /**
     * Almacena el reporte entregado en la base de datos
     * @param mouseEvent el evento que invocó el método
     */
    @FXML
    public void TurnInReport( MouseEvent mouseEvent ) {
        File report = GetFile( mouseEvent );
        if( report != null ) {
            reportes.Create( GetReport( report ) );
        }
    }

    /**
     * Regresa el archivo seleccionado por el usuario
     * @param mouseEvent el evento que invocó el método
     * @return una instancia del archivo seleccionado tipo File
     */
    private File GetFile( MouseEvent mouseEvent ) {
        return fileChooser.showOpenDialog( ( (Node)mouseEvent.getSource() ).getScene().getWindow() );
    }

    /**
     * Regresa el expediente del estudiante actual
     * @return una instancia del expediente del estudiante actual
     */
    private Expediente GetUserExpediente() {
        List< Expediente > expedienteList = expedientes.ReadAll();
        Expediente userExpediente = null;
        for( Expediente expediente : expedienteList ) {
            if( expediente.GetMatricula().equals( LoginSession.GetInstance().GetEstudiante().GetMatricula() ) &&
                proyectos.Read( expediente.GetIDProyecto() ).GetEstado() == EstadoProyecto.Asignado ) {
                userExpediente = expediente;
            }
        }
        return userExpediente;
    }

    /**
     * Regresa una instancia de Reporte para ser
     * almacenado en la base de datos
     * @param reportFile el archivo que se desea almacenar como reporte
     * @return una instancia de Reporte
     */
    private Reporte GetReport( File reportFile ) {
        LocalDate currentDate = LocalDate.now();
        return new Reporte( 0 , 0, reportFile.getName(), reportFile, currentDate.toString(),
                GetUserExpediente().GetClave(), 0, TipoReporte.cienHoras );
    }
}