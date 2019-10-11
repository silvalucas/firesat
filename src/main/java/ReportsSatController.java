import DAO.DadosImagemDAO;
import DAO.RegiaoDAO;
import Modelo.DadosImagem;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ReportsSatController implements Initializable {
    @FXML
    private TableColumn<DadosImagem, Integer> id;

    @FXML
    private TableColumn<DadosImagem, Date> data;

    @FXML
    private TableColumn<DadosImagem, String> nome;

    @FXML
    private TableColumn<DadosImagem, Boolean> baixada;


    @FXML
    private TableView<DadosImagem> reportsTable;

    public void goToHome(javafx.event.ActionEvent actionEvent) throws IOException {
        Main.changeScreen("HomeSat");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        baixada.setCellValueFactory(new PropertyValueFactory<>("baixada"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ObservableList<DadosImagem> lista = FXCollections.observableArrayList(
                new DadosImagemDAO().RecuperaDadosImagem(false));

        reportsTable.setItems(lista);

    }
}
