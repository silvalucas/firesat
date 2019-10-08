import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

    @FXML
    private TableView<?> reportsTable;

    public void goToHome(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("home");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //preencher tableview
    }
}
