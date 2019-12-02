package Controle;

import DAO.RegiaoDAO;
import Main.Main;
import Modelo.Esquadrao;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListUrbanAreaController implements Initializable {

    @FXML
    private TableView<Regiao> tableRegion;
    @FXML
    private TableColumn<Regiao, String> nome;
    @FXML
    private TableColumn<Regiao, String> cidadepopulosa;
    @FXML
    private TableColumn<Regiao, Esquadrao> esquadraoResponsavel;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("urbanArea");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*ObservableList<Regiao> lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiao());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cidadepopulosa.setCellValueFactory(new PropertyValueFactory<>("cidadepopulosa"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);*/
    }
}
