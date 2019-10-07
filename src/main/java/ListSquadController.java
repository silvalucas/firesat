import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListSquadController implements Initializable {

    @FXML
    private TableView<?> tableSquad;

    public void goToSquad(ActionEvent actionEvent){
        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
