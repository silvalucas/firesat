import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListUserController implements Initializable {

    @FXML
    private TableView<?> tableUser;

    public void goToUser(ActionEvent actionEvent){
        Main.changeScreen("user");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
