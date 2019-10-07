import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SquadController implements Initializable {



    public void goToHome(ActionEvent actionEvent) {
        Main.changeScreen("home");
    }

    public void goToCadSquad(ActionEvent actionEvent){
        Main.changeScreen("cadSquad");
    }

    public void goToEditSquad(ActionEvent actionEvent){
        Main.changeScreen("editSquad");
    }

    public void goToListSquad(ActionEvent actionEvent){
        Main.changeScreen("listSquad");
    }

    public void goToRemoveSquad(ActionEvent actionEvent){
        Main.changeScreen("removeSquad");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
