import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListRegionController implements Initializable {

    @FXML
    private TableView<?> tableRegion;

    public void goToRegion(ActionEvent actionEvent){
        Main.changeScreen("region");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
