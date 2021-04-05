package Controllers;

import Entities.Reporte;
import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import sample.LoginSession;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsScreenController implements Initializable {
    private FileChooser fileChoose = new FileChooser();
    private ScreenChanger screenChanger = new ScreenChanger();

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
    }

    private void SetUserInformation() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().GetNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    private void SetCellValueFactory() {
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "nombre" ) );
        keyColumn.setCellValueFactory( new PropertyValueFactory<>( "nombre" ) );
        dateColumn.setCellValueFactory( new PropertyValueFactory<>( "nombre" ) );
    }

    @FXML
    public void Return( MouseEvent mouseEvent ) {
        screenChanger.ShowStudentMainMenuScreen( mouseEvent, errorText );
    }

    @FXML
    public void TurnInReport( MouseEvent mouseEvent ) {

    }
}