import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveRegionController implements Initializable {

    @FXML
    private TableView<?> tableRegion;

    public void goToRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("region");
    }

    @FXML
    private void removeRegion(ActionEvent actionEvent) throws IOException {
        Main.changeScreen("loading");

        //implementar a remoção da linha selecionada na tableview

        Main.changeScreen("region");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //implementar preenchimento dados na tableview
    }
}
