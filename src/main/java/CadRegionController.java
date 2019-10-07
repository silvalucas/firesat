import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadRegionController implements Initializable {

    @FXML
    private ComboBox<?> comboSelectSquad;

    @FXML
    private CheckBox checkProtectYes;

    @FXML
    private TextField txtNome;

    public void goToRegion(ActionEvent actionEvent){
        Main.changeScreen("region");
    }

    @FXML
    private void concludeCadRegion(ActionEvent actionEvent) {
        Main.changeScreen("loading");
        //implementar a comunicação com o firebase
        Main.changeScreen("region");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
