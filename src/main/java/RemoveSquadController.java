import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveSquadController implements Initializable {

    @FXML
    private TableView<?> tableSquad;

    public void goToSquad(ActionEvent actionEvent){
        Main.changeScreen("squad");
    }

    @FXML
    private void removeSquad(ActionEvent actionEvent) {
        Main.changeScreen("loading");

        //implementar a remoção da linha selecionada na tableview

        Main.changeScreen("squad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
