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



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
