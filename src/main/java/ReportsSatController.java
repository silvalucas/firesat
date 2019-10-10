import DAO.RegiaoDAO;
import Modelo.DadosImagem;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportsSatController implements Initializable {

    @FXML
    private TableView<DadosImagem> reportsTable;

    public void goToHome(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("HomeSat");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //preencher a tabela

    }
}
