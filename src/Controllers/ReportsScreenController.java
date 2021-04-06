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

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle ) {
        SetUserInformation();
        SetCellValueFactory();
        ConfigureFileChooser();
        ShowReports();
    }

    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().GetNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    private void SetCellValueFactory() {
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "titulo" ) );
        keyColumn.setCellValueFactory( new PropertyValueFactory<>( "idDocumento" ) );
        dateColumn.setCellValueFactory( new PropertyValueFactory<>( "fechaEntrega" ) );
    }

    private void ConfigureFileChooser() {
        fileChooser.setTitle( "Buscar Reporte..." );
    }

    private void ShowReports() {

    }

    @FXML
    public void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }

    @FXML
    public void TurnInReport( MouseEvent mouseEvent ) {
        File report = GetFile( mouseEvent );
        if( report != null ) {
            reportes.Create( GetReport( report ) );
        }
    }

    private File GetFile( MouseEvent mouseEvent ) {
        return fileChooser.showOpenDialog( ( (Node)mouseEvent.getSource() ).getScene().getWindow() );
    }

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

    private Reporte GetReport( File reportFile ) {
        LocalDate currentDate = LocalDate.now();
        return new Reporte( 0 , 0, reportFile.getName(), reportFile, currentDate.toString(),
                GetUserExpediente().GetClave(), 0, TipoReporte.cienHoras );
    }
}