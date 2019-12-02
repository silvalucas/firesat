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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveProtectionAreaController implements Initializable {

    @FXML
    private TableView<Regiao> tableRegion;
    @FXML
    private TableColumn<Regiao, String> nome;
    @FXML
    private TableColumn<Regiao, String> nomelei;
    @FXML
    private TableColumn<Regiao, Esquadrao> esquadraoResponsavel;

    public void goToRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("protectionArea");
    }

    @FXML
    private void removeRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        /*ArrayList<Regiao> todos = new RegiaoDAO().RecuperaRegiao();
        todos.remove(tableRegion.getSelectionModel().getSelectedIndex());
        new RegiaoDAO().GravaRegiaoArray(todos);
        */
        Main.changeScreen("region");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*ObservableList<Regiao> lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiao());
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        nomelei.setCellValueFactory(new PropertyValueFactory<>("areaDeProtecao"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);*/
    }
}
