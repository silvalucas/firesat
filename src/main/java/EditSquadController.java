import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditSquadController implements Initializable {

    @FXML
    private TableView<?> tableSquad;

    public void goToSquad(ActionEvent actionEvent){
        Main.changeScreen("squad");
    }

    @FXML
    private void concludeEditSquad(ActionEvent actionEvent) {
        Main.changeScreen("loading");

        //implementar as alterações feitas na table

        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
