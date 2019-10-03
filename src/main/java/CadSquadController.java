import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadSquadController implements Initializable {

    @FXML
    private TextField nomeTxt;

    @FXML
    private TextField soldiersTxt;

    @FXML
    private TextField specialtyTxt;

    public void goToSquad(ActionEvent actionEvent){
        Main.changeScreen("squad");
    }

    @FXML
    void concludeCadSquad(ActionEvent event) {
        Main.changeScreen("loading");
        //implementar a comunicação com o firebase

        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
