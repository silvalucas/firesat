package Controle;

import DAO.Conexao;
import DAO.RegiaoDAO;
import Modelo.AreaUrbana;
import Modelo.Esquadrao;
import Modelo.ProtecaoAmbiental;
import Modelo.Regiao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Main.Main;

import java.awt.geom.Area;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveUrbanAreaController implements Initializable {

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

    @FXML
    private void removeRegion(ActionEvent actionEvent) throws PaginaDesconhecidaException {
        Main.changeScreen("loading");

        AreaUrbana selecionado = tableRegion.getSelectionModel().getSelectedItem();
        ArrayList<AreaUrbana> todos = new RegiaoDAO().RecuperaRegiaoArea(Conexao.getConnection());

        for (int i = 0; i < todos.size(); i++) {
            AreaUrbana e = todos.get(i);
            if (e.getId() == (selecionado.getId())) {
                new RegiaoDAO().DeletaRegiao(e.getId());
                break;
            }
        }

        Main.changeScreen("urbanArea");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<AreaUrbana> lista = FXCollections.observableArrayList(new RegiaoDAO().RecuperaRegiaoArea(Conexao.getConnection()));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cidadePopulosa.setCellValueFactory(new PropertyValueFactory<>("cidadePopulosa"));
        esquadraoResponsavel.setCellValueFactory(new PropertyValueFactory<>("esquadrao"));
        tableRegion.setItems(lista);
    }
}
