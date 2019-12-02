package Controle;

import DAO.Conexao;
import DAO.RegiaoDAO;
import Main.Main;
import Modelo.AreaUrbana;
import Modelo.Esquadrao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ListUrbanAreaController implements Initializable {

    @FXML
    private TableView<AreaUrbana> tableRegion;
    @FXML
    private TableColumn<AreaUrbana, String> nome;
    @FXML
    private TableColumn<AreaUrbana, String> cidadePopulosa;
    @FXML
    private TableColumn<AreaUrbana, Esquadrao> esquadraoResponsavel;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("urbanArea");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection con = Conexao.getConnection();
        ObservableList<AreaUrbana> lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoArea(con));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cidadePopulosa.setCellValueFactory(new PropertyValueFactory<>("cidadePopulosa"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
    }
}
