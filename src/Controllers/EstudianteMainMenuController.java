package Controllers;

import Utilities.ScreenChanger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sample.LoginSession;

public class EstudianteMainMenuController {
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
    private Text errorText;

    @FXML
    private Button reportButton;

    @FXML
    private Button DocumentsButton;

    @FXML
    private Button formButton;

    @FXML
    private Button projectButton;

    @FXML
    private Button chooseProjectButton;

    @FXML
    private Button logoutButton;

    public EstudianteMainMenuController() {
        nameText.setText( LoginSession.GetInstance().GetEstudiante().GetNombres() );
        lastNameText.setText( LoginSession.GetInstance().GetEstudiante().GetApellidos() );
        matriculaText.setText( LoginSession.GetInstance().GetEstudiante().GetMatricula() );
    }

    public void ShowReports(){

    }

    public void ShowAdditionalDocuments() {

    }

    public void ShowFormats() {

    }

    public void ShowAssignedProject() {

    }

    public void ShowChooseProjects() {

    }

    public void Logout( MouseEvent mouseEvent ) {
        LoginSession.GetInstance().Logout();
        screenChanger.ShowLoginScreen( mouseEvent, errorText );
    }
}