import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {

    @FXML
    private TableView<?> tableUser;

    public void goToUser(ActionEvent actionEvent){
        Main.changeScreen("user");
    }

    @FXML
    private void concludeEditUser(ActionEvent actionEvent) {
        Main.changeScreen("loading");

        //implementar as alterações feitas na table

        Main.changeScreen("user");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
